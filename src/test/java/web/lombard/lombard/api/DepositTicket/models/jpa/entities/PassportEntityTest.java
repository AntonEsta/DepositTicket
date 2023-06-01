package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.PassportRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.PersonRepository;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PassportEntityTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PassportRepository passportRepository;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void createPassportTest(){
        PersonEntity personEntity = new PersonEntity("Иван", "Иванович", "Иванов", Date.from(Instant.parse("01.01.2021")), "адрес");
        personRepository.save(personEntity);
        PassportEntity savedPassportEntity = passportRepository.save(new PassportEntity(0565, 663690, "ОВД", Calendar.getInstance().getTime(), personEntity));
        PassportEntity passportEntity = passportRepository.findById(savedPassportEntity.getId()).orElse(null);
        assert passportEntity != null;
        assertEquals(passportEntity.getNumber(), savedPassportEntity.getNumber());
        assertEquals(passportEntity.getPerson().getFirstName(), savedPassportEntity.getPerson().getFirstName());
        assertEquals(passportEntity.getPerson(), savedPassportEntity.getPerson());
        passportRepository.deleteById(savedPassportEntity.getId());
    }

}