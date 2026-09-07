package utec.proyecto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utec.proyecto.model.*;
import utec.proyecto.repository.CareRelationshipRepository;
import utec.proyecto.repository.PersonRepository;
import utec.proyecto.repository.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Registrar personas a cargo e invitar cuidadores (funcionalidad 1 del MVP).
 * Las dependencias son `final` e inyectadas por constructor: Spring resuelve
 * automáticamente los beans de tipo UserRepository, PersonRepository y
 * CareRelationshipRepository al crear este servicio, sin necesidad de
 * @Autowired en los campos.
 */
@Service
@RequiredArgsConstructor
public class CareRelationshipService {

    private final CareRelationshipRepository careRelationshipRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public CareRelationship invite(Long inviterUserId, Long personId, Long inviteeUserId, CareRole role) {
        User invitee = userRepository.findById(inviteeUserId)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado: " + inviteeUserId));
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new NoSuchElementException("Persona no encontrada: " + personId));

        CareRelationship relationship = CareRelationship.builder()
                .user(invitee)
                .person(person)
                .role(role)
                .status(CareStatus.ACTIVE)
                .invitedAt(Instant.now())
                .build();

        return careRelationshipRepository.save(relationship);
    }

    public List<CareRelationship> findActiveCaregiversOf(Long personId) {
        return careRelationshipRepository.findByPersonIdAndStatus(personId, CareStatus.ACTIVE);
    }

    public List<CareRelationship> findActivePeopleOf(Long userId) {
        return careRelationshipRepository.findByUserIdAndStatus(userId, CareStatus.ACTIVE);
    }

    public void revoke(Long userId, Long personId) {
        CareRelationship relationship = careRelationshipRepository.findByUserIdAndPersonId(userId, personId)
                .orElseThrow(() -> new NoSuchElementException("Relación no encontrada"));
        relationship.setStatus(CareStatus.REVOKED);
        careRelationshipRepository.save(relationship);
    }
}
