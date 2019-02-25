package macbookpro.cs2340.spacetrader.model;

import java.util.Random;

public class Game {

    private GameDifficulty diff;
    private Universe universe;

    /**
     * Game constructor; makes an instance of game, which creates a universe and sets game
     * difficulty
     * @param diff player-selected difficulty of game
     */
    public Game(GameDifficulty diff) {
        universe = new Universe(10, 10);
        this.diff = diff;
    }

    /**
     * Setter for the game difficulty level
     * @param diff
     */
    public void setDiff(GameDifficulty diff) {
        this.diff = diff;
    }

    /**
     * getter for the game difficulty level
     * @return
     */
    public GameDifficulty getDiff() {
        return diff;
    }
}
