package com.vass.shop.domain.ports.outbound;

import com.vass.shop.domain.model.Cart;

import java.util.Optional;
import java.util.UUID;

public interface CartRepositoryPort {
    Cart save(Cart cart);
    Optional<Cart> findById(UUID id);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
