package game.exception;

public class InputFormatException extends RetryableGameException {
    public InputFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
