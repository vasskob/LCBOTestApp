package com.obezhenar.lcbotestapp.screens.stores.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowStoreDetailsEvent;
import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;
import com.obezhenar.lcbotestapp.screens.stores.model.StoresFilter;
import com.obezhenar.lcbotestapp.screens.stores.presenter.StoresPresenter;
import com.obezhenar.lcbotestapp.screens.stores.view.list.StoresListAdapter;
import com.obezhenar.lcbotestapp.screens.stores.view.list.StoresLoadingListItemCreator;
import com.paginate.Paginate;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresFragment extends Fragment implements StoresView {
    @BindView(R.id.rv_stores)
    RecyclerView storesRecyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @Inject
    StoresPresenter presenter;
    private boolean isItmesLoading;
    private boolean hasLoadAllItems;

    private StoresFilter storesFilter = new StoresFilter();

    private StoresListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LcboApplication.dependencyGraph.initStoresComponent().inject(this);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stores_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new StoresListAdapter((itemView, item) -> presenter.onStoreClick(item));
        storesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        storesRecyclerView.setAdapter(adapter);
        presenter.attach(this);
        presenter.loadStores(storesFilter);
        initPagination();
    }

    private void initPagination() {
        Paginate.with(storesRecyclerView, new Paginate.Callbacks() {
            @Override
            public void onLoadMore() {
                isItmesLoading = true;
                presenter.onLoadMore();
            }

            @Override
            public boolean isLoading() {
                return isItmesLoading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return hasLoadAllItems;
            }
        }).setLoadingTriggerThreshold(2)
                .addLoadingListItem(true)
                .setLoadingListItemCreator(new StoresLoadingListItemCreator())
                .build();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_filter, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_filter)
            showFilterDialog();
        return true;
    }

    private void showFilterDialog() {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_filter, null, false);
        CheckBox hasWheelchairAccessabilityCheckBox = ButterKnife.findById(dialogView, R.id.cb_has_wheelchair_accessability);
        CheckBox hasParkingCheckBox = ButterKnife.findById(dialogView, R.id.cb_has_parking);
        CheckBox hasBilingualServicesCheckBox = ButterKnife.findById(dialogView, R.id.cb_has_bilingual_services);
        CheckBox hasTastingBarCheckBox = ButterKnife.findById(dialogView, R.id.cb_has_tasting_bar);
        CheckBox hasBeerColdRoomCheckBox = ButterKnife.findById(dialogView, R.id.cb_has_beer_cold_room);
        CheckBox hasVintagesCornerCheckBox = ButterKnife.findById(dialogView, R.id.cb_has_vintages_corner);
        hasWheelchairAccessabilityCheckBox.setChecked(storesFilter.getHasWheelChairAccessibility() != null);
        hasParkingCheckBox.setChecked(storesFilter.getHasParking() != null);
        hasBilingualServicesCheckBox.setChecked(storesFilter.getHasBilingualServices() != null);
        hasTastingBarCheckBox.setChecked(storesFilter.getHasTastingBar() != null);
        hasBeerColdRoomCheckBox.setChecked(storesFilter.getHasBeerColdRoom() != null);
        hasVintagesCornerCheckBox.setChecked(storesFilter.getHasVintagesCorner() != null);
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setView(dialogView)
                .setTitle(R.string.stores_filter)
                .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {
                    storesFilter.setHasWheelChairAccessibility(
                            hasWheelchairAccessabilityCheckBox.isChecked() ? Boolean.TRUE : null);
                    storesFilter.setHasParking(
                            hasParkingCheckBox.isChecked() ? Boolean.TRUE : null);
                    storesFilter.setHasBilingualServices(
                            hasBilingualServicesCheckBox.isChecked() ? Boolean.TRUE : null);
                    storesFilter.setHasTastingBar(
                            hasTastingBarCheckBox.isChecked() ? Boolean.TRUE : null);
                    storesFilter.setHasBeerColdRoom(
                            hasBeerColdRoomCheckBox.isChecked() ? Boolean.TRUE : null);
                    storesFilter.setHasVintagesCorner(
                            hasVintagesCornerCheckBox.isChecked() ? Boolean.TRUE : null);
                    presenter.loadStores(storesFilter);
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.show();
    }

    @Override
    public void displayStores(List<StoreModel> stores) {
        if (stores.size() == 0)
            hasLoadAllItems = true;
        isItmesLoading = false;
        if (stores != null)
            adapter.setData(stores);
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStoreDetails(StoreModel storeModel) {
        EventBus.getDefault().post(new ShowStoreDetailsEvent(storeModel.getId()));
    }

    @Override
    public void setShowProgress(boolean showProgress) {
        storesRecyclerView.setVisibility(showProgress && !isItmesLoading ? View.GONE : View.VISIBLE);
        progressBar.setVisibility(showProgress && !isItmesLoading ? View.VISIBLE : View.GONE);
    }

    @Override
    public void clearList() {
        hasLoadAllItems = false;
        adapter.clearData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LcboApplication.dependencyGraph.releaseStoresComponent();
        presenter.release();
    }
}
