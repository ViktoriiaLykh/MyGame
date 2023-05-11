package game.exception;

public class RetryableGameException extends GameException {

    public RetryableGameException(String message) {
        super(message);
    }

    public RetryableGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
