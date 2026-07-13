package com.vass.shop.domain.ports.inbound;

import com.vass.shop.domain.model.Product;

import java.util.UUID;

public interface ProductUseCase {
    Product createProduct(Product product);
    Product getProduct(UUID id);
    Product updateProduct(UUID id, Product product);
    void deleteProduct(UUID id);
}
