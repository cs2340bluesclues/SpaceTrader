package macbookpro.cs2340.spacetrader.model;
import android.util.Log;

import java.util.Random;

public class Planet {

    private String name;
    private Resources resources;
    private TechLevel techLevel;

    public Planet(String name) {
        this.name = name;
        int resourceOrdinal = randomGen(12);
        int techOrdinal = randomGen(7);
        resources = Resources.values()[resourceOrdinal];
        techLevel = TechLevel.values()[techOrdinal];
    }

    private int randomGen(int max) {
        Random generator = new Random();
        int output = generator.nextInt(max);
        return output;
    }

    public String getName() {
        return name;
    }

    public void printPlanet() {
        Log.i("Universe", "a Planet made: " + getName());
    }
}
