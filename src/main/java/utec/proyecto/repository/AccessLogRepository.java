package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.AccessLog;

import java.util.List;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {

    List<AccessLog> findByHandoffSessionIdOrderByOpenedAtAsc(Long handoffSessionId);

    long countByHandoffSessionId(Long handoffSessionId);
}
