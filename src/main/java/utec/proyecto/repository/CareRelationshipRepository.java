package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.CareRelationship;
import utec.proyecto.model.CareStatus;

import java.util.List;
import java.util.Optional;

public interface CareRelationshipRepository extends JpaRepository<CareRelationship, Long> {

    List<CareRelationship> findByUserIdAndStatus(Long userId, CareStatus status);

    List<CareRelationship> findByPersonIdAndStatus(Long personId, CareStatus status);

    Optional<CareRelationship> findByUserIdAndPersonId(Long userId, Long personId);
}
