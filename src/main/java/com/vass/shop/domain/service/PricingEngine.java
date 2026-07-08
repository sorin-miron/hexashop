package com.vass.shop.domain.service;

import com.vass.shop.domain.model.Cart;
import com.vass.shop.domain.model.CartItem;
import com.vass.shop.domain.model.CartType;
import com.vass.shop.domain.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

public class PricingEngine {

    public static class PriceSummary {
        public BigDecimal subtotal;
        public BigDecimal totalDiscount;
        public BigDecimal finalTotal;

        public PriceSummary(BigDecimal subtotal, BigDecimal totalDiscount, BigDecimal finalTotal) {
            this.subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);
            this.totalDiscount = totalDiscount.setScale(2, RoundingMode.HALF_UP);
            this.finalTotal = finalTotal.setScale(2, RoundingMode.HALF_UP);
        }
    }

    public PriceSummary calculatePrice(Cart cart) {
        BigDecimal subtotal = BigDecimal.ZERO;
        int totalQuantity = 0;

        for (CartItem item : cart.getItems()) {
            subtotal = subtotal.add(item.getSubTotal());
            totalQuantity += item.getQuantity();
        }

        BigDecimal discount = BigDecimal.ZERO;

        // Rule 1: Exactly 5 items -> 20% discount
        if (totalQuantity == 5) {
            discount = subtotal.multiply(BigDecimal.valueOf(0.20));
        }
        // Rule 2: More than 10 items
        else if (totalQuantity > 10) {
            if (cart.getType() == CartType.NORMAL) {
                discount = BigDecimal.valueOf(20.00);
            } else if (cart.getType() == CartType.VIP) {
                // Cheapest single unit item price free
                BigDecimal cheapestItemPrice = cart.getItems().stream()
                        .map(CartItem::getProduct)
                        .map(Product::price)
                        .min(Comparator.naturalOrder())
                        .orElse(BigDecimal.ZERO);

                discount = cheapestItemPrice.add(BigDecimal.valueOf(70.00));
            }
        }

        if (discount.compareTo(subtotal) > 0) {
            discount = subtotal; // Avoid negative pricing scenarios
        }

        BigDecimal finalTotal = subtotal.subtract(discount);
        return new PriceSummary(subtotal, discount, finalTotal);
    }
}

