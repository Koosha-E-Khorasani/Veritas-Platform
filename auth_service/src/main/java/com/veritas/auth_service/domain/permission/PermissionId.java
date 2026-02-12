package com.veritas.auth_service.domain.permission;

import java.util.UUID;

public record PermissionId(UUID id) {
    public PermissionId {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }

    public PermissionId() {
        this(UUID.randomUUID());
    }
}
