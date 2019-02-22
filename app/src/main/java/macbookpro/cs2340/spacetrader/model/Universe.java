package macbookpro.cs2340.spacetrader.model;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Universe {

    private HashSet<SolarSystem> system;
    private List<String> names;

    public Universe() {
        system = new HashSet<>();
        readList();
    }

    private void readList() {
        String[] planetNames = new String[]{
                "Aldea",
                "Andevian",
                "Baratas",
                "Brax",
                "Calondia",
                "Capelle",
                "Carzon",
                "Cestus",
                "Cheron",
                "Damast",
                "Draylon",
                "Drema",
                "Endor",
                "Esmee",
                "Exo",
                "Ferris",
                "Fourmi",
                "Frolix",
                "Gemulon",
                "Helena",
                "Iralius",
                "Janus",
                "Japori",
                "Jarada",
                "Jason",
                "Kaylon",
                "Keanu",
                "Khefka",
                "Kira",
                "Klaatu",
                "Korma",
                "Kravat",
                "Krios",
                "Malcoria",
                "Melina",
                "Merik",
                "Mintaka",
                "Montor",
                "Mordan",
                "Myrthe",
                "Nelvana",
                "Nix",
                "Nile",
                "Parade",
                "Picard",
                "Quator",
                "Rakhar",
                "Rhymus",
                "Rochani",
                "Rubicum",
                "Sarpeidon",
                "Sefalla",
                "Sol",
                "Stakoron",
                "Styris",
                "Tantalos",
                "Tarchannen",
                "Thera",
                "Titan",
                "Triacus",
                "Tyrus",
                "Vandor",
                "Ventax",
                "Xenon",
                "Xerxes",
                "Yojimbo",
                "Zalkon",
                "Zuul"
        };

        names = new ArrayList<String>(Arrays.asList(planetNames));
        Log.i("List creation", "List of Planet names made");

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("./Names"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                names.add(line);
//            }
//            reader.close();
//            for (int i = 0; i < names.size(); i++) {
//                //System.out.println(names.get(i));
//                Log.i("List creation", "List of Planet names made");
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }

    public void addSolarSystem() {
        system.add(new SolarSystem("n", new Coord(1, 0)));
    }

    public void travel() {
        //something that allows to go to new solar system coords
    }

}
