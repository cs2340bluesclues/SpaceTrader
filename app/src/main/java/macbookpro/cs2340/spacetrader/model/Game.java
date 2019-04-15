package macbookpro.cs2340.spacetrader.model;

import android.util.Log;

import java.io.Serializable;

import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;
import macbookpro.cs2340.spacetrader.model.Universe.Universe;

public class Game implements Serializable {

    /**
     * the difficulty level to create the game
     * @serial
     */
    private GameDifficulty diff;
    /**
     * the universe in which the player can travel
     * @serial
     */
    private final Universe universe;
    /**
     * the player
     * @serial
     */
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
        SolarSystem beg = universe.retrieveBeginnerSolarSystem();
        player = new Player(name, pilot, fighter, trader, engineer, beg);
    }

//    public String createPlayer(String name,
//                                      int pilot, int fighter, int trader, int engineer) {
//        SolarSystem beginnerSolarSystem = this.getUniverse().retrieveBeginnerSolarSystem();
//        player = new Player(name, pilot, fighter, trader, engineer, beginnerSolarSystem);
////        saveToDatabase();
//        return player.toString();
//    }

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

    public Player getPlayer() {
        return player;
    }
}
