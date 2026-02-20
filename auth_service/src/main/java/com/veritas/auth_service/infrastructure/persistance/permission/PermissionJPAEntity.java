package com.veritas.auth_service.infrastructure.persistance.permission;

import com.veritas.auth_service.domain.permission.PermissionId;
import com.veritas.auth_service.infrastructure.persistance.role.RoleJPAEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PermissionJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @ManyToMany(mappedBy = "permissions",fetch = FetchType.LAZY)
    Set<RoleJPAEntity> roles;
}
