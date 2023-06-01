package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "loans")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class LoanEntity {

//    @Transient
//    @Autowired()
//    CurrencyRepository currencyRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "loan_id")
    Long id;

    @Column(nullable = false, scale = 2)
    @PositiveOrZero
    BigDecimal summa;           // Сумма потребительского займа или лимит кредитования

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    Double interestRate;   // Процентная ставка в процентах годовых

//    @OneToOne
//    @PrimaryKeyJoinColumn
//    Currency currency;

    @NotBlank
    String currency;

    @Column(name = "loan_term", nullable = false)
    @Size(min = 3, max = 255)
    @NotBlank
    String loanTerm;    //

    @Column(name = "determining_exchange_rate", nullable = false)
    @ColumnDefault("'Не применимо'")
    String determiningForeignExchangeRate;        // Порядок определения курса иностранной валюты при переводе денежных средств кредитором третьему лицу, указанному заемщиком

    @Column(name = "return_date", nullable = false)
    @NotNull
    @FutureOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    Date returnDate;    // Срок действия договора потребительского займа, срок возврата займа

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PaymentEntity> payments;

    @PrePersist
    public void prePersist() {
        if (determiningForeignExchangeRate == null || determiningForeignExchangeRate.isBlank()) {
            determiningForeignExchangeRate = "Не применимо";
        }
    }

    public LoanEntity(BigDecimal summa, Double interestRate, String currency, String loanTerm, String determiningForeignExchangeRate, Date returnDate, List<PaymentEntity> paymentEntities) {
        this.summa = summa;
        this.interestRate = interestRate;
        this.currency = currency;
        this.loanTerm = loanTerm;
        this.determiningForeignExchangeRate = determiningForeignExchangeRate;
        this.returnDate = returnDate;
        this.payments = paymentEntities;
    }

//    public void setCurrency(@NotBlank @Size(min = 3, max = 3) String isoCodeString) {
//        this.currency = currencyRepository.findByIsoCodeString(isoCodeString).orElseThrow(() -> new DataNotFoundException("Iso Code of currency not found!"));
//    }

}
