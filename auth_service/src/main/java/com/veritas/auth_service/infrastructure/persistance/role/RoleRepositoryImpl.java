package com.veritas.auth_service.infrastructure.persistance.role;

import com.veritas.auth_service.application.outbound_port.RoleRepository;
import com.veritas.auth_service.domain.role.Role;

import java.util.List;
import java.util.UUID;

public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public List<Role> findAll() {
        return List.of();
    }

    @Override
    public Role findById(UUID id) {
        return null;
    }

    @Override
    public List<Role> findByUserID(UUID userId) {
        return List.of();
    }

    @Override
    public List<Role> findByPermissionId(UUID permissionId) {
        return List.of();
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void delete(Role role) {

    }

    @Override
    public void update(Role role) {

    }
}
