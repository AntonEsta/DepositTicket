package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @PositiveOrZero
    BigDecimal summa;   // сумма платежа

    @Column(name = "payment_date", nullable = false)
    @NotNull
    @FutureOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    Date paymentDate;   // дата платежа

    @Column(name = "execution_note", nullable = false)
    Boolean executed;  // отметка об исполнении платежа


    @ManyToOne(fetch = FetchType.LAZY)
    LoanEntity loan;

    public PaymentEntity(BigDecimal summa, Date paymentDate, boolean executed) {
        this.summa = summa;
        this.paymentDate = paymentDate;
        this.executed = executed;
    }
}
