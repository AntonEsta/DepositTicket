package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.PassportRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.PersonRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PersonEntityTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Test
    public void createPersonTest(){
        var person = new PersonEntity("Иван", "Иванович", "Иванов", Date.valueOf(LocalDate.now()), "адрес");
        var passport = new PassportEntity(0565, 663690, "ОВД", Calendar.getInstance().getTime(), person);
        person.getPassports().add(passport);
        PersonEntity savedPersonEntity = personRepository.save(person);
        person = personRepository.findById(savedPersonEntity.getId()).orElse(null);
        assert person != null;
        assertEquals(person.getFirstName(),"Иван");
        assertEquals(person.getPassports().get(0).getNumber(), passport.getNumber());
        personRepository.deleteById(savedPersonEntity.getId());
        passportRepository.deleteAll();
    }

}