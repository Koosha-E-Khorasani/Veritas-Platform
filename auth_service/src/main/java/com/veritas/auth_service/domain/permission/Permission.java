package com.veritas.auth_service.domain.permission;

import java.util.List;
import java.util.UUID;


public class Permission {
        private PermissionId permissionId;
        private String name;


        public Permission(String permissionName){
            this.name = permissionName;
            permissionId = new PermissionId();
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


}
