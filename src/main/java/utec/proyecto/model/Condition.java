package utec.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("CONDITION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Condition extends MedicalRecord {

    private String name;

    private LocalDate diagnosedOn;

    private boolean chronic;
}
