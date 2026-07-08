package com.vass.shop.domain.model;

import java.util.UUID;

public record User(UUID id, String username, UserType userType) {}
