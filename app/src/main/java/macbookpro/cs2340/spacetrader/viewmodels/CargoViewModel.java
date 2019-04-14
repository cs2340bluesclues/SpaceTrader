package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
//import android.util.Log;
//import android.util.Pair;

//import java.util.List;
import java.util.Map;


import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
//import macbookpro.cs2340.spacetrader.model.ModelFacade;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Ship;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

/**
 * ViewModel for the cargo screen, maintaining data such as player, ship,
 * planet, market, and cargo
 */
public class CargoViewModel extends AndroidViewModel {

    private final Map<MarketInfo, Integer> cargoMap;
    private final Ship currShip;
    private final Player player;
    private final Market market;
    private final Planet currPlanet;


    /**
     * Constructor for the CargoViewModel class, initializes data
     * @param application The application object
     */
    public CargoViewModel(@NonNull Application application) {
        super(application);
        currShip = getCurrentShip();
        cargoMap = currShip.getCargo();
        player = getNewPlayer();
        market = getCurrentMarket();
        currPlanet = getCurrentPlanet();
    }

    /**
     * Getter for cargo map
     * @return The cargo mep instance variable
     */
    public Map<MarketInfo, Integer> getCargoMap() {
        return cargoMap;
    }

    /**
     * Getter for currPlanet
     * @return currPlanet instance data
     */
    public Planet getCurrPlanet() {
        return currPlanet;
    }

    /**
     * Getter for player instance data
     * @return player instance variable
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter for player name
     * @return the player's name
     */
    public String getPlayerName() {
        return player.getName();
    }

    /**
     * Getter for player's credits
     * @return The player's credit amount
     */
    public int getPlayerCredits() {
        return player.getCredits();
    }

    /**
     * Getter method for market instance variable
     * @return The market instance variable
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Getter method for remaining Cargo
     * @return remainingCargo data from currShip
     */
    public int getRemainingCargo() {
        return currShip.getRemainingCargo();
    }


}