package com.vass.shop.infrastructure.config;

import com.vass.shop.application.ports.outbound.CartRepositoryPort;
import com.vass.shop.application.ports.outbound.OrderRepositoryPort;
import com.vass.shop.application.ports.outbound.ProductRepositoryPort;
import com.vass.shop.application.ports.outbound.UserRepositoryPort;
import com.vass.shop.application.service.CartService;
import com.vass.shop.application.service.ProductService;
import com.vass.shop.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HexagonalBeanConfig {

    @Bean
    public UserService userService(UserRepositoryPort repositoryPort, OrderRepositoryPort orderRepositoryPort) {
        return new UserService(repositoryPort, orderRepositoryPort);
    }

    @Bean
    public ProductService productService(ProductRepositoryPort repositoryPort) {
        return new ProductService(repositoryPort);
    }

    @Bean
    public CartService cartService(CartRepositoryPort cartRepositoryPort, UserRepositoryPort userRepositoryPort,
                                   ProductRepositoryPort productRepositoryPort, OrderRepositoryPort orderRepositoryPort) {
        return new CartService(cartRepositoryPort, userRepositoryPort, productRepositoryPort, orderRepositoryPort);
    }

}
