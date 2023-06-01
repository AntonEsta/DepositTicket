package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.Transient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.DepositTicketRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepositTicketEntityTest {

    @Transient
    @Autowired
    DepositTicketRepository depositTicketRepository;
    Long id = 1L;

    @Test
    public void createTicket() {
        var org = new OrganizationEntity("Ломбард №1", "Ломбард №1", 1234567891, 123456789, 1, "123456, город Град, улица Мира, дом 5", "123456, город Град, улица Мира, дом 5", "+79131231212", "email@lombard1.com", "www.lombard1.com");
        List<PaymentEntity> paymentEntities = new ArrayList<>();
        paymentEntities.add(new PaymentEntity(BigDecimal.valueOf(10_000), Calendar.getInstance().getTime(), false));
        var loan = new LoanEntity(BigDecimal.valueOf(10_000), 103.3, "RUB", "null", "", Calendar.getInstance().getTime(), paymentEntities);
        var person = new PersonEntity("Иван", "Иванович", "Иванов", Date.valueOf(LocalDate.now()), "адрес");
        var ticket = new DepositTicketEntity(1021, Date.valueOf(LocalDate.now()), org, person, loan);
        depositTicketRepository.save(ticket);
        DepositTicketEntity savedTicket = depositTicketRepository.findById(ticket.getId()).orElse(null);
        assert savedTicket != null;
        assertEquals(savedTicket.getOrganizationEntity().getEmail(), ticket.getOrganizationEntity().getEmail());
        depositTicketRepository.deleteById(savedTicket.getId());
    }

}