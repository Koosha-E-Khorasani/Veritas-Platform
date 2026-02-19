package com.veritas.auth_service.infrastructure.persistance.user_role;

import com.veritas.auth_service.infrastructure.persistance.role.RoleJPAEntity;
import com.veritas.auth_service.infrastructure.persistance.user.UserJPAEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserRole")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleJPAEntity {

    @EmbeddedId
    UserRoleID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    RoleJPAEntity roleJPAEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserJPAEntity userJPAEntity;
}
