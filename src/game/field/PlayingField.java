package game.field;


import game.exception.MatrixOutOfBoundsException;
import game.exception.OccupiedTileException;
import game.master.GameMaster;
import game.player.ConsolePlayer;
import game.player.Player;

import static game.field.Symbol.EMPTY;
import static game.field.Symbol.X;

public class PlayingField {

    private final Symbol[][] matrix;

    public PlayingField(int fieldSize) {
        matrix = new Symbol[fieldSize][fieldSize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = EMPTY;
            }
        }
    }

    public int getFieldSize() {
        return matrix.length;
    }

    public void setValue(Coordinate coordinate, Player player) throws MatrixOutOfBoundsException {
        if (coordinate.getX() > matrix.length || coordinate.getY() > matrix.length) {
            throw new MatrixOutOfBoundsException("Ты вышел за пределы поля. Выбери другую");
        }

        Symbol symbol = player.getSymbol();
        if (matrix[coordinate.getY()][coordinate.getX()] != EMPTY) {
                throw new OccupiedTileException("Эта клетка уже занята. Выбери другую");
        }
            matrix[coordinate.getY()][coordinate.getX()] = symbol;
    }

    @Override
    public String toString() {
        String res = "\n";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res += matrix[i][j].getUiValue() + " ";
            }
            res += "\n";
        }
        res += "\n";
        return res;
    }

    public boolean checkWinner(Symbol symbol) {
        return checkDiagonal(symbol) || checkLines(symbol) ;
    }

    private boolean checkDiagonal(Symbol symbol) {
        boolean toRight = true;
        boolean toLeft = true;


        for (int i = 0; i < matrix.length; i++) {
            toLeft &= symbol.equals(matrix[i][i]);
            toRight &= symbol.equals(matrix[i][matrix.length - i - 1]);
        }
        return toRight || toLeft;
    }

    private boolean checkLines(Symbol symbol) {
        boolean cols, rows;
        for (int col = 0; col < matrix.length; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < matrix.length; row++) {
                cols &= (matrix[col][row] == symbol);
                rows &= (matrix[row][col] == symbol);
            }
            if (cols || rows) return true;
        }
        return false;
    }
}



