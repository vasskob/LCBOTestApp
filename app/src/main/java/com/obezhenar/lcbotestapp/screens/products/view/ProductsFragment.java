package com.obezhenar.lcbotestapp.screens.products.view;

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
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
import com.obezhenar.lcbotestapp.screens.products.presenter.ProductsPresenter;
import com.obezhenar.lcbotestapp.screens.products.view.list.ProductsListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsFragment extends Fragment implements ProductsView {
    private static final String KEY_STORE_ID = ProductsFragment.class.getName() + ".KEY_STORE_ID";
    @Inject
    ProductsPresenter presenter;
    @BindView(R.id.rv_products)
    RecyclerView productsRecyclerView;
    private ProductsListAdapter adapter;
    private long storeId;

    public static ProductsFragment newInstance(long storeId) {
        Bundle args = new Bundle();
        args.putLong(KEY_STORE_ID, storeId);
        ProductsFragment instance = new ProductsFragment();
        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LcboApplication.dependencyGraph.initProductComponent().inject(this);
        storeId = getArguments().getLong(KEY_STORE_ID, -1);
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
        presenter.loadProductsForStore(storeId);
    }

    @Override
    public void displayProducts(List<ProductViewModel> products) {
        adapter.addToEnd(products);
    }

    @Override
    public void displayNoProducts() {
        Toast.makeText(getContext(), "No products", Toast.LENGTH_SHORT);
    }

    @Override
    public void setShowProgress(boolean showProgress) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LcboApplication.dependencyGraph.releaseProductsComponent();
    }
}
