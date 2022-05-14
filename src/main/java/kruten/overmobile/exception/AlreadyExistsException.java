package kruten.overmobile.exception;

import kruten.overmobile.entity.User;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(User user) {
    }
}
