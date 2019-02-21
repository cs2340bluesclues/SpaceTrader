package macbookpro.cs2340.spacetrader.model;

import java.util.HashSet;

public class SolarSystem {

    private HashSet<Planet> planets;
    private String name;
    private Coord coords;

    public SolarSystem(String name, Coord coords) {
        this.name = name;
        this.coords = coords;
        planets = new HashSet<>();
    }

    public void addPlanet(Planet p) {
        planets.add(p);
    }

}
