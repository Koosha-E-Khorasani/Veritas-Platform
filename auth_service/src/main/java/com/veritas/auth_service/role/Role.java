package com.veritas.auth_service.role;

import com.veritas.auth_service.permission.Permission;
import com.veritas.auth_service.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String description;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    Set<User> users = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    Set<Permission> permissions = new HashSet<>();
}
