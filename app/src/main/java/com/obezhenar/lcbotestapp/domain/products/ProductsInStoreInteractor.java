package com.obezhenar.lcbotestapp.domain.products;

import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Inventory;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.storage.base.InventorySpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

public class ProductsInStoreInteractor implements Interactor<Long, Observable<List<Product>>> {
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
    public Observable<List<Product>> invoke(Long data) {
        return Observable.create(subscriber -> {
            downloadProductsInStore(data, subscriber);
        });
    }

    private void downloadProductsInStore(Long storeId, Subscriber subscriber) {
        try {
            Response<ApiResponse<List<Product>>> response = storesService
                    .loadProductsInStore(storeId).execute();
            if (response.isSuccessful()) {
                List<Product> products = response.body().getData();
                productRepository.addAll(products); //caching products
                subscriber.onNext(products);
                for (Product product : products) loadInventoryByProductId(storeId, product.getId());
            } else {
                loadProductsInStoreFromDb(storeId, subscriber);
            }
        } catch (IOException e) {
            e.printStackTrace();
            loadProductsInStoreFromDb(storeId, subscriber);
        }
    }

    private void loadInventoryByProductId(long storeId, long productId) throws IOException {
        Response<ApiResponse<Inventory>> inventoryResponse = storesService
                .loadInventoryFromProductInStore(storeId, productId).execute();
        if (inventoryResponse.isSuccessful())
            inventoryRepository.add(inventoryResponse.body().getData());
    }

    private void loadProductsInStoreFromDb(long storeId, Subscriber subscriber) {
        List<Inventory> inventories = inventoryRepository.query(
                inventorySpecificationFactory.createInventoryByStoreIdSpecification(storeId));
        if (inventories != null && !inventories.isEmpty()) {
            List<Product> productsInStore = new ArrayList<Product>();
            for (Inventory inventory : inventories) {
                Product product = productRepository.query(
                        productSpecificationFactory.creteProductByIdSpecification(inventory.getProductId())
                ).get(0);
                if (product != null) productsInStore.add(product);
            }
            subscriber.onNext(productsInStore);
        } else subscriber.onNext(new ArrayList<Product>());
    }
}
