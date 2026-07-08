package com.vass.shop.application.ports.outbound;

import com.vass.shop.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(UUID id);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
