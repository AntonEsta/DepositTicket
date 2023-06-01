package web.lombard.lombard.api.DepositTicket.models.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.security.RoleEntity;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.security.UserEntity;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(String name);
}
