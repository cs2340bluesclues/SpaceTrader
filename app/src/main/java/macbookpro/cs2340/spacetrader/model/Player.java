package macbookpro.cs2340.spacetrader.model;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Class for the player of the game
 */
public class Player {
    private final String name;
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
    private int totalSkillPoints;
    private int credits;
    private Ship ship;
    private boolean lawfulStatus;
    private SolarSystem currentSolarSystem;
    private Planet currentPlanet;
    private Market currentMarket;
    private final Random rand;

    //private final DatabaseReference mDatabase =
    // FirebaseDatabase.getInstance().getReference("players");


    /**
     * Constructor for player class, initializing all of its instance data
     * @param name The player's name
     * @param pilot Player's pilot skill points
     * @param fighter Player's fighter skill points
     * @param trader Player's trader skill points
     * @param engineer Player's engineer skill points
     * @param solarSystem The player's current solar system
     */
    public Player(String name, int pilot, int fighter, int trader, int engineer,
                  SolarSystem solarSystem) {
        this.name = name;
        this.pilot = pilot;
        this.fighter = fighter;
        this.trader = trader;
        this.engineer = engineer;
        totalSkillPoints = pilot + fighter + trader + engineer;
        lawfulStatus = true;
        credits = 1000;
        ship = new Ship(ShipType.GNAT);
        currentSolarSystem = solarSystem;
        currentPlanet = solarSystem.findBeginnerPlanet();
        currentMarket = currentPlanet.getMarket();
        rand = new Random();

        //saveToDatabase();
    }

    private void saveToDatabase(){
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
        List<Object> list = new ArrayList<>();
        list.add(name);

        list.add(pilot);
        list.add(fighter);
        list.add(trader);
        list.add(engineer);
        list.add(lawfulStatus);list.add(credits);
        list.add(ship);
        list.add(currentSolarSystem);
        list.add(currentPlanet);
        list.add(rand);


        //String playerID = mDatabase.push().getKey();
        //mDatabase.child(playerID).setValue(list);
    }

    /**
     * Refuels the player's ship
     * @param quantityToRefuel The amount to increase the fuel by
     */
    public void refuelShip(int quantityToRefuel) {
        if (credits > currentPlanet.getFuelCost()) {
            credits -= currentPlanet.getFuelCost() * quantityToRefuel;
            ship.refuel(quantityToRefuel);
        }
    }

    /**
     * Makes the player travel if able to
     * @param nextSol The next solar system to travel to
     * @param nextPlanet The next planet to travel to
     * @return If the travel was successful
     */
    public boolean travel(SolarSystem nextSol, Planet nextPlanet) {
        if (ship.canTravel(nextSol.getCoords(), currentSolarSystem.getCoords())) {
            ship.updateFuel(nextSol.getCoords(), currentSolarSystem.getCoords());
            currentPlanet = nextPlanet;
            currentSolarSystem = nextSol;
//            updateCargoPrices();
            return true;
        }
        return false;
    }

//    private void updateCargoPrices() {
//        ship.updateCargoPrices(currentPlanet.getEvent(), currentPlanet.getTechLevel(),
//        currentPlanet.getResources());
//    }

    /**
     * Buys items from the market
     * @param item Which item is being bought
     * @param quantityToPurchase The amount of the item to buy
     * @return Whether or not the purchase was successful
     */
    public boolean buy(MarketInfo item, int quantityToPurchase) {
        //int count = 0;
        boolean bought = false;

        if ((credits > item.getPrice()) && currentMarket.buyAsPlayer(item, quantityToPurchase)) {
            if (ship.addItem(item, quantityToPurchase)) {
                credits -= (item.getPrice()*quantityToPurchase);
                //count++;
                bought = true;
            }
        }
        return bought;
    }

    /**
     * Sells items from player's cargo to the market
     * @param item The item to sell
     * @param quantity The quantity of the item to sell
     * @return Whether or not the selling was successful
     */
    public boolean sell(MarketInfo item, int quantity) {
        int count = 0;
        boolean sold = false;
        while ((count < quantity) && ship.removeItem(item, quantity)) {
            credits += (item.getPrice() * quantity);
            currentMarket.sellAsPlayer(item);
            ship.removeItem(item, quantity);
            count++;
            sold = true;
        }
        return sold;
    }

    /**
     * Determines the likelihood of being stopped by the police
     * @return true or false if event should occur
     */
    public boolean policeEvent() {
        if (!lawfulStatus) {
            return rand.nextInt(10) <= 2;
        }
        return rand.nextInt(10) == 0;
//        return true;
    }

