package utec.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * El enlace temporal de un Handoff. El código se guarda hasheado y la
 * sesión está limitada por tres mecanismos independientes: vencimiento
 * absoluto, ventana de sesión desde la primera apertura, y tope de
 * personas distintas que pueden abrirlo.
 */
@Entity
@Table(name = "handoff_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HandoffSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "handoff_id", nullable = false)
    private Handoff handoff;

    @Column(nullable = false, unique = true)
    private String tokenHash;

    @Column(nullable = false)
    private Instant expiresAt;

    @Column(nullable = false)
    private Integer sessionWindowMinutes;

    @Column(nullable = false)
    private Integer maxDistinctViewers;

    private Instant firstOpenedAt;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now();
    }
}
