package com.vass.shop.infrastructure.adapters.outbound.persistence;

import com.vass.shop.application.ports.outbound.UserRepositoryPort;
import com.vass.shop.domain.model.User;
import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.UserEntity;
import com.vass.shop.infrastructure.adapters.outbound.persistence.repository.UserJPARepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserJPARepository repository;

    public UserPersistenceAdapter(UserJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = new UserEntity(user.id(), user.username(), user.email(), user.isVip());
        UserEntity saved = repository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<User> findById(UUID id) {
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

    private User mapToDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getUsername(), entity.getEmail(), entity.isVip());
    }
}