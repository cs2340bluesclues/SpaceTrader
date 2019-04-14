package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;

import java.util.List;
import java.util.Map;


import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.ModelFacade;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Ship;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class CargoViewModel extends AndroidViewModel {

    private final Map<MarketInfo, Integer> cargoMap;
    private final Ship currShip;
    private final Player player;
    private final Market market;
    private final Planet currPlanet;


    public CargoViewModel(@NonNull Application application) {
        super(application);
        currShip = getCurrentShip();
        cargoMap = currShip.getCargo();
        player = getNewPlayer();
        market = getCurrentMarket();
        currPlanet = getCurrentPlanet();
    }

    public Map<MarketInfo, Integer> getCargoMap() {
        return cargoMap;
    }

    public Planet getCurrPlanet() {
        return currPlanet;
    }

    public Player getPlayer() {
        return player;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public int getPlayerCredits() {
        return player.getCredits();
    }

    public Market getMarket() {
        return market;
    }

    public int getRemainingCargo() {
        return currShip.getRemainingCargo();
    }


}