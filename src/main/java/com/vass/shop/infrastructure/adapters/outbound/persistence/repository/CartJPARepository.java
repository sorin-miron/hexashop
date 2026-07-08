package com.vass.shop.infrastructure.adapters.outbound.persistence.repository;

import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartJPARepository extends JpaRepository<CartEntity, UUID> {
}
