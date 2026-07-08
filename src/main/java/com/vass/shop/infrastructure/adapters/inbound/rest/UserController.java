package com.vass.shop.infrastructure.adapters.inbound.rest;

import com.vass.shop.application.ports.inbound.UserUseCase;
import com.vass.shop.domain.model.User;
import com.vass.shop.domain.model.UserType;
import com.vass.shop.infrastructure.adapters.inbound.rest.api.UsersApi;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.ProductResponse;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.UserRequest;
import com.vass.shop.infrastructure.adapters.inbound.rest.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController implements UsersApi {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        User user = new User(
                UUID.randomUUID(),
                userRequest.getUsername(),
                UserType.fromValue(userRequest.getUserType().getValue())
        );
        User savedUser = userUseCase.createUser(user);
        return new ResponseEntity<>(mapToResponse(savedUser), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(UUID userId) {
        User user = userUseCase.getUser(userId);
        return ResponseEntity.ok(mapToResponse(user));
    }

    @Override
    public ResponseEntity<List<UserResponse>> listUsers(Integer limit) {
        // TODO: de facut
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UUID userId, UserRequest userRequest) {
        User user = new User(
                userId,
                userRequest.getUsername(),
                UserType.fromValue(userRequest.getUserType().getValue())
        );
        User updatedUser = userUseCase.updateUser(userId, user);
        return new ResponseEntity<>(mapToResponse(updatedUser), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID userId) {
        userUseCase.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getTopExpensivePurchases(UUID userId) {
        // TODO: de facut
        return null;
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.id());
        response.setUsername(user.username());
        response.setUserType(user.userType().getValue());
        return response;
    }
}
