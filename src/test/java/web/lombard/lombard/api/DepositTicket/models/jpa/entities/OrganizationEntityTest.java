package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.OrganizationRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrganizationEntityTest {

    @Autowired
    OrganizationRepository organizationRepository;
    Long id = 1L;

    @Test
    public void createOrganization() {
        OrganizationEntity organizationEntity = new OrganizationEntity("Ломбард №1", "Ломбард №1", 1234567891, 123456789, 1, "123456, город Град, улица Мира, дом 5", "123456, город Град, улица Мира, дом 5", "+79131231212", "email@lombard1.com", "www.lombard1.com");
        organizationRepository.save(organizationEntity);
        OrganizationEntity orgFromDB = organizationRepository.findById(organizationEntity.getId()).orElse(null);
        assert orgFromDB != null;
        assertEquals(orgFromDB.getInn(), organizationEntity.getInn());
        organizationRepository.deleteById(orgFromDB.getId());
    }

}