package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.HandoffItem;

import java.util.List;

public interface HandoffItemRepository extends JpaRepository<HandoffItem, Long> {

    List<HandoffItem> findByHandoffId(Long handoffId);
}
