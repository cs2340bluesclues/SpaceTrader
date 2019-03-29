package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Set;

import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getCurrentPlanet;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getCurrentSolarSystem;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewGame;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

public class TravelPlanetViewModel extends AndroidViewModel {

    Player player;
    Planet currPlanet;
    SolarSystem currSolarSystem;

    public TravelPlanetViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        currPlanet = getCurrentPlanet();
        currSolarSystem = getCurrentSolarSystem();
    }

    public Planet getCurrPlanet() {
        return currPlanet;
    }

    public SolarSystem getCurrSolarSystem() {
        return currSolarSystem;
    }

    public Set<SolarSystem> getAllSS() {
        return getNewGame().getUniverse().getSystem();
    }


}
