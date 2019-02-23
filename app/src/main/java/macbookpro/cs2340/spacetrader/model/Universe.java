package macbookpro.cs2340.spacetrader.model;

import java.util.HashSet;
import java.util.Random;

public class Universe {

    private HashSet<SolarSystem> system;
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
    }

    public void travel() {
        //something that allows to go to new solar system coords
    }

}
