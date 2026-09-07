package utec.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Tabla intermedia User <-> Person: quién cuida a quién, bajo qué rol
 * y con qué vigencia.
 */
@Entity
@Table(
        name = "care_relationships",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "person_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CareRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CareStatus status;

    @Column(nullable = false)
    private Instant invitedAt;

    private Instant acceptedAt;

    @PrePersist
    void onCreate() {
        if (this.invitedAt == null) {
            this.invitedAt = Instant.now();
        }
        if (this.status == null) {
            this.status = CareStatus.ACTIVE;
        }
    }
}
