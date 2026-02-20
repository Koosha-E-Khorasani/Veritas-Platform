package com.veritas.auth_service.domain.role;

import com.veritas.auth_service.domain.permission.PermissionId;
import com.veritas.auth_service.domain.user.UserId;

import java.util.List;

public class Role {
    RoleId roleId;
    String name;
    String description;
    List<PermissionId> permissionIds;
    List<UserId> userIds;

    public Role(String name, String description) {
        roleId = new RoleId();
        this.name = name;
        this.description = description;
    }

    public Role(RoleId roleId, String name, String description, List<PermissionId> permissionIds, List<UserId> userIds) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
        this.permissionIds = permissionIds;
        this.userIds = userIds;
    }

    public RoleId getRoleId() {
        return roleId;
    }

    public void setRoleId(RoleId roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public List<PermissionId> getPermissionIds() {
        return permissionIds;
    }
    public void setPermissionIds(List<PermissionId> permissionIds) {
        this.permissionIds = permissionIds;
    }
    public void addPermission(PermissionId permissionId) {
        this.permissionIds.add(permissionId);
    }
    public List<UserId> getUserIds() {
        return userIds;
    }
    public void setUserIds(List<UserId> userIds) {
        this.userIds = userIds;
    }
    public void addUserId(UserId userId) {
        this.userIds.add(userId);
    }

}
