package com.veritas.auth_service.infrastructure.persistance.user;

import com.veritas.auth_service.infrastructure.persistance.user_role.UserRoleJPAEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UserJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean isVerified;
    private LocalDateTime lastLogin;
    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userJPAEntity"
            ,cascade = CascadeType.ALL,orphanRemoval = true)
    Set<UserRoleJPAEntity> roles = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }

    public void addRole(UserRoleJPAEntity userRoleJPAEntity) {
        this.roles.add(userRoleJPAEntity);
        userRoleJPAEntity.setUserJPAEntity(this);
    }

    public void deleteRole(UserRoleJPAEntity userRoleJPAEntity) {
        this.roles.remove(userRoleJPAEntity);
        userRoleJPAEntity.setUserJPAEntity(null);
    }

}
