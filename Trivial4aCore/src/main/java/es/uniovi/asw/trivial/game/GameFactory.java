package es.uniovi.asw.trivial.game;

import java.net.UnknownHostException;

public class GameFactory {

    public static Game getNewGame() throws UnknownHostException {
        return new GameObject();
    }

}
