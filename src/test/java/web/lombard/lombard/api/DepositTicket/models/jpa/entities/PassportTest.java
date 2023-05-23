package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.PassportRepository;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PassportTest {

    @Autowired
    static PassportRepository passportRepository;
    static Passport passport;


    @BeforeEach
    void setUp() {
        passport = new Passport("x1","x2", "x3", "x3", LocalDateTime.now().);
    }

    @Test
    void getId() {
        passportRepository.save(person);
         person.getId();
    }

    @Test
    void getPerson() {
    }
}