package com.veritas.auth_service.infrastructure.persistance.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tokens")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    LocalDateTime expiryDate;
    LocalDateTime createdDate;
    String hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserJPAEntity user;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }
}
