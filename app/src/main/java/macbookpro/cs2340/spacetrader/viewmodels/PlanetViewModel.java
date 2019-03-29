package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import macbookpro.cs2340.spacetrader.model.Player;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class PlanetViewModel extends AndroidViewModel {

    Player player;
    int fuelCost;

    public PlanetViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        fuelCost = player.getCurrentPlanet().calculateFuelCost();

    }

    public Player getPlayer() {
        return player;
    }

    public String getCurrPlanet() {
        return "" + player.getCurrentPlanet().toString();
    }

    public int getCredits() {
        return player.getCredits();
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getShip() {
        return player.getShip().toString();
    }

    public int getShipFuel() {
        return player.getShip().getMAX_FUEL();
    }

    public int getFuelPrice() {
        return fuelCost;
    }

}
