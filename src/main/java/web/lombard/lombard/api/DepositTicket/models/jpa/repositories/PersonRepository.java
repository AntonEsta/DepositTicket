package web.lombard.lombard.api.DepositTicket.models.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
