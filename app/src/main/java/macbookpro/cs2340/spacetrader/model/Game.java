package macbookpro.cs2340.spacetrader.model;

import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;
import macbookpro.cs2340.spacetrader.model.Universe.Universe;

/**
 * The game class which initializes the game universe and
 * holds a game difficulty
 */
public class Game {

    private GameDifficulty diff;
    private final Universe universe;
    private Player player;
    private int travelCount = 10;

    /**
     * Game constructor; makes an instance of game, which creates a universe and sets game
     * difficulty
     * @param diff player-selected difficulty of game
     */
    public Game(GameDifficulty diff, String name,
                int pilot, int fighter, int trader, int engineer) {
        universe = new Universe(10,10);
        this.diff = diff;
        createPlayer(name, pilot, fighter, trader, engineer);
    }

    public String createPlayer(String name,
                                      int pilot, int fighter, int trader, int engineer) {
        SolarSystem beginnerSolarSystem = this.getUniverse().retrieveBeginnerSolarSystem();
        player = new Player(name, pilot, fighter, trader, engineer, beginnerSolarSystem);
//        saveToDatabase();
        return player.toString();
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
     * @param diff The game difficulty
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

    public Player getPlayer() {
        return player;
    }
}
