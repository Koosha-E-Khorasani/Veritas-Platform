package com.veritas.auth_service.infrastructure.persistance.role;

import com.veritas.auth_service.domain.role.RoleId;
import com.veritas.auth_service.infrastructure.persistance.permission.PermissionJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleJPAEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter
@Setter
@EqualsAndHashCode
public class RoleJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID roleId;
    String name;
    String description;

    @OneToMany(mappedBy = "roleJPAEntity",fetch = FetchType.LAZY)
    Set<UserRoleJPAEntity> userRoles;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "role_permission",
            joinColumns=@JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    Set<PermissionJPAEntity> permissions;


    public void addPermission(PermissionJPAEntity permissionJPAEntity) {
        permissions.add(permissionJPAEntity);
        permissionJPAEntity.getRoles().add(this);
    }

    public void removePermission(PermissionJPAEntity permissionJPAEntity) {
        permissions.remove(permissionJPAEntity);
        permissionJPAEntity.getRoles().remove(this);
    }
}
