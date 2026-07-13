package com.vass.shop.application.service;

import com.vass.shop.application.ports.inbound.CartUseCase;
import com.vass.shop.application.ports.outbound.CartRepositoryPort;
import com.vass.shop.application.ports.outbound.OrderRepositoryPort;
import com.vass.shop.application.ports.outbound.ProductRepositoryPort;
import com.vass.shop.application.ports.outbound.UserRepositoryPort;
import com.vass.shop.domain.exception.ResourceNotFoundException;
import com.vass.shop.domain.model.*;
import com.vass.shop.domain.service.PricingEngine;

import java.util.UUID;

public class CartService implements CartUseCase {
    private final CartRepositoryPort cartRepository;
    private final UserRepositoryPort userRepository;
    private final ProductRepositoryPort productRepository;
    private final OrderRepositoryPort orderRepository;
    private final PricingEngine pricingEngine = new PricingEngine();

    public CartService(CartRepositoryPort cartRepository, UserRepositoryPort userRepository,
                       ProductRepositoryPort productRepository, OrderRepositoryPort orderRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Cart createCart(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        CartType type = user.isVip() ? CartType.VIP : CartType.NORMAL;
        Cart cart = new Cart(UUID.randomUUID(), userId, type);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(UUID cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }

    @Override
    public PricingEngine.PriceSummary getCartSummary(UUID cartId) {
        return pricingEngine.calculatePrice(getCart(cartId));
    }

    @Override
    public Cart addItem(UUID cartId, UUID productId, int quantity) {
        ensureCartExists(cartId);
        Cart cart = getCart(cartId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        cart.addItem(product, quantity);
        return cartRepository.save(cart);
    }

    @Override
    public Cart removeItem(UUID cartId, UUID productId) {
        ensureCartExists(cartId);
        Cart cart = getCart(cartId);
        cart.removeItem(productId);
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(UUID cartId) {
        ensureCartExists(cartId);
        cartRepository.deleteById(cartId);
    }

    @Override
    public UUID checkout(UUID cartId) {
        ensureCartExists(cartId);
        Cart cart = getCart(cartId);
        cart.checkOut();
        cartRepository.save(cart);

        UUID orderId = UUID.randomUUID();
        PricingEngine.PriceSummary summary = pricingEngine.calculatePrice(cart);
        orderRepository.savePurchasedItems(orderId, cart, summary.getFinalTotal());
        return orderId;
    }

    private void ensureCartExists(UUID cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new ResourceNotFoundException("Cart not found with ID: " + cartId);
        }
    }
}
