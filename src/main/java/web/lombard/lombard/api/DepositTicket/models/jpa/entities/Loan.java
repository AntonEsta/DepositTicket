package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "loans")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    Long id;

    @Column(nullable = false, scale = 2)
    @PositiveOrZero
    Double summa;           // Сумма потребительского займа или лимит кредитования

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    Double interestRate;   // Процентная ставка в процентах годовых

    @Column(name = "loan_term", nullable = false)
    @Size(min = 3, max = 255)
    @NotBlank
    String loanTerm;    //

    @Column(name = "determining_exchange_rate", nullable = false)
    @ColumnDefault("'Не применимо'")
    @NotBlank
    String DeterminingForeignExchangeRate;        // Порядок определения курса иностранной валюты при переводе денежных средств кредитором третьему лицу, указанному заемщиком

    @Column(name = "return_date", nullable = false, updatable = false)
    @NotNull
    @PastOrPresent
    @CreationTimestamp
    Date returnDate;    // Срок действия договора потребительского займа, срок возврата займа

//    Payment[] payments;

}
