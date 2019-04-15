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
import macbookpro.cs2340.spacetrader.model.Universe.Coord;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getCurrentPlanet;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getCurrentSolarSystem;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewGame;
import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

/**
 * View Model for the Travel screen
 */
public class TravelPlanetViewModel extends AndroidViewModel {

    private final Player player;
    private final Planet currPlanet;
    private final SolarSystem currSolarSystem;
    private final Coord coords;

    /**
     * Constructor for the view model
     * @param application The application
     */
    public TravelPlanetViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        currPlanet = getCurrentPlanet();
        currSolarSystem = getCurrentSolarSystem();
        coords = currSolarSystem.getCoords();
    }

    /**
     * Getter for the currPlanet instance data
     * @return the currPlanet instance data
     */
    public Planet getCurrPlanet() {
        return currPlanet;
    }

    /**
     *
     * @return name
     */
    public String getCurrPlanetName() {
        return currPlanet.getName();
    }

    /**
     *
     * @return name
     */
    public String coordToString() {
        return coords.toString();
    }

    /**
     * Getter for the currSolarSystem instance data
     * @return the currSolarSystem instance data
     */
    public SolarSystem getCurrSolarSystem() {
        return currSolarSystem;
    }


    /**
     *
     * @param selectedSolarSystem
     * @return
     */
    public int calculateDistance(SolarSystem selectedSolarSystem) {
        return coords.calculateDistance(selectedSolarSystem.getCoords());
    }




    /**
     * Getter for the set of Solar systems instance data
     * @return the set of all solar systems
     */
    public Set<SolarSystem> getAllSS() {
        return getNewGame().getUniverse().getSystem();
    }

    /**
     * Transports the player to a new planet
     * @param nextSol The next solar system
     * @param nextPlanet The next planet
     * @return Whether or not the travel succeeded
     */
    public boolean travel(SolarSystem nextSol, Planet nextPlanet) {
        Log.i("travel", "traveling to " + nextSol + " in " + nextPlanet);
        return ModelFacade.travel(nextSol, nextPlanet);
    }

    /**
     * Decides if the player encounters the police
     * @return Whether or not the player encounters the police
     */
    public boolean policeEvent() {
        return player.policeEvent();
    }

    /**
     * Decides if the player encounters pirates
     * @return Whether or not the player encounters pirates
     */
    public boolean pirateEvent() {
        return player.pirateEvent();
    }

}
