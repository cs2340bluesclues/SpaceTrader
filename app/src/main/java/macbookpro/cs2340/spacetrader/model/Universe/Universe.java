package macbookpro.cs2340.spacetrader.model.Universe;

import android.util.Log;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public Universe() {

    }
    /**
     * method to change what SolarSystem the player will interact with
     */
    public void travel() {
        //something that allows to go to new solar system coords
    }

    public SolarSystem retrieveBeginnerSolarSystem(){
        //SolarSystem randomSolarSystem; //also may be tiny bit messed up
        SolarSystem randomSolarSystem = null;
        for(SolarSystem aSolarSystem: system) {
            randomSolarSystem = aSolarSystem;
        }
        Log.i("StartVM", "find beginner planet is " + randomSolarSystem.findBeginnerPlanet());
        return randomSolarSystem;

        //return randomSolarSystem.findBeginnerPlanet();
    }

    public Set<SolarSystem> getSystem() {
        return system;
    }

}
