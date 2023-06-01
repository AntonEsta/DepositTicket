package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "passports")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class PassportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "passport_id")
    Long id;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 0)
    Integer serial;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 0)
    Integer number;

    @Column(name = "issue_place", nullable = false)
    @NotBlank
    String issuePlace;

    @Column(name = "issue_date", nullable = false)
    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    Date issueDate;

    @ManyToOne
    PersonEntity person;

    public PassportEntity(Integer serial, Integer number, String issuePlace, Date issueDate, PersonEntity personEntity) {
        this.serial = serial;
        this.number = number;
        this.issuePlace = issuePlace;
        this.issueDate = issueDate;
        this.person = personEntity;
    }
}
