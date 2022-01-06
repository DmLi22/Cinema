package by.shag.litvinov.exception;

public class EntityServiceException extends RuntimeException {

    public EntityServiceException() {
    }

    public EntityServiceException(String message) {
        super(message);
    }

    public EntityServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
