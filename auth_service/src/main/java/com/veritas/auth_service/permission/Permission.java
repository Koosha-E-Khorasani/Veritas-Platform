package com.veritas.auth_service.permission;

import com.veritas.auth_service.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
    Set<Role> roles = new HashSet<>();
}
