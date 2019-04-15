package macbookpro.cs2340.spacetrader.model.Universe;

import android.util.Log;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * universe class, creates solar systems, retrieves beginning solar system
 */
public class Universe {

    private Set<SolarSystem> system;
    private Random r;
    private int numSolarSystems;

    /**
     * Universe constructor instantiates the HashSet of SolarSystems, creates random SolarSystems
     * and adds them to the HashSet
     *
     * @param n number of SolarSystems to be created and added to the set
     * @param seed value for the random generator
     */
    public Universe(int n, int seed) {
        system = new HashSet<>();
        r = new Random(seed);
        numSolarSystems = n;
        for (int i = 0; i < numSolarSystems; i++) {
            system.add(new SolarSystem(r));
            seed++;
            r.setSeed(seed);
        }

        //print to log cat
        for (SolarSystem s: system) {
            s.printSolarSystem();
        }
    }

    /**
     * no-args constructor for universe
     */
    public Universe() {

    }
    /**
     * Method that makes the events on every planet in the universe change
     */
    public void generateEvents() {
        for (SolarSystem s : system) {
            for (Planet p : s.getPlanets()) {
                p.regeneratePlanet();
            }
        }
    }

    /**
     * Method that returns the first SolarSystem that you start on
     * @return SolarSystem that you first land in
     */
    public SolarSystem retrieveBeginnerSolarSystem(){
        SolarSystem randomSolarSystem = null;
        for(SolarSystem aSolarSystem: system) {
            randomSolarSystem = aSolarSystem;
        }
        Log.i("StartVM", "find beginner planet is " + randomSolarSystem.findBeginnerPlanet());
        return randomSolarSystem;
    }


    /**
     * Getter method to retrieve all the SolarSystems in the Universe
     * @return Set all the SolarSystems
     */
    public Set<SolarSystem> getSystem() {
        return system;
    }

}
