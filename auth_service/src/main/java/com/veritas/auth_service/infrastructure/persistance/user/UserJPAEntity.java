package com.veritas.auth_service.infrastructure.persistance.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UserJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private LocalDateTime lastLogin;
    private LocalDateTime created;
    private LocalDateTime updated;
    private List<UUID> roleId = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "token_id",referencedColumnName = "id")
    private TokenJPAEntity token;
    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}
