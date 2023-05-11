package game.player;

import game.field.Coordinate;
import game.field.Symbol;

public abstract class Player {
    private final String name;
    private final Symbol symbol;

    public abstract Coordinate makeMove();

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
