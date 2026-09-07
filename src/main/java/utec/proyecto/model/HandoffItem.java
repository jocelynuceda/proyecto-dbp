package utec.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Tabla intermedia Handoff <-> MedicalRecord: qué dato entró en cada resumen.
 */
@Entity
@Table(
        name = "handoff_items",
        uniqueConstraints = @UniqueConstraint(columnNames = {"handoff_id", "medical_record_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HandoffItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "handoff_id", nullable = false)
    private Handoff handoff;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_id", nullable = false)
    private MedicalRecord medicalRecord;
}
