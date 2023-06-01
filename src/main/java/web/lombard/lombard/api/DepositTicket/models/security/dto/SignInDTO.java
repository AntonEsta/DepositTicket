package web.lombard.lombard.api.DepositTicket.models.security.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class SignInDTO {

    String username;
    String password;

}
