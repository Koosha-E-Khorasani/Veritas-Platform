package com.veritas.auth_service.infrastructure.persistance.role;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface RoleJPARepository extends CrudRepository<RoleJPAEntity, UUID> {
    RoleJPAEntity getByName(String name);
}
