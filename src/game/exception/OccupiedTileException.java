package game.exception;

public class OccupiedTileException extends RetryableGameException {

    public OccupiedTileException(String message) {
        super(message);
    }

    public OccupiedTileException(String message, Throwable cause) {
        super(message, cause);
    }
}
