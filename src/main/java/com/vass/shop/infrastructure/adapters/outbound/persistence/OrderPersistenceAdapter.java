package com.vass.shop.infrastructure.adapters.outbound.persistence;

import com.vass.shop.application.ports.outbound.OrderRepositoryPort;
import com.vass.shop.domain.model.Cart;
import com.vass.shop.domain.model.Product;
import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.OrderItemEntity;
import com.vass.shop.infrastructure.adapters.outbound.persistence.repository.OrderItemJpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class OrderPersistenceAdapter implements OrderRepositoryPort {

    private final OrderItemJpaRepository repository;

    public OrderPersistenceAdapter(OrderItemJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void savePurchasedItems(UUID orderId, Cart cart, BigDecimal finalTotal) {
        cart.getItems().forEach(item -> {
            OrderItemEntity orderItem = new OrderItemEntity(
                    orderId,
                    cart.getUserId(),
                    item.getProduct().id(),
                    item.getProduct().name(),
                    item.getProduct().price(),
                    item.getQuantity()
            );
            repository.save(orderItem);
        });
    }

    @Override
    public List<Product> getTopExpensivePurchases(UUID userId) {
        return repository.getTopExpensivePurchases(userId).stream()
                .map(this::mapToProduct)
                .toList();
    }

    private Product mapToProduct(OrderItemEntity orderEntity) {
        return new Product(orderEntity.getProductId(), orderEntity.getProductName(), orderEntity.getProductPrice());
    }
}
