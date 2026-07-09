package com.vass.shop.infrastructure.adapters.inbound.rest;

import com.vass.shop.application.ports.inbound.CartUseCase;
import com.vass.shop.domain.model.Cart;
import com.vass.shop.domain.service.PricingEngine;
import com.vass.shop.infrastructure.adapters.inbound.rest.api.CartsApi;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class CartController implements CartsApi {

    private final CartUseCase cartUseCase;

    public CartController(CartUseCase cartUseCase) {
        this.cartUseCase = cartUseCase;
    }

    @Override
    public ResponseEntity<CartResponse> createCart(CartCreationRequest cartCreationRequest) {
        Cart cart = cartUseCase.createCart(UUID.fromString(cartCreationRequest.getUserId().toString()));
        return new ResponseEntity<>(mapToResponse(cart), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CartResponse> getCart(UUID cartId) {
        return ResponseEntity.ok(mapToResponse(cartUseCase.getCart(cartId)));
    }

    @Override
    public ResponseEntity<CartResponse> addItemToCart(UUID cartId, CartItemRequest cartItemRequest) {
        Cart cart = cartUseCase.addItem(cartId, cartItemRequest.getProductId(), cartItemRequest.getQuantity());
        return ResponseEntity.ok(mapToResponse(cart));
    }

    @Override
    public ResponseEntity<CartResponse> removeItemFromCart(UUID cartId, UUID productId) {
        Cart cart = cartUseCase.removeItem(cartId, productId);
        return ResponseEntity.ok(mapToResponse(cart));
    }

    @Override
    public ResponseEntity<Void> deleteCart(UUID cartId) {
        cartUseCase.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CheckoutResponse> checkoutCart(UUID cartId) {
        UUID orderId = cartUseCase.checkout(cartId);
        CheckoutResponse res = new CheckoutResponse();
        res.setOrderId(orderId);
        res.checkedOut(true);
        return ResponseEntity.ok(res);
    }

    private CartResponse mapToResponse(Cart cart) {
        PricingEngine.PriceSummary executionSummary = cartUseCase.getCartSummary(cart.getId());
        CartResponse response = new CartResponse();
        response.setId(cart.getId());
        response.setUserId(cart.getUserId());
        response.setCartType(CartResponse.CartTypeEnum.valueOf(cart.getType().name()));
        response.setRawSubTotal(executionSummary.getSubtotal());
        response.setDiscountApplied(executionSummary.getTotalDiscount());
        response.setFinalTotal(executionSummary.getFinalTotal());

        response.setItems(cart.getItems().stream().map(item -> {
            CartItemResponse itemRes = new CartItemResponse();
            ProductResponse pr = new ProductResponse();
            pr.setId(item.getProduct().id());
            pr.setName(item.getProduct().name());
            pr.setPrice(item.getProduct().price());
            itemRes.setProduct(pr);
            itemRes.setQuantity(item.getQuantity());
            itemRes.setSubTotal(item.getSubTotal());
            return itemRes;
        }).toList());

        return response;
    }
}
