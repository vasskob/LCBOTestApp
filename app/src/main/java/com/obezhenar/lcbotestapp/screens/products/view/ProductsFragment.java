package com.obezhenar.lcbotestapp.screens.products.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.screens.common.LoadingListItemCreatorImpl;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
import com.obezhenar.lcbotestapp.screens.products.presenter.ProductsPresenter;
import com.obezhenar.lcbotestapp.screens.products.view.list.ProductsListAdapter;
import com.paginate.Paginate;

import java.security.PublicKey;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsFragment extends Fragment implements ProductsView {
    public static final String TAG = ProductsFragment.class.getName();
    private static final String KEY_STORE_ID = ProductsFragment.class.getName() + ".KEY_STORE_ID";
    private static final String KEY_PRODUCT_CATEGORY = ProductsFragment.class.getName() + ".KEY_PRODUCT_CATEGORY";
    @Inject
    ProductsPresenter presenter;
    @BindView(R.id.rv_products)
    RecyclerView productsRecyclerView;
    private ProductsListAdapter adapter;
    private long storeId;
    private boolean isItemsLoading;
    private boolean hasLoadAllItems;
    private int page = 1;
    private String productsCategory;

    public static ProductsFragment newInstance(
            long storeId,
            String productsCategory) {
        Bundle args = new Bundle();
        args.putLong(KEY_STORE_ID, storeId);
        args.putString(KEY_PRODUCT_CATEGORY, productsCategory);
        ProductsFragment instance = new ProductsFragment();
        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LcboApplication.dependencyGraph.initProductComponent().inject(this);
        storeId = getArguments().getLong(KEY_STORE_ID, -1);
        productsCategory = getArguments().getString(KEY_PRODUCT_CATEGORY, "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_products, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = new ProductsListAdapter((itemView, item) -> presenter.onProductClick(item));
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        productsRecyclerView.setAdapter(adapter);
        presenter.attachToView(this);
        initPagination();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LcboApplication.dependencyGraph.releaseProductsComponent();
    }

    private void initPagination() {
        Paginate.with(productsRecyclerView, new Paginate.Callbacks() {
            @Override
            public void onLoadMore() {
                isItemsLoading = true;
                presenter.loadProductsForStore(storeId, page, productsCategory);
            }

            @Override
            public boolean isLoading() {
                return isItemsLoading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return hasLoadAllItems;
            }
        }).setLoadingTriggerThreshold(2)
                .addLoadingListItem(true)
                .setLoadingListItemCreator(new LoadingListItemCreatorImpl())
                .build();
    }

    @Override
    public void displayProducts(List<ProductViewModel> products) {
        adapter.addToEnd(products);
        isItemsLoading = false;
        if (products.size() == 0)
            hasLoadAllItems = true;
        else page++;
    }

    @Override
    public void displayNoProducts() {
        isItemsLoading = false;
        Toast.makeText(getContext(), "Could not load products", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setShowProgress(boolean showProgress) {

    }
}
