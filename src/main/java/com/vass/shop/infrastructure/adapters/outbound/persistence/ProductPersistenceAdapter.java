package com.vass.shop.infrastructure.adapters.outbound.persistence;

import com.vass.shop.application.ports.outbound.ProductRepositoryPort;
import com.vass.shop.domain.model.Product;
import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.ProductEntity;
import com.vass.shop.infrastructure.adapters.outbound.persistence.repository.ProductJPARepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ProductPersistenceAdapter implements ProductRepositoryPort {

    private final ProductJPARepository repository;

    public ProductPersistenceAdapter(ProductJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(product.id(), product.name(), product.price());
        ProductEntity saved = repository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return repository.findById(id).map(this::mapToDomain);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    private Product mapToDomain(ProductEntity entity) {
        return new Product(entity.getId(), entity.getName(), entity.getPrice());
    }
}

