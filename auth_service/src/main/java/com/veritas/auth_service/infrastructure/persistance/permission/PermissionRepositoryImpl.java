package com.veritas.auth_service.infrastructure.persistance.permission;

import com.veritas.auth_service.application.outbound_port.PermissionRepository;
import com.veritas.auth_service.domain.permission.Permission;

import java.util.List;
import java.util.UUID;

public class PermissionRepositoryImpl implements PermissionRepository {
    @Override
    public List<Permission> findAll() {
        return List.of();
    }

    @Override
    public Permission findById(UUID id) {
        return null;
    }

    @Override
    public List<Permission> findByRoleId(UUID roleId) {
        return List.of();
    }

    @Override
    public List<Permission> findByUserID(UUID userId) {
        return List.of();
    }

    @Override
    public void save(Permission permission) {

    }

    @Override
    public void delete(UUID permissionId) {

    }

    @Override
    public void update(Permission permission) {

    }
}
