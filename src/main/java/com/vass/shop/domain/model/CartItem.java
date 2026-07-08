package com.vass.shop.domain.model;

import java.math.BigDecimal;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void addQuantity(int qty) { this.quantity += qty; }

    public BigDecimal getSubTotal() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }
}
