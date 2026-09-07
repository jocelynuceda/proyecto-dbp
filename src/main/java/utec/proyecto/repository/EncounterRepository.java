package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.Encounter;

import java.util.List;
import java.util.Optional;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {

    List<Encounter> findByPersonIdOrderByDateDesc(Long personId);

    Optional<Encounter> findFirstByPersonIdOrderByDateDesc(Long personId);
}
