package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "passports")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    Long id;

    @Column(name = "title", nullable = false)
    @NotBlank
    String documentTitle;

    @Column(nullable = false)
    @NotBlank
    String series;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Pattern(regexp = "^\\d{6}$")
    @Size(min = 6, max = 6)
    String number;

    @Column(name = "issue_place", nullable = false)
    @NotBlank
    String issuePlace;

    @Column(name = "issue_date", nullable = false)
    @PastOrPresent
    Date issueDate;

    @Transient
    @OneToOne(fetch = FetchType.LAZY)
    Person person;

//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn(name = "previous_passport_id")
//    Passport previousPassport;

    public Passport(String documentTitle, String series, String number, String issuePlace, Date issueDate) {
        this.documentTitle = documentTitle;
        this.series = series;
        this.number = number;
        this.issuePlace = issuePlace;
        this.issueDate = issueDate;
    }

}
