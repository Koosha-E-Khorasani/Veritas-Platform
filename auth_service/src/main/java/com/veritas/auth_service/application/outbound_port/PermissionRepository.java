package com.veritas.auth_service.application.outbound_port;

import com.veritas.auth_service.domain.permission.Permission;

import java.util.List;
import java.util.UUID;

public interface PermissionRepository {
    List<Permission> findAll();
    Permission findPermissionById(UUID id);
    Permission findById(UUID id);
    List<Permission> findByRoleId(UUID roleId);
    List<Permission> findByUserID(UUID userId);
    void save(Permission permission);
    void delete(UUID permissionId);
    void update(Permission permission);


}
