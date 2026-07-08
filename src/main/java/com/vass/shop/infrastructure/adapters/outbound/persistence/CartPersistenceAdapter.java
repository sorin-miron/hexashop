package com.vass.shop.infrastructure.adapters.outbound.persistence;

import com.vass.shop.application.ports.outbound.CartRepositoryPort;
import com.vass.shop.domain.model.Cart;
import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.CartEntity;
import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.CartItemEntity;
import com.vass.shop.infrastructure.adapters.outbound.persistence.repository.CartJPARepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CartPersistenceAdapter implements CartRepositoryPort {

    private final CartJPARepository repository;

    public CartPersistenceAdapter(CartJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart save(Cart cart) {
        CartEntity entity = new CartEntity();
        entity.setId(cart.getId());
        entity.setUserId(cart.getUserId());
        entity.setType(cart.getType());

        entity.setItems(cart.getItems().stream()
                .map(cartItem -> new CartItemEntity(cartItem.getProduct().id(), cartItem.getQuantity()))
                .collect(Collectors.toList()));

        CartEntity saved = repository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<Cart> findById(UUID id) {
        return repository.findById(id).map(this::mapToDomain);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    private Cart mapToDomain(CartEntity entity) {
        return new Cart(
                entity.getId(),
                entity.getUserId(),
                entity.getType()
//                entity.getItems().stream()
//                        // TODO: de facut inserare in map
//                        .map(cartItem -> new CartItemEntity(cartItem.getProduct().id(), cartItem.getQuantity()))
//                        .collect(Collectors.toList())
        );
    }
}
