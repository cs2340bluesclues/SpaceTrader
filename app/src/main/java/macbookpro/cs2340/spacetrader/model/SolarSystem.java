package macbookpro.cs2340.spacetrader.model;

import java.util.HashSet;

public class SolarSystem {

    private HashSet<Planet> planets;
    private Coord coords;

    public SolarSystem() {
        planets = new HashSet<>();
    }

}
