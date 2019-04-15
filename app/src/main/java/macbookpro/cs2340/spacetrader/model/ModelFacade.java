package macbookpro.cs2340.spacetrader.model;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

/**
 * handles all of the game data between the model and view
 */
public class ModelFacade {
    private static ModelFacade instance;
    private static Game newGame;
    private static Player newPlayer;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("players");

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

    /**
     * creates the game with a certain game difficulty
     * @param difficulty difficulty selected by the player
     */
    public static void createGame(GameDifficulty difficulty) {
        newGame = new Game(difficulty);
    }

    /**
     * creates the player
     * @param name name entered by the player
     * @param pilot number of pilot points entered by the player
     * @param fighter number of fighter points entered by the player
     * @param trader number of trader points entered by the player
     * @param engineer number of engineer points entered by the player
     * @return String version of player
     */
    public static String createPlayer(String name,
                                      int pilot, int fighter, int trader, int engineer) {
        SolarSystem beginnerSolarSystem = newGame.getUniverse().retrieveBeginnerSolarSystem();
        newPlayer = new Player(name, pilot, fighter, trader, engineer, beginnerSolarSystem);
//        saveToDatabase();
        return newPlayer.toString();
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