    /**
     * Determines the likelihood of being stopped by pirates
     * @return true or false if event should occur
     */
    public boolean pirateEvent() {
        double chance = ((credits / 5000.00) * 10) - 1;
        int threshold = rand.nextInt(100);
        return threshold < chance;
//        return true;

    }

    /**
     * Determines whether or not you can beat the pirates in battle
     * with a combination of randomness and fighter skill.
     * @return Whether or not you win the fight
     */

    public boolean fightPirate() {
        int pirateFightSkill = rand.nextInt(10);
        return fighter >= pirateFightSkill;
    }

    /**
     * Determines whether or not you can flee from the pirates or police
     * with a combination of randomness and pilot skill.
     * @return Whether or not you escape
     */

    public boolean flee() {
        int opponentPilotSkill = rand.nextInt(10);
        return pilot >= opponentPilotSkill;
    }

    /**
     * Subtracts 5000 credit fine for carrying illegal goods from credits
     */
    public void payFine() {
        if ((credits - 5000) > 0) {
            credits -= 5000;
        } else {
            credits = 0;
        }
    }

    /**
     * Pays the police a bribe to not be searched
     */
    public void payBribe() {
        int bribe = (credits * 15) / 100;
        credits = credits - bribe;
    }

    /**
     * Calculates the price of a piece of cargo
     * @param item The item in question
     * @return The price
     */
    public int calculateCargoPrice(MarketInfo item) {
        return item.getPrice();
    }

    /**
     * Returns player name
     * @return player name attribute
     */
    public String getName() {
        return name;
    }

    /**
     * Returns player total skill points
     * @return player totalSkillPoints attribute
     */
    private int getTotalSkillPoints() {
        return totalSkillPoints;
    }

    /**
     * setter for player total skill points
     * @param totalSkillPoints the new value of skill points
     */
    public void setTotalSkillPoints(int totalSkillPoints) {
        this.totalSkillPoints = totalSkillPoints;
    }

    /**
     * Getter for pilot skill points
     * @return player's pilot skill points
     */
    private int getPilot() {
        return pilot;
    }

    /**
     * setter for pilot skill points
     * @param pilot the new value of skill points
     */
    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    /**
     * Getter for fighter skill points
     * @return player's fighter skill points
     */
    private int getFighter() {
        return fighter;
    }

    /**
     * setter for fighter skill points
     * @param fighter the new value of skill points
     */
    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    /**
     * Getter for trader skill points
     * @return player's trader skill points
     */
    private int getTrader() {
        return trader;
    }

    /**
     * setter for trader skill points
     * @param trader the new value of skill points
     */
    public void setTrader(int trader) {
        this.trader = trader;
    }

    /**
     * Getter for engineer skill points
     * @return player's engineer skill points
     */
    private int getEngineer() {
        return engineer;
    }

    /**
     * setter for engineer skill points
     * @param engineer the new value of skill points
     */
    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    /**
     * getter for credits
     * @return player's credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * setter for credits
     * @param credits the new value of credits
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * getter for ship
     * @return player's ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * setter for ship
     * @param ship player's new ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * checks player's lawful status
     * @return boolean checking whether player is lawful or not
     */
    public boolean isLawfulStatus() {
        return lawfulStatus;
    }

    /**
     * setter for player's lawful status
     * @param lawfulStatus boolean stating player's lawful status
     */
    public void setLawfulStatus(boolean lawfulStatus) {
        this.lawfulStatus = lawfulStatus;
    }

    /**
     * getter for current solar system
     * @return current solar system
     */
    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    /**
     * setter for current solar system
     * @param currentSolarSystem new current solar system
     */
    public void setCurrentSolarSystem(SolarSystem currentSolarSystem) {
        this.currentSolarSystem = currentSolarSystem;
    }

    /**
     * getter for current planet
     * @return player's current planet
     */
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /**
     * setter for current planet
     * @param currentPlanet new current planet
     */
    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    /**
     * to string method
     * @return player as a string
     */
    public String toString() {
        return "name: " + this.getName() + "\n pilot: " + this.getPilot() + "\n fighter: "
                + this.getFighter() + "\n trader:" + this.getTrader() + "\n engineer: "
                + this.getEngineer() + "\n total skill points: " + this.getTotalSkillPoints()
                + "\n credits: " + this.getCredits() + "\n ship: " + this.getShip().getName();
    }

    /**
     * getter for the current planet's market
     * @return current planet's market
     */
    public Market getMarket() { return currentPlanet.getMarket(); }
}
