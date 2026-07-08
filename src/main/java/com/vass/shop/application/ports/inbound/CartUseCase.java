package com.vass.shop.application.ports.inbound;

import com.vass.shop.domain.model.Cart;
import com.vass.shop.domain.service.PricingEngine;

import java.util.UUID;

public interface CartUseCase {
    Cart createCart(UUID userId);
    Cart getCart(UUID cartId);
    PricingEngine.PriceSummary getCartSummary(UUID cartId);
    Cart addItem(UUID cartId, UUID productId, int quantity);
    Cart removeItem(UUID cartId, UUID productId);
    void deleteCart(UUID cartId);
    UUID checkout(UUID cartId);
}
