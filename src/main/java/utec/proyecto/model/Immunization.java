package utec.proyecto.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("IMMUNIZATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Immunization extends MedicalRecord {

    private String vaccine;

    private LocalDate dateApplied;

    private Integer doseNumber;
}
