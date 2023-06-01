package web.lombard.lombard.api.DepositTicket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.lombard.lombard.api.DepositTicket.controllers.exceptions.DataNotFoundException;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.DepositTicketEntity;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.DepositTicketRepository;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/pawnshop/api/v1/tickets")
public class DepositTicketsController {

    @Autowired
    DepositTicketRepository depositTicketRepository;

    @GetMapping("/")
    List<DepositTicketEntity> allDepositTickets() {
        return Optional.of(depositTicketRepository.findAll())
                .orElseThrow(DataNotFoundException::new);
    }

    @GetMapping("/count")
    int getDepositTickets() {
        return depositTicketRepository.findAll().size();
    }
}
