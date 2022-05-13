package kruten.overmobile.response;

import kruten.overmobile.exception.AlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Message> handleAnyException() {
        Message message = new Message();
        message.setStatus(1);
        return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    }
