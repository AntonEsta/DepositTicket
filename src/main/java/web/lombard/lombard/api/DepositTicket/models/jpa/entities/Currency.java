package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
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

    @Column(name = "sign_utf8")
    @NotBlank
    Character signUTF8;

    public Currency(String name, Integer isoCodeNumber, String isoCodeString, Character signUTF8) {
        this.name = name;
        this.isoCodeNumber = isoCodeNumber;
        this.isoCodeString = isoCodeString;
        this.signUTF8 = signUTF8;
    }

}
