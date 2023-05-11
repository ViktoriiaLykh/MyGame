package game.master;

import game.GameHelper;
import game.field.Coordinate;
import game.field.PlayingField;
import game.player.ConsolePlayer;
import game.player.Player;

import java.io.BufferedReader;

public abstract class GameMaster {
    Player player1;
    Player player2;

    Player activePlayer;

    final BufferedReader reader;

    final PlayingField playingField;
    boolean isWinner = true;

    public abstract void createPlayers();

    public GameMaster(BufferedReader reader, PlayingField playingField) {
        this.reader = reader;
        this.playingField = playingField;
    }

    public void takeTurnsPlaying() {
        for (int i = 0; i < playingField.getFieldSize() * playingField.getFieldSize(); i++) {
            takeTurn();
            System.out.print(playingField);
            isWinner = playingField.checkWinner(activePlayer.getSymbol());
            if (isWinner) {
                System.out.println(activePlayer.getName() + " выиграл(а)");
                break;
            }
            activePlayer = activePlayer.equals(player1) ? player2 : player1;
        }
        if (!isWinner) {
            System.out.println("Победила дружба!");
        }

    }
    private void takeTurn() {
        boolean isConsolePlayer = activePlayer instanceof ConsolePlayer;
        if (isConsolePlayer) {
            System.out.print(activePlayer + " сделай свой ход: ");
        }
        GameHelper.retryOnException(()-> {
            Coordinate player1Move = activePlayer.makeMove();
            playingField.setValue(player1Move, activePlayer);
        }, isConsolePlayer);
    }
}
