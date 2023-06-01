package web.lombard.lombard.api.DepositTicket.controllers.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllersExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse validationError(HttpMessageNotReadableException e) {
        return new ErrorResponseException(HttpStatus.BAD_REQUEST);
    }

    //    org.springframework.dao.DataIntegrityViolationException
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse DataIntegrityViolationError(DataIntegrityViolationException e) {
        ProblemDetail detail = ProblemDetail.forStatus(500);
        if (e.getMessage().contains("Duplicate entry")) {
            detail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), "Дублирование данных. Запись отменена.");
        }
        return new ErrorResponseException(HttpStatus.BAD_REQUEST, detail, null);
    }

}
