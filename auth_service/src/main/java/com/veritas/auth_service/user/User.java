package com.veritas.auth_service.user;

import com.veritas.auth_service.role.Role;
import com.veritas.auth_service.token.Token;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(unique = true,nullable = false)
    String username;
    @Column(unique = true,nullable = false)
    String email;
    @Column(unique = true,nullable = false)
    String password;
    @Column(nullable = false)
    boolean isVerified;
    LocalDateTime lastLogin;
    @Column(nullable = false)
    LocalDateTime creationDate;
    @Column(nullable = false)
    LocalDateTime updateDate;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    Set<Token>  tokens = new HashSet<>();

    public void addToken(Token token) {
        this.tokens.add(token);
        token.setUser(this);
    }

    public void removeToken(Token token) {
        this.tokens.remove(token);
        token.setUser(null);
    }
    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDateTime.now();
    }
}
