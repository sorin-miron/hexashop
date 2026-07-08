package com.vass.shop.application.ports.outbound;

import com.vass.shop.domain.model.Cart;

import java.math.BigDecimal;
import java.util.UUID;

public interface OrderRepositoryPort {
    void saveHistoricalOrder(UUID orderId, Cart cart, BigDecimal finalTotal);
}
