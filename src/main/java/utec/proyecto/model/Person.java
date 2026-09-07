package utec.proyecto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Sujeto del cuidado. No distingue "hijo", "padre" o "uno mismo": el vínculo
 * y el rol viven en {@link CareRelationship}.
 */
@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate birthDate;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
