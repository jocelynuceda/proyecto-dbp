package utec.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * El resumen de traspaso: pantalla única preparada por quien sabe para que
 * quien acompaña al paciente se la muestre al médico.
 */
@Entity
@Table(name = "handoffs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Handoff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;

    @Column(columnDefinition = "TEXT")
    private String questions;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now();
    }
}
