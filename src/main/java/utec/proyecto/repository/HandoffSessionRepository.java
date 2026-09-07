package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.HandoffSession;

import java.util.Optional;

public interface HandoffSessionRepository extends JpaRepository<HandoffSession, Long> {

    Optional<HandoffSession> findByTokenHash(String tokenHash);
}
