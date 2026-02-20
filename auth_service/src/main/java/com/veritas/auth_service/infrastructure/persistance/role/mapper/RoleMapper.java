package com.veritas.auth_service.infrastructure.persistance.role.mapper;

import com.veritas.auth_service.domain.permission.PermissionId;
import com.veritas.auth_service.domain.role.Role;
import com.veritas.auth_service.domain.role.RoleId;
import com.veritas.auth_service.domain.user.UserId;
import com.veritas.auth_service.infrastructure.persistance.permission.PermissionJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleJPAEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoleMapper {

    public static Role toDomainObject(RoleJPAEntity roleJpaEntity) {
        return new Role(new RoleId(roleJpaEntity.getRoleId()),
                roleJpaEntity.getName(),
                roleJpaEntity.getDescription(),
                roleJpaEntity.getPermissions().stream().map(permission->new PermissionId(permission.getId())).toList(),
                roleJpaEntity.getUserRoles().stream().map(userRole->new UserId(userRole.getId().userId())).toList()
                );
    }

    public static RoleJPAEntity toJPAEntity(Role role, Set<UserRoleJPAEntity> userRoleJPAEntities, Set<PermissionJPAEntity> permissionJPAEntities) {
        RoleJPAEntity roleJPAEntity =  new RoleJPAEntity();
        roleJPAEntity.setRoleId(role.getRoleId().roleId());
        roleJPAEntity.setName(role.getName());
        roleJPAEntity.setDescription(role.getDescription());
        roleJPAEntity.setPermissions(permissionJPAEntities);
        roleJPAEntity.setUserRoles(userRoleJPAEntities);
        return roleJPAEntity;
    }

    public static List<RoleJPAEntity> toJPAEntities(
                                                         Map<Role,Set<UserRoleJPAEntity>> userRoleMap,
                                                         Map<Role,Set<PermissionJPAEntity>> rolePermissionMap) {
        return userRoleMap.entrySet().stream().map(role -> toJPAEntity(role.getKey(),role.getValue(),rolePermissionMap.get(role))).toList();
    }
    public static List<Role> toDomainObjects(Set<RoleJPAEntity> roleJPAEntities) {
        return roleJPAEntities.stream().map(roleJPA -> toDomainObject(roleJPA)).toList();
    }
}
