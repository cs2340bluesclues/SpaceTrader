package macbookpro.cs2340.spacetrader.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

public class ModelFacade {
    private static ModelFacade instance;
    private static Game newGame;
    private static Player newPlayer;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("players");

    public static ModelFacade getInstance() {
        if(instance == null){
            instance = new ModelFacade();
        }
        return instance;
    }

    public static void createGame(GameDifficulty difficulty) {
        newGame = new Game(difficulty);
    }

    public static String createPlayer(String name,
                                      int pilot, int fighter, int trader, int engineer) {
        SolarSystem beginnerSolarSystem = newGame.getUniverse().retrieveBeginnerSolarSystem();
        newPlayer = new Player(name, pilot, fighter, trader, engineer, beginnerSolarSystem);
//        saveToDatabase();
        return newPlayer.toString();
    }

    public static Game getNewGame() {
        return newGame;
    }

    public static boolean travel(SolarSystem system, Planet planet) {
        newGame.travel();
        return newPlayer.travel(system, planet);
    }

    public static void saveToDatabase(){
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
    }


    public static Player getNewPlayer() {
        return newPlayer;
    }

    public static SolarSystem getCurrentSolarSystem() { return newPlayer.getCurrentSolarSystem(); }

    public static Planet getCurrentPlanet( ){ return newPlayer.getCurrentPlanet(); }

    public static Market getCurrentMarket() {return newPlayer.getMarket(); }

    public static Ship getCurrentShip() {return newPlayer.getShip();}

    public static int getCurrentCredits() {return newPlayer.getCredits();}


}
