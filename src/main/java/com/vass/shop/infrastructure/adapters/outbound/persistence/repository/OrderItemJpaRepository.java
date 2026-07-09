package com.vass.shop.infrastructure.adapters.outbound.persistence.repository;

import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, UUID> {

    @Query(value = "SELECT DISTINCT ON (product_price, product_id) * " +
            "FROM orders WHERE user_id = :userId " +
            "ORDER BY product_price DESC LIMIT 4", nativeQuery = true)
    List<OrderItemEntity> getTopExpensivePurchases(@Param("userId") UUID userId);
}