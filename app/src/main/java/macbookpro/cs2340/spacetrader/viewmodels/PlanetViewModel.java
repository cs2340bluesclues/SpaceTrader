package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import macbookpro.cs2340.spacetrader.model.ModelFacade;
import macbookpro.cs2340.spacetrader.model.Player;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class PlanetViewModel extends AndroidViewModel {

    private Player player;
    private ModelFacade modelFacade; //is this right? not sure
    //int fuelCost;

    public PlanetViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        //fuelCost = player.getCurrentPlanet().calculateFuelCost();

    }

    public void refuelShip(int quantityToRefuel) {
        player.refuelShip(quantityToRefuel);
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

    public int getMaxFuel() {
        return player.getShip().getMAX_FUEL();
    }

    public int getFuelPrice() {
        return player.getCurrentPlanet().getFuelCost();
    }

    public int getCurrFuel() {return player.getShip().getCurrFuel(); }
}
