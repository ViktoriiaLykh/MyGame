package game.exception;

public class MatrixOutOfBoundsException extends RetryableGameException {


    public MatrixOutOfBoundsException(String message) {
        super(message);
    }

    public MatrixOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
