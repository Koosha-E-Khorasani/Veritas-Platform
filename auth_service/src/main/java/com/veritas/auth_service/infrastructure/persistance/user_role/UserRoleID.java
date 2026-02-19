package com.veritas.auth_service.infrastructure.persistance.user_role;

import jakarta.persistence.Embeddable;

import java.util.UUID;


@Embeddable
public record UserRoleID(UUID userId,UUID roleId) {
}
