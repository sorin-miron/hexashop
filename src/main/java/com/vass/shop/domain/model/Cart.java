package com.vass.shop.domain.model;

import java.util.*;

public class Cart {
    private final UUID id;
    private final UUID userId;
    private final CartType type;
    private final List<CartItem> items = new ArrayList<>();
    private boolean checkedOut;

    public Cart(UUID id, UUID userId, CartType type) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.checkedOut = false;
    }

    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public CartType getType() { return type; }
    public List<CartItem> getItems() { return items; }
    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void addItem(Product product, int quantity) {
        if (isCheckedOut()) {
            throw new IllegalStateException("Cannot alter a checked out cart.");
        }
        items.stream()
                .filter(item -> item.getProduct().id().equals(product.id()))
                .findFirst()
                .ifPresentOrElse(
                        existingItem -> existingItem.addQuantity(quantity),
                        () -> items.add(new CartItem(product, quantity))
                );
    }

    public void removeItem(UUID productId) {
        if (isCheckedOut()) {
            throw new IllegalStateException("Cannot alter a checked out cart.");
        }
        items.removeIf(item -> item.getProduct().id().equals(productId));
    }

    public void checkOut() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Empty cart can't be checkout");
        }
        this.checkedOut = true;
    }
}
