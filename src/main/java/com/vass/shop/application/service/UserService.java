package com.vass.shop.application.service;

import com.vass.shop.domain.ports.inbound.UserUseCase;
import com.vass.shop.domain.ports.outbound.OrderRepositoryPort;
import com.vass.shop.domain.ports.outbound.UserRepositoryPort;
import com.vass.shop.domain.exception.ResourceNotFoundException;
import com.vass.shop.domain.model.Product;
import com.vass.shop.domain.model.User;

import java.util.List;
import java.util.UUID;

public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final OrderRepositoryPort orderRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort, OrderRepositoryPort orderRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }

    @Override
    public User getUser(UUID id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    @Override
    public User updateUser(UUID id, User user) {
        if (!userRepositoryPort.existsById(id)) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
        User updatedUser = new User(id, user.username(), user.email(), user.isVip());
        return userRepositoryPort.save(updatedUser);
    }

    @Override
    public void deleteUser(UUID id) {
        if (!userRepositoryPort.existsById(id)) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
        userRepositoryPort.deleteById(id);
    }

    @Override
    public List<Product> getTopExpensivePurchases(UUID userId) {
        if (!userRepositoryPort.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
        return orderRepositoryPort.getTopExpensivePurchases(userId);
    }
}
