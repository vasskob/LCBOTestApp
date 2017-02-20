package com.obezhenar.lcbotestapp.domain.search;

import com.obezhenar.lcbotestapp.api.ProductsService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import rx.Observable;

public class ProductSearchInteractor
        implements Interactor<ProductsSearchRequestModel, Observable<List<Product>>> {

    private ProductSpecificationFactory specificationFactory;
    private Repository<Product> productRepository;
    private ProductsService productsService;

    public ProductSearchInteractor(
            ProductSpecificationFactory specificationFactory,
            Repository<Product> productRepository,
            ProductsService productsService) {
        this.specificationFactory = specificationFactory;
        this.productRepository = productRepository;
        this.productsService = productsService;
    }

    @Override
    public Observable<List<Product>> invoke(ProductsSearchRequestModel data) {
        return Observable.create(subscriber -> {
            try {
                Response<ApiResponse<List<Product>>> response = productsService.loadAllProductsByQuery(
                        data.getQuery(),
                        prepareWhere(data),
                        data.getPage()
                ).execute();
                if (response.isSuccessful()) {
                    productRepository.addAll(response.body().getData());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<Product> products = productRepository.query(
                    specificationFactory.createSearchBuProductsSpecification(data));
            subscriber.onNext(products);
        });
    }

    private String prepareWhere(ProductsSearchRequestModel data) {
        StringBuilder sb = new StringBuilder();
        if (data.isSeasonal())
            sb.append("is_seasonal").append(',');
        if (data.isKosher())
            sb.append("is_kosher").append(',');
        if (data.isHasLimitedOffer())
            sb.append("has_limited_time_offer");
        return sb.toString();
    }
}
