package com.vass.shop.application.service;

import com.vass.shop.application.ports.inbound.UserUseCase;
import com.vass.shop.application.ports.outbound.UserRepositoryPort;
import com.vass.shop.domain.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements UserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }

    @Override
    public User getUser(UUID id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
    }

    @Override
    public User updateUser(UUID id, User user) {
        if (!userRepositoryPort.existsById(id)) {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
        User updateUser = new User(id, user.username(), user.userType());
        return userRepositoryPort.save(updateUser);
    }

    @Override
    public void deleteUser(UUID id) {
        if (!userRepositoryPort.existsById(id)) {
            throw new EntityNotFoundException("User not found with ID: " + id);
        }
        userRepositoryPort.deleteById(id);
    }
}
