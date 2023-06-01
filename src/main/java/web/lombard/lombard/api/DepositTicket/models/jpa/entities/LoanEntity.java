package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Autowired;
import web.lombard.lombard.api.DepositTicket.controllers.exceptions.DataNotFoundException;
import web.lombard.lombard.api.DepositTicket.models.jpa.repositories.CurrencyRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "loans")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
//@AllArgsConstructor(onConstructor_ = {@Autowired})
@Data
public class LoanEntity {

    @Transient
    @Autowired
    CurrencyRepository currencyRepository;

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

    @OneToOne
    @PrimaryKeyJoinColumn
    CurrencyEntity currency;

//    @NotBlank
//    String currency;

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

    @Autowired
    public LoanEntity(BigDecimal summa, Double interestRate, String currencyIsoCodeString, String loanTerm, String determiningForeignExchangeRate, Date returnDate, List<PaymentEntity> paymentEntities) {
        this.summa = summa;
        this.interestRate = interestRate;
        this.currency = getCurrencyByIsoCodeString(currencyIsoCodeString);
        this.loanTerm = loanTerm;
        this.determiningForeignExchangeRate = determiningForeignExchangeRate;
        this.returnDate = returnDate;
        this.payments = paymentEntities;
    }

    public void setCurrency(@NotBlank @Size(min = 3, max = 3) String isoCodeString) {
        this.currency = getCurrencyByIsoCodeString(isoCodeString);
    }

    private CurrencyEntity getCurrencyByIsoCodeString(@NotBlank @Size(min = 3, max = 3) String isoCodeString) {
        return currencyRepository.findByIsoCodeString(isoCodeString).orElseThrow(() -> new DataNotFoundException("Iso Code of currency not found!"));
    }

}
