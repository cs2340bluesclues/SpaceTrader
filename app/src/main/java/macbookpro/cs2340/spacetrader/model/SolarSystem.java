package macbookpro.cs2340.spacetrader.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SolarSystem {

    private static List<String> nameList = new ArrayList<>(Arrays.asList(new String[]{"Aldea",
            "Andevian", "Baratas", "Brax", "Calondia", "Capelle",
            "Carzon", "Cestus", "Cheron", "Damast", "Draylon", "Drema", "Endor", "Esmee",
            "Exo", "Ferris", "Fourmi", "Frolix", "Gemulon", "Helena", "Iralius", "Janus",
            "Japori", "Jarada", "Jason", "Kaylon", "Keanu", "Khefka", "Kira", "Klaatu",
            "Korma", "Kravat", "Krios", "Malcoria", "Melina", "Merik", "Mintaka", "Montor",
            "Mordan", "Myrthe", "Nelvana", "Nix", "Nile", "Parade", "Picard", "Quator",
            "Rakhar", "Rhymus", "Rochani", "Rubicum", "Sarpeidon", "Sefalla", "Sol", "Stakoron",
            "Styris", "Tantalos", "Tarchannen", "Thera", "Titan", "Triacus", "Tyrus", "Vandor",
            "Ventax", "Xenon", "Xerxes", "Yojimbo", "Zalkon", "Zuul"}));
    
    private static Set<Coord> coordsSet = new HashSet<>();
    private HashSet<Planet> planets;
    private String name;
    private Coord coords;
    private int numPlanets;
    private Random r;

    public SolarSystem(Random random) {
        r = random;
        this.name = nameList.remove(r.nextInt(nameList.size()));

        // Not sure if this works correctly

        Coord temp = new Coord(r.nextInt(16), r.nextInt(16));
        //while adding temp returns false (meaning there's a duplicate), regenerate
        while (!coordsSet.add(temp)) {
            temp = new Coord(r.nextInt(16), r.nextInt(16));
        }
        coordsSet.add(temp);
        coords = temp;

        // populates solar system with planets
        planets.add(new Planet(name));
        numPlanets = r.nextInt(3);
        for (int i = 0; i < numPlanets; i++) {
            addPlanet();
        }

        //print to log cat
        for (Planet s: planets) {
            Log.i("Universe" , "a planet made: " + s.getName());
        }
    }

    private void addPlanet() {
        String planetName = nameList.remove(r.nextInt(nameList.size()));
        planets.add(new Planet(planetName));
    }

}
