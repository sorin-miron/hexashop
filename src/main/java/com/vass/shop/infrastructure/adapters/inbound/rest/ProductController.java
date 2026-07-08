package com.vass.shop.infrastructure.adapters.inbound.rest;

import com.vass.shop.application.ports.inbound.ProductUseCase;
import com.vass.shop.domain.model.Product;
import com.vass.shop.infrastructure.adapters.inbound.rest.api.ProductsApi;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.ProductRequest;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController implements ProductsApi {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @Override
    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest) {
        Product product = new Product(
                UUID.randomUUID(),
                productRequest.getName(),
                productRequest.getPrice()
        );
        Product savedProduct = productUseCase.createProduct(product);
        return new ResponseEntity<>(mapToResponse(savedProduct), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductResponse> getProductById(UUID productId) {
        Product product = productUseCase.getProduct(productId);
        return ResponseEntity.ok(mapToResponse(product));
    }

    @Override
    public ResponseEntity<List<ProductResponse>> listProducts(Integer limit) {
        // TODO: de facut
        return null;
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(UUID productId, ProductRequest productRequest) {
        Product productDetails = new Product(productId, productRequest.getName(), productRequest.getPrice());
        Product updatedProduct = productUseCase.updateProduct(productId, productDetails);
        return ResponseEntity.ok(mapToResponse(updatedProduct));
    }

    @Override
    public ResponseEntity<Void> deleteProduct(UUID productId) {
        productUseCase.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    private ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.id());
        response.setName(product.name());
        response.setPrice(product.price());
        return response;
    }
}
