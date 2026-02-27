package com.veritas.auth_service.infrastructure.persistance.permission;

import com.veritas.auth_service.application.outbound_port.PermissionRepository;
import com.veritas.auth_service.domain.permission.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PermissionRepositoryImpl implements PermissionRepository {

    PermissionJPARepository permissionJPARepository;
    public PermissionRepositoryImpl(PermissionJPARepository permissionRepository) {
        this.permissionJPARepository = permissionRepository;
    }


    @Override
    public List<Permission> findAll() {
        return permissionJPARepository.findAll();

    }

    @Override
    public Permission findPermissionById(UUID id) {
        return null;
    }

    @Override
    public Permission findById(UUID id) {
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
