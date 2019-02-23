package macbookpro.cs2340.spacetrader.model;

import java.util.HashSet;

public class Universe {

    private HashSet<SolarSystem> system;

    public Universe() {
        system = new HashSet<>();
    }

    public void addSolarSystem(int seed) {
        SolarSystem s1 = new SolarSystem(seed);
    }

    public void travel() {
        //something that allows to go to new solar system coords
    }

}
