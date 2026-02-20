package com.veritas.auth_service.infrastructure.persistance.permission.mapper;

import com.veritas.auth_service.domain.permission.Permission;
import com.veritas.auth_service.domain.role.RoleId;
import com.veritas.auth_service.infrastructure.persistance.permission.PermissionJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPAEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermissionMapper {

    public static PermissionJPAEntity toJPAEntity(Permission permission, Set<RoleJPAEntity> roles) {
        PermissionJPAEntity jpaEntity =  new PermissionJPAEntity();
        jpaEntity.setId(permission.getPermissionId().id());
        jpaEntity.setName(permission.getName());
        jpaEntity.setRoles(roles);
        return jpaEntity;
    }

    public static Permission toDomainObject(PermissionJPAEntity permissionJPAEntity) {
        List<RoleId> roleIds = permissionJPAEntity.getRoles()
                .stream()
                .map(roleJPAEntity -> new RoleId(roleJPAEntity.getRoleId()))
                .toList();
    return new Permission(permissionJPAEntity.getId(),permissionJPAEntity.getName(),roleIds);

    }

    public static List<Permission> toDomainObjects(List<PermissionJPAEntity> permissionJPAEntityList) {
        return permissionJPAEntityList
                .stream()
                .map(permissionJPAEntity ->toDomainObject(permissionJPAEntity))
                .toList();
    }

    public static List<PermissionJPAEntity> toJPAEntities(Map<Permission,Set<RoleJPAEntity>> permissionsRoleMap) {
        return permissionsRoleMap.entrySet()
                .stream()
                .map(entry -> toJPAEntity(entry.getKey(), entry.getValue()))
                .toList();
    }
}
