package utec.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Una consulta médica registrada. Sirve como punto de corte para calcular
 * "qué cambió desde la última consulta" sobre los MedicalRecord de la Person.
 */
@Entity
@Table(name = "encounters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
