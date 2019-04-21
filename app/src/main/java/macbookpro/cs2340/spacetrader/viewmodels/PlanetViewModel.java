package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import macbookpro.cs2340.spacetrader.model.ModelFacade;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Ship;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

/**
 * ViewModel class for planet screen
 */
public class PlanetViewModel extends AndroidViewModel {

    private final Player player;
    private final Ship ship;
    private final Planet currPlanet;
    private ModelFacade modelFacade; //is this right? not sure
    //int fuelCost;

    /**
     * Constructor for planet vew model
     * @param application The application
     */
    public PlanetViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        ship = player.getShip();
        currPlanet = player.getCurrentPlanet();
        //fuelCost = player.getCurrentPlanet().calculateFuelCost();

    }

    /**
     * Refuels the player's ship by a specified amount
     * @param quantityToRefuel the amount to increase the player's fuel
     */
    public void refuelShip(int quantityToRefuel) {
        player.refuelShip(quantityToRefuel);
    }

    /**
     * Getter for player instance data
     * @return player instance data
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter for currPlanet instance data in player
     * @return currPlanet instance data as a string
     */
    public String getCurrPlanet() {
        return currPlanet.toString();
    }

    /**
     * Getter for credits instance data
     * @return credits instance data
     */
    public int getCredits() {
        return player.getCredits();
    }

    /**
     * Getter for player name instance data
     * @return player name instance data
     */
    public String getPlayerName() {
        return player.getName();
    }

    /**
     * Getter for ship instance data
     * @return ship instance data as a string
     */
    public String getShip() {
        return ship.toString();
    }

    /**
     * Getter for maxFuel instance data
     * @return maxFuel instance data
     */
    public int getMaxFuel() {
        return ship.getMAX_FUEL();
    }

    /**
     * Getter for fuelPrice instance data
     * @return fuelPrice instance data
     */
    public int getFuelPrice() {
        return currPlanet.getFuelCost();
    }

    /**
     * Getter for currFuel instance data
     * @return currFuel instance data
     */
    public int getCurrFuel() {return ship.getCurrFuel(); }
}
