package web.lombard.lombard.api.DepositTicket.models.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.OrganizationEntity;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
}
