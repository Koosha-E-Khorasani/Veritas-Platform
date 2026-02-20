package com.veritas.auth_service.domain.permission;

import com.veritas.auth_service.domain.role.RoleId;

import java.util.List;
import java.util.UUID;


public class Permission {
        private PermissionId permissionId;
        private String name;
        private List<RoleId> roleIds;

        public Permission(String permissionName){
            this.name = permissionName;
            permissionId = new PermissionId();
        }

        public Permission(UUID permissionId, String permissionName,List<RoleId> roleIds){
            this.permissionId = new PermissionId(permissionId);
            this.name = permissionName;
            this.roleIds = roleIds;
        }

        public PermissionId getPermissionId() {
            return permissionId;
        }
        public void setPermissionId(PermissionId permissionId) {
          this.permissionId = permissionId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    public List<RoleId> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<RoleId> roleIds) {
        this.roleIds = roleIds;
    }
}
