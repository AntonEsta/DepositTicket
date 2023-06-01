package web.lombard.lombard.api.DepositTicket.models.security;

import web.lombard.lombard.api.DepositTicket.models.security.dto.SignInDTO;

public interface AuthService {
    String login(SignInDTO signInDTO);
}
