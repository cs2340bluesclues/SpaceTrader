package macbookpro.cs2340.spacetrader.model;

import macbookpro.cs2340.spacetrader.model.Universe.Universe;

public class Game {

    private GameDifficulty diff;
    private Universe universe;
    private int travelCount = 10;

    /**
     * Game constructor; makes an instance of game, which creates a universe and sets game
     * difficulty
     * @param diff player-selected difficulty of game
     */
    public Game(GameDifficulty diff) {
        universe = new Universe(10,10);
        this.diff = diff;
    }

    /**
     * method to say that travel happens in the game and for the player
     */
    public void travel() {
        if (travelCount == 0) {
            universe.generateEvents();
            travelCount = 10;
        } else {
            travelCount--;
        }
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
     * @return game difficulty
     */
    public GameDifficulty getDiff() {
        return diff;
    }

    /**
     * getter for universe
     * @return universe
     */
    public Universe getUniverse() {
        return universe;
    }
}
