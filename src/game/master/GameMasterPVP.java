package game.master;

import game.GameHelper;
import game.field.PlayingField;
import game.field.Symbol;
import game.exception.GameException;
import game.player.ConsolePlayer;

import java.io.BufferedReader;
import java.io.IOException;

public class GameMasterPVP extends GameMaster {
    public GameMasterPVP(BufferedReader reader, PlayingField playingField) {
        super(reader, playingField);
    }

    @Override
    public void createPlayers() {
        try {
            System.out.print("Введите имя первого игрока: ");
            String player1Name = reader.readLine();
            player1 = new ConsolePlayer(player1Name, Symbol.X, reader);

            System.out.print("Введите имя второго игрока: ");
            String player2Name = reader.readLine();
            player2 = new ConsolePlayer(player2Name, Symbol.O, reader);

            activePlayer = GameHelper.chooseRandom(player1, player2);
        } catch (IOException exception) {
            throw new GameException("Не удалось прочитать с консоли", exception);
        }
    }
}
