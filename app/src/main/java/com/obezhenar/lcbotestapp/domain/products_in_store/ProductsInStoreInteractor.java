package com.obezhenar.lcbotestapp.domain.products_in_store;

import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Inventory;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.products_in_store.model.request.ProductsInStoreRequestModel;
import com.obezhenar.lcbotestapp.storage.base.InventorySpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

public class ProductsInStoreInteractor implements Interactor<ProductsInStoreRequestModel, Observable<List<Product>>> {
    private static final int PRODUCTS_PER_PAGE = 20;
    private StoresService storesService;
    private ProductSpecificationFactory productSpecificationFactory;
    private InventorySpecificationFactory inventorySpecificationFactory;
    private Repository<Inventory> inventoryRepository;
    private Repository<Product> productRepository;

    public ProductsInStoreInteractor(
            StoresService storesService,
            ProductSpecificationFactory productSpecificationFactory,
            InventorySpecificationFactory inventorySpecificationFactory,
            Repository<Inventory> inventoryRepository,
            Repository<Product> productRepository) {
        this.storesService = storesService;
        this.productSpecificationFactory = productSpecificationFactory;
        this.inventorySpecificationFactory = inventorySpecificationFactory;
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Observable<List<Product>> invoke(ProductsInStoreRequestModel data) {
        return Observable.create(subscriber -> {
            downloadProductsInStore(data, subscriber);
        });
    }

    private void downloadProductsInStore(ProductsInStoreRequestModel data, Subscriber subscriber) {
        try {
            Response<ApiResponse<List<Product>>> response = storesService
                    .loadProductsInStore(
                            data.getStoreId(),
                            data.getPage(),
                            data.getCategory()

                    ).execute();
            if (response.isSuccessful()) {
                List<Product> products = response.body().getData();
                productRepository.addAll(products); //caching products
                subscriber.onNext(products);
                for (Product product : products)
                    loadInventoryByProductId(data.getStoreId(), product.getId());
            } else {
                loadProductsInStoreFromDb(data.getStoreId(), data.getPage(), subscriber);
            }
        } catch (IOException e) {
            e.printStackTrace();
            loadProductsInStoreFromDb(data.getStoreId(), data.getPage(), subscriber);
        }
    }

    private void loadInventoryByProductId(long storeId, long productId) throws IOException {
        Response<ApiResponse<Inventory>> inventoryResponse = storesService
                .loadInventoryFromProductInStore(storeId, productId).execute();
        if (inventoryResponse.isSuccessful())
            inventoryRepository.add(inventoryResponse.body().getData());
    }

    private void loadProductsInStoreFromDb(long storeId, int page, Subscriber subscriber) {
        List<Inventory> inventories = inventoryRepository.query(
                inventorySpecificationFactory.createInventoryByStoreIdSpecification(storeId));
        if (inventories != null && !inventories.isEmpty()) {
            List<Product> productsInStore = new ArrayList<Product>();
            for (Inventory inventory : inventories) {
                Product product = productRepository.query(
                        productSpecificationFactory.creteProductByIdSpecification(
                                inventory.getProductId(),
                                (page - 1) * PRODUCTS_PER_PAGE,
                                ((page - 1) * PRODUCTS_PER_PAGE) + PRODUCTS_PER_PAGE)).get(0);
                if (product != null) productsInStore.add(product);
            }
            subscriber.onNext(productsInStore);
        } else subscriber.onNext(new ArrayList<Product>());
    }
}
