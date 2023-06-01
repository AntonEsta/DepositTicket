package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.LoanRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class LoanEntityTest {

    @Autowired
    LoanRepository loanRepository;

    @Test
    public void createLoan() {
        List<PaymentEntity> paymentEntities = new ArrayList<>(1);
        paymentEntities.add(new PaymentEntity(BigDecimal.valueOf(10_000), Calendar.getInstance().getTime(), false));
        var loan = new LoanEntity(BigDecimal.valueOf(10_000), 103.3, "руб.", "null", "", Calendar.getInstance().getTime(), paymentEntities);
        var savedLoan = loanRepository.save(loan);
        savedLoan = loanRepository.findById(savedLoan.getId()).orElse(null);
        assert savedLoan != null;
        assertEquals(savedLoan.getInterestRate(), loan.getInterestRate());
        assertEquals(savedLoan.getPayments().get(0).getPaymentDate(), loan.getPayments().get(0).getPaymentDate());
        loanRepository.deleteById(savedLoan.getId());
    }

}