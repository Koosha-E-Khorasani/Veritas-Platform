package com.veritas.auth_service.domain.role;

import java.util.UUID;

public record RoleId(UUID roleId) {
    public RoleId {
        if (roleId == null) {
            throw new IllegalArgumentException("roleId cannot be null");
        }
    }

    public RoleId(){
        this(UUID.randomUUID());
    }
}
