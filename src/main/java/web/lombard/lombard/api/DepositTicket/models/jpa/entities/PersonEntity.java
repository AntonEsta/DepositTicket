package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persons")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "person_id")
    Long id;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    String firstName;

    @Column(nullable = false)
    @NotBlank
    String patronymic;

    @Column(name = "surname", nullable = false)
    @NotBlank
    String surname;

    @Column(nullable = false)
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    Date birthday;

    @Column(nullable = false)
    @NotBlank
    String registration;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PassportEntity> passports = new ArrayList<>();

    public PersonEntity(String firstName, String patronymic, String surname, Date birthday, String registration) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birthday = birthday;
        this.registration = registration;
    }

    PassportEntity getActualPassport() {
        if (passports.size() == 0) {
            return null;
        }
        passports.sort(Comparator.comparing(PassportEntity::getIssueDate));
        return passports.get(0);
    }

}
