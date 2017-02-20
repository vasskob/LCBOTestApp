package com.obezhenar.lcbotestapp.screens.search.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.screens.common.LoadingListItemCreatorImpl;
import com.obezhenar.lcbotestapp.screens.common.OnItemClickListener;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowProductDetailsEvent;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
import com.obezhenar.lcbotestapp.screens.products.view.ProductsView;
import com.obezhenar.lcbotestapp.screens.products.view.list.ProductsListAdapter;
import com.obezhenar.lcbotestapp.screens.search.presenter.SearchByProductsPresenter;
import com.paginate.Paginate;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchByProductsFragment extends Fragment implements
        SearchByProductsView, OnItemClickListener<ProductViewModel> {
    @Inject
    SearchByProductsPresenter presenter;

    @BindView(R.id.rv_search_results)
    RecyclerView searchResultsRecyclerView;

    @BindView(R.id.tv_no_results)
    TextView noResultsTextView;

    private ProductsListAdapter adapter = new ProductsListAdapter(this);
    private boolean isLoading;
    private boolean isAllLoaded = false;
    private boolean isSeasonal;
    private boolean isKocher;
    private boolean hasLimitedTimeOffer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LcboApplication.dependencyGraph.initSearchByProductsComponent().inject(this);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchResultsRecyclerView.setAdapter(adapter);
        initPagination();
        presenter.attach(this);
        presenter.onSearchQuery("");
    }

    private void initPagination() {
        Paginate.with(searchResultsRecyclerView, new Paginate.Callbacks() {
            @Override
            public void onLoadMore() {
                isLoading = true;
                presenter.loadMore();
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return isAllLoaded;
            }
        }).setLoadingTriggerThreshold(2)
                .addLoadingListItem(true)
                .setLoadingListItemCreator(new LoadingListItemCreatorImpl())
                .build();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_search, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(getContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.onSearchQuery(newText);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search_filter)
            showFilterDialog();
        if (item.getItemId() == android.R.id.home)
            presenter.onSearchQuery("");
            return true;
    }

    private void showFilterDialog() {
        View dialogView = LayoutInflater.from(getContext())
                .inflate(R.layout.dialog_products_search_filter, null, false);
        CheckBox isSeasonalCheckBox = ButterKnife.findById(dialogView, R.id.cb_is_seasonal);
        CheckBox isKosherCheckBox = ButterKnife.findById(dialogView, R.id.cb_is_kosher);
        CheckBox hasLimitedTimeOfferCheckBox = ButterKnife.findById(dialogView, R.id.cb_has_limited_time_offer);
        isSeasonalCheckBox.setChecked(isSeasonal);
        isKosherCheckBox.setChecked(isKocher);
        hasLimitedTimeOfferCheckBox.setChecked(hasLimitedTimeOffer);
        new AlertDialog.Builder(getContext())
                .setTitle(R.string.filter)
                .setView(dialogView)
                .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {
                    isSeasonal = isSeasonalCheckBox.isChecked();
                    isKocher = isKosherCheckBox.isChecked();
                    hasLimitedTimeOffer = hasLimitedTimeOfferCheckBox.isChecked();
                    presenter.onFilterSettingsChanged(
                            isSeasonal,
                            isKocher,
                            hasLimitedTimeOffer
                    );
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create()
                .show();
    }

    @Override
    public void onItemClick(View itemView, ProductViewModel item) {
        EventBus.getDefault().post(new ShowProductDetailsEvent(item.getId()));
    }

    @Override
    public void displaySearchResults(List<ProductViewModel> results) {
        isAllLoaded = false;
        searchResultsRecyclerView.setVisibility(View.VISIBLE);
        noResultsTextView.setVisibility(View.GONE);
        adapter.setItems(results);
    }

    @Override
    public void displayMore(List<ProductViewModel> results) {
        if (results.size() == 0)
            isAllLoaded = true;
        adapter.addToEnd(results);
    }

    @Override
    public void showNoResults() {
        searchResultsRecyclerView.setVisibility(View.GONE);
        noResultsTextView.setVisibility(View.VISIBLE);
        noResultsTextView.setText(R.string.no_results);
    }

    @Override
    public void setShowProgress(boolean showProgress) {
        if (showProgress) {
            searchResultsRecyclerView.setVisibility(View.GONE);
        } else {
            searchResultsRecyclerView.setVisibility(View.VISIBLE);
        }
        isLoading = showProgress;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LcboApplication.dependencyGraph.releaseSearchByProductsComponent();
    }
}
