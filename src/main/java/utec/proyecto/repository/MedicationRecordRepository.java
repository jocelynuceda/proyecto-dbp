package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.MedicationRecord;

public interface MedicationRecordRepository extends JpaRepository<MedicationRecord, Long> {
}
