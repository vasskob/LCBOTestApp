package com.obezhenar.lcbotestapp.screens.products.presenter;

import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
import com.obezhenar.lcbotestapp.screens.products.view.ProductsView;

public interface ProductsPresenter {
    void attachToView(ProductsView view);

    void onProductClick(ProductViewModel productViewModel);

    void loadProductsForStore(long storeId);

    void loadAllProducts();
}
