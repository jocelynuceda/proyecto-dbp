package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.Handoff;

import java.util.List;

public interface HandoffRepository extends JpaRepository<Handoff, Long> {

    List<Handoff> findByPersonIdOrderByCreatedAtDesc(Long personId);
}
