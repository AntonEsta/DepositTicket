package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "currencies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class CurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "currency_id")
    Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    String name;

    @Column(name = "iso_code_number", unique = true, nullable = false, precision = 3, scale = 0)
    @Digits(integer = 3, fraction = 0)
    @Positive
    Integer isoCodeNumber;

    @Column(name = "iso_code_char", nullable = false, unique = true, length = 3)
    @NotBlank
    @Size(min = 3, max = 3)
    String isoCodeString;

    public CurrencyEntity(String name, Integer isoCodeNumber, String isoCodeString) {
        this.name = name;
        this.isoCodeNumber = isoCodeNumber;
        this.isoCodeString = isoCodeString;
    }

}
