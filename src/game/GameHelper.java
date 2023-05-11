package game;

import game.exception.RetryableGameException;

public final class GameHelper {
    @SafeVarargs
    public static <T> T chooseRandom(T... players) {
        int random = (int) (Math.random() * players.length);
        return players[random];
    }

    public static void retryOnException(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (RetryableGameException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
