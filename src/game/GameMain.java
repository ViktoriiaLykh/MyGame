package game;

import game.field.PlayingField;
import game.master.GameMaster;
import game.master.GameMasterPVE;
import game.master.GameMasterPVP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class GameMain {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int matrixSize = getMatrixSize();

        PlayingField playingField = new PlayingField(matrixSize);

        System.out.println("Выберите режим игры. Введите цифру 1 для игры в режиме PVP (игрок против игрока) или цифру 2 для игры в режиме PVE (игрок против робота)");
        int mode = Integer.parseInt(reader.readLine());

        GameMaster gameMaster = mode == 1 ?
                new GameMasterPVP(reader, playingField) :
                new GameMasterPVE(reader, playingField);

        gameMaster.createPlayers();
        gameMaster.takeTurnsPlaying();
    }


    public static int getMatrixSize() throws IOException {
        while (true) {
            int input = Integer.parseInt(reader.readLine());
            if (input >= 1 && input <= 10) {
                return input;
            }
        }
    }
}
