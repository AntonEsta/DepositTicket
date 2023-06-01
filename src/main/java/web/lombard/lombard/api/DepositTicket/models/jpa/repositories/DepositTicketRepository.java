package web.lombard.lombard.api.DepositTicket.models.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.DepositTicketEntity;

public interface DepositTicketRepository extends JpaRepository<DepositTicketEntity, Long> {
}
