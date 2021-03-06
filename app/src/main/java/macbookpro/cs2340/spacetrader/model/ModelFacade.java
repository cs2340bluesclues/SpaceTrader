package macbookpro.cs2340.spacetrader.model;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
//import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

/**
 * handles all of the game data between the model and view
 */
public class ModelFacade {
    private static ModelFacade instance;
    private static Game newGame;
    private static Player newPlayer;
    public static final String DEFAULT_JSON_FILE_NAME = "data.json";
    //DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("players");

    /**
     * getter current instance of this class
     * @return instance of ModelFacade
     */
    public static ModelFacade getInstance() {
        if(instance == null){
            instance = new ModelFacade();
        }
        return instance;
    }

    public static void createGame(GameDifficulty difficulty, String name,
                                      int pilot, int fighter, int trader, int engineer ) {
        newGame = new Game(difficulty, name, pilot, fighter, trader, engineer);
        newPlayer = newGame.getPlayer();
    }

    /**
     * getter for the game
     * @return instance of game
     */
    public static Game getNewGame() {
        return newGame;
    }

    /**
     * travel method
     * @param system solar system to travel to
     * @param planet planet to travel to
     * @return boolean whether this is travel is possible or not
     */
    public static boolean travel(SolarSystem system, Planet planet) {
        newGame.travel();
        return newPlayer.travel(system, planet);
    }

//    public static void saveToDatabase(){
    public boolean loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automagically
            Gson gson = new Gson();

            newGame = gson.fromJson(inString, Game.class);

            input.close();
        } catch (IOException e) {
            Log.e("ModelFacade", "Failed to open/read the buffered reader for json");
            return false;
        }

        return true;

    }

    public boolean saveJson(File file ) {
        try {
            PrintWriter writer = new PrintWriter(file);
            /*
                We are using the Google Gson library to make things easy.  You will need to add the
                following line to your gradle file so the proper dependencies are set up:
                compile 'com.google.code.gson:gson:2.3'

                Gson, like object serialization will take a single object and save all the objects
                it refers to.  You can save everything by one reference, as long as it is the
                top-level reference.
             */
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(newGame); //??????????????????
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to open json file for output");
            return false;
        }
        return true;
    }
//    public static void saveToDatabase(){
//        // Get a reference to our posts
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference();
//
//        // Attach a listener to read the data at our posts reference
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String post = dataSnapshot.getValue(String.class);
//                System.out.println(post);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });

//        String playerID = mDatabase.push().getKey();
//        mDatabase.child(playerID).setValue(newPlayer);
//    }

    /**
     * getter for the player
     * @return player
     */
    public static Player getNewPlayer() {
        return newPlayer;
    }

    /**
     * getter for current solar system
     * @return current solar system
     */
    public static SolarSystem getCurrentSolarSystem() { return newPlayer.getCurrentSolarSystem(); }

    /**
     * getter for current planet
     * @return current planet
     */
    public static Planet getCurrentPlanet( ){ return newPlayer.getCurrentPlanet(); }

    /**
     * getter for current market
     * @return current market
     */
    public static Market getCurrentMarket() {return newPlayer.getMarket(); }

    /**
     * getter for current ship
     * @return current ship
     */
    public static Ship getCurrentShip() {return newPlayer.getShip();}

    /**
     * getter for current credits
     * @return current number of credits
     */
    public static int getCurrentCredits() {return newPlayer.getCredits();}


}
