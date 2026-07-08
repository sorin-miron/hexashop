package com.vass.shop.application.service;

import com.vass.shop.application.ports.inbound.ProductUseCase;
import com.vass.shop.application.ports.outbound.ProductRepositoryPort;
import com.vass.shop.domain.model.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.save(product);
    }

    @Override
    public Product getProduct(UUID id) {
        return productRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + id));
    }

    @Override
    public Product updateProduct(UUID id, Product productDetails) {
        if (!productRepositoryPort.existsById(id)) {
            throw new EntityNotFoundException("Product not found with ID: " + id);
        }
        Product updatedProduct = new Product(id, productDetails.name(), productDetails.price());
        return productRepositoryPort.save(updatedProduct);
    }

    @Override
    public void deleteProduct(UUID id) {
        if (!productRepositoryPort.existsById(id)) {
            throw new EntityNotFoundException("Product not found with ID: " + id);
        }
        productRepositoryPort.deleteById(id);
    }
}
