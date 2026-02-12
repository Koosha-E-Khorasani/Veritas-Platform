package com.veritas.auth_service.domain.user;

import java.util.UUID;

public record TokenId(UUID id) {
    public TokenId() {
        this(UUID.randomUUID());
    }

    public TokenId{
        if(id == null) {
            throw new NullPointerException("id is null");
        }
    }


}
