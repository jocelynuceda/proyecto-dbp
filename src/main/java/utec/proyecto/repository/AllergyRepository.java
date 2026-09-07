package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.Allergy;

public interface AllergyRepository extends JpaRepository<Allergy, Long> {
}
