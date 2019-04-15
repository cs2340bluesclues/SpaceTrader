package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Set;

import macbookpro.cs2340.spacetrader.model.ModelFacade;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getCurrentPlanet;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getCurrentSolarSystem;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewGame;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

/**
 * manages data between model and view for travelling
 */
public class TravelPlanetViewModel extends AndroidViewModel {

    private final Player player;
    private final Planet currPlanet;
    private final SolarSystem currSolarSystem;

    /**
     * constructor,
     * @param application instance of this application?
     */
    public TravelPlanetViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        currPlanet = getCurrentPlanet();
        currSolarSystem = getCurrentSolarSystem();
    }

    /**
     * getter for current planet
     * @return player's current planet
     */
    public Planet getCurrPlanet() {
        return currPlanet;
    }

    /**
     * getter for current solar system
     * @return player's current solar system
     */
    public SolarSystem getCurrSolarSystem() {
        return currSolarSystem;
    }

    /**
     * getter for all solar systems
     * @return set of all solar systems
     */
    public Set<SolarSystem> getAllSS() {
        return getNewGame().getUniverse().getSystem();
    }

    /**
     * travel method
     * @param nextSol player chosen next solar system to travel to
     * @param nextPlanet player chosen next planet to travel to
     * @return boolean
     */
    public boolean travel(SolarSystem nextSol, Planet nextPlanet) {
        Log.i("travel", "traveling to " + nextSol + " in " + nextPlanet);
        return ModelFacade.travel(nextSol, nextPlanet);
    }

    public boolean policeEvent() {
        return player.policeEvent();
    }

    public boolean pirateEvent() {
        return player.pirateEvent();
    }

}
