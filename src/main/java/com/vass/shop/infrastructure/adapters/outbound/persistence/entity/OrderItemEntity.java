package com.vass.shop.infrastructure.adapters.outbound.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="orders")
public class OrderItemEntity {
    @Id
    private UUID orderId;

    @Column(nullable = false)
    private UUID productId;

}
