package macbookpro.cs2340.spacetrader.model;

import java.util.HashSet;

public class Universe {
    private HashSet<SolarSystem> system;

    public Universe() {
        system = new HashSet<>();
    }

    public void addSolarSystem(SolarSystem s) {
        system.add(s);
    }

    public void travel() {
        //something that allows to go to new solar system coords
    }

}
