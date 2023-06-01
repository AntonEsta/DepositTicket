package web.lombard.lombard.api.DepositTicket.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(DepositTicketsController.class)
class DepositTicketsControllerTestEntity {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepositTicketsController depositTicketsController;

    @BeforeEach
    void setUp() {
//        Stream.of(
//                new DepositTicket(1L, new Organization("Org1", "Org1", 1234567891, 1234567891, 10, "Бобруйск", "Бобруйск", "+79132221122", "mail@mail.ru", "www.web.com"), new Person(1L, "Иванов", "Иван", "Иванович"), new Loan(1L, 30_000D, 103D, "Term", "", Date.from());
//        );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void allDepositTickets() {
//        ResultActions response = mockMvc.perform()
    }

    @Test
    void getDepositTickets() {
    }

    @Test
    void testGetDepositTickets() {
    }
}