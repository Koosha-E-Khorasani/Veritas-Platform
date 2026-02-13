package com.veritas.auth_service.application.outbound_port;

import com.veritas.auth_service.domain.role.Role;

import java.util.List;
import java.util.UUID;

public interface RoleRepository {
    List<Role> findAll();
    Role findById(UUID id);
    List<Role> findByUserID(UUID userId);
    List<Role> findByPermissionId(UUID permissionId);
    void save(Role role);
    void  delete(Role role);
    void update( Role role);

}
