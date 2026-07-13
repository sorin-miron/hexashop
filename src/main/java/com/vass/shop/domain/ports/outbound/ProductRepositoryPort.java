package com.vass.shop.domain.ports.outbound;

import com.vass.shop.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(UUID id);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
