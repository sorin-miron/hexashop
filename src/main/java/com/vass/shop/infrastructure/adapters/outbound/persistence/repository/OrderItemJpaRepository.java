package com.vass.shop.infrastructure.adapters.outbound.persistence.repository;

import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, UUID> {

    @Query(value = """
        SELECT DISTINCT p.id, p.name, p.price FROM order_items oi
        JOIN orders o ON oi.order_id = o.id
        JOIN products p ON oi.product_id = p.id
        WHERE o.user_id = :userId
        ORDER BY p.price DESC
        LIMIT 4
        """, nativeQuery = true)
    List<Object[]> findTop4MostExpensiveProductsByUserId(@Param("userId") UUID userId);
}