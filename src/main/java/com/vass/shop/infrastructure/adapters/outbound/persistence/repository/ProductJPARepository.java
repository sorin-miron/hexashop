package com.vass.shop.infrastructure.adapters.outbound.persistence.repository;

import com.vass.shop.infrastructure.adapters.outbound.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductJPARepository extends JpaRepository<ProductEntity, UUID> {
}
