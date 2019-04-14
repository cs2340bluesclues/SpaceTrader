package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Map;

import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

/**
 * ViewModel for the Market screen
 */
public class MarketViewModel extends AndroidViewModel {

    private final Map<MarketInfo, Integer> marketInfoMap;
    private final Planet currPlanet;
    private final Player player;
    private final Market market;

    /**
     * Constructor for the Market View Model
     * @param application The Application
     */
    public MarketViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        currPlanet = getCurrentPlanet();
        market = getCurrentMarket();
        marketInfoMap = currPlanet.getMarket().getMarketGoods();
        Log.i("StartVM", "got till line 27 in STARTVM. Curr planet is " + currPlanet);
    }

    /**
     * Getter for marketInfos
     * @return marketInfo instance data
     */
    public Map<MarketInfo, Integer> getMarketInfos() {
        return marketInfoMap;
    }

    /**
     * Getter for currPlanet
     * @return currPlanet instance data
     */
    public Planet getCurrPlanet() {
        return currPlanet;
    }

    /**
     * Getter for player
     * @return player instance data
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter for playerName
     * @return playerName instance data
     */
    public String getPlayerName() {
        return player.getName();
    }

    /**
     * Getter for credits from player
     * @return credits instance data in player
     */
    public int getPlayerCredits() {
        return player.getCredits();
    }

    /**
     * Getter for market
     * @return market instance data
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Getter for remainingCargo in ship
     * @return remainingCargo instance data in ship
     */
    public int getRemainingCargo() {
        return player.getShip().getRemainingCargo();
    }


}