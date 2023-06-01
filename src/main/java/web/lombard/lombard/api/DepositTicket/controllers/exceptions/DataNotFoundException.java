package web.lombard.lombard.api.DepositTicket.controllers.exceptions;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@StandardException
public class DataNotFoundException extends RuntimeException {
}
