package macbookpro.cs2340.spacetrader.model;

import java.util.Random;

public class Game {

    private GameDifficulty diff;

    public Game(GameDifficulty diff) {

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
