package macbookpro.cs2340.spacetrader.model;

import android.util.Log;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Universe {

    private Set<SolarSystem> system;
    private Random r;
    private int numSolarSystems;

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

    public void travel() {
        //something that allows to go to new solar system coords
    }

}
