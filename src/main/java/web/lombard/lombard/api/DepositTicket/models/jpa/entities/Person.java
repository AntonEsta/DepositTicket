package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "persons")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    Long id;

    @NotBlank
    String name;

    @NotBlank
    String secondName;

    @NotBlank
    String lastName;

    //    Date dateOfBirth;
//    String address;

//    @OneToMany(fetch = FetchType.LAZY)
//            @PrimaryKeyJoinColumn(name = "person_id")
//    Passport[] passport;


    public Person(String name, String secondName, String lastName) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
    }
}
