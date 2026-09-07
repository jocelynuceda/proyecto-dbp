package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.Condition;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
}
