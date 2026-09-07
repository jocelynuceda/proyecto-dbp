package utec.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("MEDICATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MedicationRecord extends MedicalRecord {

    private String drugName;

    /** Ej: "5 mg". Si el cuidador no está seguro, se guarda en texto libre y confidenceLevel = UNCERTAIN. */
    private String dose;

    private String frequency;

    private boolean active;
}
