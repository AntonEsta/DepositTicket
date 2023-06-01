package web.lombard.lombard.api.DepositTicket.models.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "subdivisions")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class SubdivisionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    @NotBlank
    String address;

    @ManyToOne
    OrganizationEntity organization;

}
