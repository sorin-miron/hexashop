package com.vass.shop.domain.model;

import java.util.*;

public class Cart {
    private final UUID id;
    private final UUID userId;
    private final CartType type;
    private final Map<UUID, CartItem> items = new HashMap<>();

    public Cart(UUID id, UUID userId, CartType type) {
        this.id = id;
        this.userId = userId;
        this.type = type;
    }

    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public CartType getType() { return type; }
    public Collection<CartItem> getItems() { return items.values(); }

    public void addItem(Product product, int quantity) {
        if (items.containsKey(product.id())) {
            items.get(product.id()).addQuantity(quantity);
        } else {
            items.put(product.id(), new CartItem(product, quantity));
        }
    }

    public void removeItem(Product product) {
        if (items.containsKey(product.id())) {
            if (items.get(product.id()).getQuantity() > 1) {
                items.get(product.id()).addQuantity(-1);
            } else {
                items.remove(product.id());
            }
        }
    }
}
