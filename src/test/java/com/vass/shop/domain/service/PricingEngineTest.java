package com.vass.shop.domain.service;

import com.vass.shop.domain.model.Cart;
import com.vass.shop.domain.model.CartType;
import com.vass.shop.domain.model.Product;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingEngineTest {

    private final PricingEngine pricingEngine = new PricingEngine();

    @Test
    void testExactlyFiveItemsTwentyPercentDiscount() {
        Cart cart = new Cart(UUID.randomUUID(), UUID.randomUUID(), CartType.NORMAL);
        Product product = new Product(UUID.randomUUID(), "Item", BigDecimal.valueOf(20.00));
        cart.addItem(product, 5);

        PricingEngine.PriceSummary summary = pricingEngine.calculatePrice(cart);

        assertEquals(0, BigDecimal.valueOf(100.00).compareTo(summary.getSubtotal()));
        assertEquals(0, BigDecimal.valueOf(20.00).compareTo(summary.getTotalDiscount()));
        assertEquals(0, BigDecimal.valueOf(80.00).compareTo(summary.getFinalTotal()));
    }

    @Test
    void testMoreThanTenItemsNormalCartFixedDiscount() {
        Cart cart = new Cart(UUID.randomUUID(), UUID.randomUUID(), CartType.NORMAL);
        Product product = new Product(UUID.randomUUID(), "Item", BigDecimal.valueOf(10.00));
        cart.addItem(product, 11);

        PricingEngine.PriceSummary summary = pricingEngine.calculatePrice(cart);

        assertEquals(0, BigDecimal.valueOf(110.00).compareTo(summary.getSubtotal()));
        assertEquals(0, BigDecimal.valueOf(20.00).compareTo(summary.getTotalDiscount()));
        assertEquals(0, BigDecimal.valueOf(90.00).compareTo(summary.getFinalTotal()));
    }

    @Test
    void testMoreThanTenItemsVipCartCheapestFreePlusSeventyDiscount() {
        Cart cart = new Cart(UUID.randomUUID(), UUID.randomUUID(), CartType.VIP);
        Product p1 = new Product(UUID.randomUUID(), "Expensive", BigDecimal.valueOf(50.00));
        Product p2 = new Product(UUID.randomUUID(), "Cheapest", BigDecimal.valueOf(10.00));

        cart.addItem(p1, 10);
        cart.addItem(p2, 2);

        PricingEngine.PriceSummary summary = pricingEngine.calculatePrice(cart);

        assertEquals(0, BigDecimal.valueOf(520.00).compareTo(summary.getSubtotal()));
        assertEquals(0, BigDecimal.valueOf(80.00).compareTo(summary.getTotalDiscount()));
        assertEquals(0, BigDecimal.valueOf(440.00).compareTo(summary.getFinalTotal()));
    }
}
