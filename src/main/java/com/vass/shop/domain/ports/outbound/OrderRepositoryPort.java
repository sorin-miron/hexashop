package com.vass.shop.domain.ports.outbound;

import com.vass.shop.domain.model.Cart;
import com.vass.shop.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OrderRepositoryPort {
    void savePurchasedItems(UUID orderId, Cart cart, BigDecimal finalTotal);
    List<Product> getTopExpensivePurchases(UUID userId);
}
