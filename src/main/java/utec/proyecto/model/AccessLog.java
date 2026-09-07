package utec.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Registro de cada apertura de un HandoffSession por un visitante sin
 * cuenta: nombre y rol declarados (no verificados) antes de ver el resumen.
 */
@Entity
@Table(name = "access_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "handoff_session_id", nullable = false)
    private HandoffSession handoffSession;

    @Column(nullable = false)
    private String visitorName;

    @Column(nullable = false)
    private String visitorRole;

    @Column(nullable = false, updatable = false)
    private Instant openedAt;

    @PrePersist
    void onCreate() {
        this.openedAt = Instant.now();
    }
}
