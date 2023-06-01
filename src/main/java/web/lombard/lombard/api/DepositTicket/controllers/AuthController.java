package web.lombard.lombard.api.DepositTicket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.lombard.lombard.api.DepositTicket.models.security.AuthService;
import web.lombard.lombard.api.DepositTicket.models.security.dto.JWTAuthResponse;
import web.lombard.lombard.api.DepositTicket.models.security.dto.SignInDTO;

@RestController()
@RequestMapping("/pawnshop/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JWTAuthResponse> signInUser(@RequestBody SignInDTO signInDTO) {
        String token = authService.login(signInDTO);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }
}
