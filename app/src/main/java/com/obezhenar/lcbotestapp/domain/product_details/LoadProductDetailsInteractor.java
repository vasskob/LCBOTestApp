package com.obezhenar.lcbotestapp.domain.product_details;

import com.obezhenar.lcbotestapp.api.ProductsService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;

import java.io.IOException;

import retrofit2.Response;
import rx.Observable;

public class LoadProductDetailsInteractor implements Interactor<Long, Observable<Product>> {
    private ProductSpecificationFactory productSpecificationFactory;
    private ProductsService service;
    private Repository<Product> productRepository;

    public LoadProductDetailsInteractor(
            ProductSpecificationFactory productSpecificationFactory,
            ProductsService service,
            Repository<Product> productRepository) {
        this.productSpecificationFactory = productSpecificationFactory;
        this.service = service;
        this.productRepository = productRepository;
    }

    @Override
    public Observable<Product> invoke(Long data) {
        return Observable.create(subscriber -> {
            try {
                Response<ApiResponse<Product>> response = service.loadProductById(data).execute();
                if (response.isSuccessful())
                    productRepository.add(response.body().getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Product product = productRepository.query(
                    productSpecificationFactory.creteProductByIdSpecification(data, "", 0, 1)
            ).get(0);
            if (product != null)
                subscriber.onNext(product);
        });
    }
}
