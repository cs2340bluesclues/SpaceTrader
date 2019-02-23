package macbookpro.cs2340.spacetrader.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SolarSystem {

    private static List<String> nameList = new ArrayList<>(Arrays.asList(new String[]{"Aldea", "Andevian", "Baratas", "Brax", "Calondia", "Capelle",
            "Carzon", "Cestus", "Cheron", "Damast", "Draylon", "Drema", "Endor", "Esmee",
            "Exo", "Ferris", "Fourmi", "Frolix", "Gemulon", "Helena", "Iralius", "Janus",
            "Japori", "Jarada", "Jason", "Kaylon", "Keanu", "Khefka", "Kira", "Klaatu",
            "Korma", "Kravat", "Krios", "Malcoria", "Melina", "Merik", "Mintaka", "Montor",
            "Mordan", "Myrthe", "Nelvana", "Nix", "Nile", "Parade", "Picard", "Quator",
            "Rakhar", "Rhymus", "Rochani", "Rubicum", "Sarpeidon", "Sefalla", "Sol", "Stakoron",
            "Styris", "Tantalos", "Tarchannen", "Thera", "Titan", "Triacus", "Tyrus", "Vandor",
            "Ventax", "Xenon", "Xerxes", "Yojimbo", "Zalkon", "Zuul"}));
    private static Map<Coord, Integer> coordsMap = new HashMap<>();
    private HashSet<Planet> planets;
    private String name;
    private Coord coords;

    public SolarSystem(int seed) {
        Random r = new Random(seed);
        this.name = nameList.remove(r.nextInt(nameList.size()));
        //I'm not sure if this works correctly
        Coord temp = new Coord(r.nextInt(16), r.nextInt(16));
        coordsMap.put(temp, temp.hashCode());
        planets.add(new Planet(name));
    }

}
