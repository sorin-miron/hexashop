package com.vass.shop.infrastructure.adapters.outbound.persistence.entity;

import com.vass.shop.domain.model.UserType;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private UserType userType;

    // Getters, Setters, Constructors
    public UserEntity() {}

    public UserEntity(UUID id, String username, UserType userType) {
        this.id = id;
        this.username = username;
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
