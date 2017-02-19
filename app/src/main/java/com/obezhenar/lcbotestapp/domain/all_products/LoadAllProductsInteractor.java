package com.obezhenar.lcbotestapp.domain.all_products;

import com.obezhenar.lcbotestapp.api.stores.ProductsService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.all_products.model.request.LoadAllProductsRequestModel;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;

public class LoadAllProductsInteractor implements Interactor<LoadAllProductsRequestModel, Observable<List<Product>>> {
    private ProductsService productsService;
    private Repository<Product> productRepository;
    private ProductSpecificationFactory productSpecificationFactory;

    public LoadAllProductsInteractor(
            ProductsService productsService,
            Repository<Product> productRepository,
            ProductSpecificationFactory productSpecificationFactory) {
        this.productsService = productsService;
        this.productRepository = productRepository;
        this.productSpecificationFactory = productSpecificationFactory;
    }

    @Override
    public Observable<List<Product>> invoke(LoadAllProductsRequestModel data) {
        return Observable.create(subscriber -> {
            try {
                Response<ApiResponse<List<Product>>> response = productsService
                        .loadAllProductsByQuery(data.getQuery()).execute();
                if (response.isSuccessful()) {
                    productRepository.addAll(response.body().getData());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            subscriber.onNext(productRepository.query(
                    productSpecificationFactory.createProductsByQuerySpecification(
                            data.getQuery(),
                            (data.getPage() - 1) * 20,
                            ((data.getPage() - 1) * 20) + 20
                    )
            ));
        });
    }
}
