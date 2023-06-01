package web.lombard.lombard.api.DepositTicket.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import web.lombard.lombard.api.DepositTicket.controllers.exceptions.DataNotCreatedException;
import web.lombard.lombard.api.DepositTicket.controllers.exceptions.DataNotFoundException;
import web.lombard.lombard.api.DepositTicket.models.jpa.ProlongationLoanData;
import web.lombard.lombard.api.DepositTicket.models.jpa.entities.DepositTicketEntity;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.DepositTicketRepository;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.LoanRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@RestController()
@AllArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/pawnshop/api/v1/ticket")
public class DepositSingleTicketController {

//    @Autowired
    DepositTicketRepository depositTicketRepository;

//    @Autowired
    LoanRepository loanRepository;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    DepositTicketEntity depositTicketsById(@PathVariable("id") Long id) {
        return depositTicketRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    DepositTicketEntity addNewDepositTicket(@RequestBody @Valid DepositTicketEntity depositTicketEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                stringBuilder.append(fieldError).append("\n");
            }
            new ValidationException(stringBuilder.toString());
        }
        return Optional.of(depositTicketRepository.save(depositTicketEntity))
                .orElseThrow(DataNotCreatedException::new);
    }

    @PatchMapping("/prolongation")
    @ResponseStatus(HttpStatus.OK)
    DepositTicketEntity prolongateDepositTicket(@RequestBody ProlongationLoanData data) {
        var depositTicket = depositTicketRepository.findById(data.loanId())
                .orElseThrow(DataNotFoundException::new);
        depositTicket.getLoan().setReturnDate(getNewDate(depositTicket.getLoan().getReturnDate(), data.extraDays()));
        loanRepository.save(depositTicket.getLoan());
        return depositTicket;
    }

    private static Date getNewDate(Date preDate, int days) {
        var localPreDate = LocalDate.ofInstant(preDate.toInstant(), ZoneId.systemDefault());
        return Date.from(localPreDate.plusDays(days).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
