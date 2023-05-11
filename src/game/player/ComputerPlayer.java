package game.player;

import game.field.Coordinate;
import game.field.PlayingField;
import game.field.Symbol;

public class ComputerPlayer extends Player {

    private final PlayingField playingField;

    public ComputerPlayer(Symbol symbol, PlayingField playingField) {
        super("Глупый робот", symbol);
        this.playingField = playingField;
    }

    @Override
    public Coordinate makeMove() {
        int coordinateX = (int) (Math.random() * playingField.getFieldSize());
        int coordinateY = (int) (Math.random() * playingField.getFieldSize());

        return new Coordinate(coordinateX, coordinateY);
    }
}
