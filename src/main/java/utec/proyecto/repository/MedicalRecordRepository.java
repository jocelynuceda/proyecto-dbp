package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.MedicalRecord;

import java.time.Instant;
import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

    List<MedicalRecord> findByPersonId(Long personId);

    List<MedicalRecord> findByPersonIdAndUpdatedAtAfter(Long personId, Instant since);
}
