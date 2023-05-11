package game.master;

import game.GameHelper;
import game.field.PlayingField;
import game.field.Symbol;
import game.exception.GameException;
import game.player.ComputerPlayer;
import game.player.ConsolePlayer;

import java.io.BufferedReader;
import java.io.IOException;

public class GameMasterPVE extends GameMaster {
    public GameMasterPVE(BufferedReader reader, PlayingField playingField) {
        super(reader, playingField);
    }

    @Override
    public void createPlayers() {
        try {
            System.out.println("Введите имя игрока: ");
            String player1Name = reader.readLine();
            player1 = new ConsolePlayer(player1Name, Symbol.X, reader);

            player2 = new ComputerPlayer(Symbol.O, playingField);

            activePlayer = GameHelper.chooseRandom(player1, player2);

        } catch (IOException exception) {
            throw new GameException("Не удалось прочитать с консоли", exception);
        }
    }
}
