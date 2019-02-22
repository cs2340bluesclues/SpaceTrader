package macbookpro.cs2340.spacetrader.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
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
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./Names"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while ((line = reader.readLine()) != null) {
            names.add(line);
        }
        reader.close();
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    public void addSolarSystem() {
        system.add(new SolarSystem("n", new Coord(1, 0)));
    }

    public void travel() {
        //something that allows to go to new solar system coords
    }

}
