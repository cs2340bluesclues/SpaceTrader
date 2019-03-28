package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class PlanetViewModel extends AndroidViewModel {

    Player player;

    public PlanetViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
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

//    public int getFuelPrice() {
//        return player.getCurrentPlanet().getFuelCost();
//    }
}
