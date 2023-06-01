package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "organization_id")
    Long id;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2, max = 255)
    String title;           //    фирменное наименование ломбарда

    @Column(name = "full_title", nullable = false)
    @Size(min = 2, max = 255)
    String fullTitle;       //    полное фирменное наименование ломбарда указанное к ОГРН

    // TODO Check validation annotations
    @Column(name = "inn", unique = true, nullable = false, length = 10)
    @Digits(integer = 10, fraction = 0)
    Integer inn;             //    индивидуальный номер налогоплательщика (ИНН) ломбарда


    // TODO Check validation annotations
    @Column(name = "ogrn", unique = true, nullable = false, length = 10)
    @Digits(integer = 12, fraction = 0)
    Integer ogrn;            //    основной государственный регистрационный номер (ОГРН) ломбарда

    @Column(name = "reg_number", nullable = false, unique = true)
    @Positive
    int registrationNumber;  //    регистрационный номер в государственном реестре ломбардов

    @Column(name = "actual_location", nullable = false)
    @Size(min = 2, max = 255)
    String actualLocation;  //    адрес (место нахождения)

    @Column(name = "legal_address", nullable = false)
    @Size(min = 2, max = 255)
    String legalAddress;    //    юридический адрес

    @Column(name = "number_telephone", nullable = false)
    @Size(min = 2, max = 255)
    String telephone;       //    номер телефона

    @Email(regexp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")
    String email;           //    адрес электронной почты (при наличии) ломбарда

    @Pattern(regexp = "^(https?\\:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})(\\/[\\w]*)*$")
    String website;         //    адрес официального сайта ломбарда в информационно-телекоммуникационной сети "Интернет" (при наличии)

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    List<SubdivisionEntity> subdivisions = new ArrayList<>();

    public OrganizationEntity(@NonNull String title, @NonNull String fullTitle, @NonNull Integer inn, @NonNull Integer ogrn, @NonNull Integer registrationNumber, @NonNull String actualLocation, @NonNull String legalAddress, @NonNull String telephone, String email, String website) {
        this.title = title;
        this.fullTitle = fullTitle;
        this.inn = inn;
        this.ogrn = ogrn;
        this.registrationNumber = registrationNumber;
        this.actualLocation = actualLocation;
        this.legalAddress = legalAddress;
        this.telephone = telephone;
        this.email = email;
        this.website = website;
    }
}
