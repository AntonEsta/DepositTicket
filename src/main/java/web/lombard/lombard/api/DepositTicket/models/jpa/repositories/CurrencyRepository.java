package web.lombard.lombard.api.DepositTicket.models.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.CurrencyEntity;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
    Optional<CurrencyEntity> findByIsoCodeString(String isoCodeString);
}
