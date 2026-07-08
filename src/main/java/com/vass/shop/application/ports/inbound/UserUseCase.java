package com.vass.shop.application.ports.inbound;

import com.vass.shop.domain.model.User;

import java.util.UUID;

public interface UserUseCase {
    User createUser(User user);
    User getUser(UUID id);
    User updateUser(UUID id, User user);
    void deleteUser(UUID id);
}
