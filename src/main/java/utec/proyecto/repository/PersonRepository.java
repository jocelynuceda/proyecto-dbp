package utec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.proyecto.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
