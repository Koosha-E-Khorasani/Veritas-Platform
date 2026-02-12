package com.veritas.auth_service.domain.user;

import java.util.UUID;

public record  UserId(UUID id) {
    public UserId{
        if(id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }

    public UserId(){
        this(UUID.randomUUID());
    }
}
