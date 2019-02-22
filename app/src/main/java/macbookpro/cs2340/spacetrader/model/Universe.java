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
