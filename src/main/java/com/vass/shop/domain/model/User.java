package com.vass.shop.domain.model;

import java.util.UUID;

public record User(UUID id, String username, String email, boolean isVip) {}
