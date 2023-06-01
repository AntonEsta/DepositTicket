package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.NaturalId;

import java.util.Date;

@Entity
@Table(name = "deposit_tickets")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class DepositTicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ticket_id")
    Long id;

    @NaturalId
    @Column(name = "ticket_number", nullable = false)
    @DecimalMin("1")
    @Digits(integer = 6, fraction = 0)
    Integer ticketNumber;

    @NaturalId
    @Column(name = "ticket_date", nullable = false)
    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    Date ticketDate;

    @OneToOne(cascade = CascadeType.ALL)
    OrganizationEntity organizationEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    PersonEntity person;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    LoanEntity loan;

    public DepositTicketEntity(Integer ticketNumber, Date ticketDate, OrganizationEntity organizationEntity, PersonEntity personEntity, LoanEntity loanEntity) {
        this.ticketNumber = ticketNumber;
        this.ticketDate = ticketDate;
        this.organizationEntity = organizationEntity;
        this.person = personEntity;
        this.loan = loanEntity;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

}
