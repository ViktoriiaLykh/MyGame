package game.player;

import game.field.Coordinate;
import game.field.Symbol;
import game.exception.GameException;
import game.exception.InputFormatException;

import java.io.BufferedReader;
import java.io.IOException;


public class ConsolePlayer extends Player{

    private final BufferedReader reader;

    public ConsolePlayer(String name, Symbol symbol, BufferedReader reader) {
        super(name, symbol);
        this.reader = reader;
    }

    @Override
    public Coordinate makeMove() throws GameException {
        int coordinateX = 0;
        int coordinateY = 0;
        try {
            String coordinate = reader.readLine();
            String[] coordinates = coordinate.split(" ");
            coordinateX = Integer.parseInt(coordinates[0]);
            coordinateY = Integer.parseInt(coordinates[1]);
            return new Coordinate(coordinateX - 1, coordinateY - 1);
        } catch (IOException exception) {
            throw new GameException("Не получилось считать с консоли", exception);
        } catch (NumberFormatException exception) {
            throw new InputFormatException("Пожалуйста введите 2 цифры через пробел", exception);
        }

    }
}