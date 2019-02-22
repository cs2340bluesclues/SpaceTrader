package macbookpro.cs2340.spacetrader.model;

import java.util.Random;

public class Game {

    private GameDifficulty diff;

    /**
     * Game constructor; makes an instance of game, which creates a universe and sets game
     * difficulty
     * @param diff player-selected difficulty of game
     */
    public Game(GameDifficulty diff) {
        Universe universe = new Universe();
        this.diff = diff;
    }

    public void setDiff(GameDifficulty diff) {
        this.diff = diff;
    }

    public GameDifficulty getDiff() {
        return diff;
    }

    public Universe generateUniverse(int seed) {
        Random random = new Random(seed);
        return null;
    }
}
