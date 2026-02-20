package com.veritas.auth_service.infrastructure.persistance.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PermissionJPARepository extends CrudRepository<PermissionJPAEntity, UUID> {
}
