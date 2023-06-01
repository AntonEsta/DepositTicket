package web.lombard.lombard.api.DepositTicket.models.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.security.RoleEntity;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
