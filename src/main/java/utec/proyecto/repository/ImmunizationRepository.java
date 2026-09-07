package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.Immunization;

public interface ImmunizationRepository extends JpaRepository<Immunization, Long> {
}
