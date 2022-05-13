package kruten.overmobile.error;

import kruten.overmobile.exception.AlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorMessage> handleAnyException(AlreadyExistException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus("1");
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
}
