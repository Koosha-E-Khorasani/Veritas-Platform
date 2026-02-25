package com.veritas.auth_service.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class AuthServiceTestConfiguration {
    @Bean
    PostgreSQLContainer postgresContainer(){
        return new PostgreSQLContainer("postgres:latest");
    }
}
