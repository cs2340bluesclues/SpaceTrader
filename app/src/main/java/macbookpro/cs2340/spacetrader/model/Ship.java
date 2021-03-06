package macbookpro.cs2340.spacetrader.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import macbookpro.cs2340.spacetrader.model.Universe.Coord;

/**
 * The class for ships that the player uses
 */
public class Ship {

    private final String name;
    private int fuelLevel;
    private Map<MarketInfo, Integer> cargo;

    private final int MAX_CARGO;
    private final int MAX_FUEL;

    private int remainingCargo;

    /**
     * Constructor for the ship class
     * @param shipType The type of ship
     */
    public Ship(ShipType shipType) {
        this.name = shipType.getShipName();
        this.fuelLevel = getMAX_FUEL();
        this.cargo = new HashMap<>();

        this.MAX_CARGO = shipType.getCargoSpace();
        this.MAX_FUEL = shipType.getFuel();
        remainingCargo = MAX_CARGO;
    }

    /**
     * get ship name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * get ax fuel capacity
     * @return max fuel
     */
    public int getMAX_FUEL() {
        return MAX_FUEL;
    }

    /**
     * get current fuel levels
     * @return fuel level
     */
    public int getCurrFuel() {
        return fuelLevel;
    }

    /**
     * get remaining cargo space
     * @return remaining cargo
     */
    public int getRemainingCargo() {
        return remainingCargo;
    }

    /**
     * Getter for list of cargo items
     * @return list of cargo items
     */
    public Map<MarketInfo,Integer> getCargo() {
        return cargo;
    }

    /**
     * check how much of the cargo space is used
     * @return used cargo space
     */
    private int usedCargoSpace() {
        Collection<Integer> allValues = cargo.values();
        int count = 0;
        for (int i: allValues) {
            count = count + i;
        }

        return count;
    }

    /**
     * add item to the cargo space
     * @param item item to add
     * @param quantityAdded how many to add
     * @return successful add
     */
    public boolean addItem(MarketInfo item, Integer quantityAdded) {
        if (usedCargoSpace() < MAX_CARGO) {
            int originalQuantity = 0;

            //if the product is already in your cargo, save the previous amount
            if (cargo.containsKey(item)) {
                originalQuantity = cargo.get(item);
            }
            //put the previous amount of the product + the additional amount in map
            cargo.put(item, originalQuantity + quantityAdded);
            remainingCargo -= quantityAdded;
            return true;
        }
        return false;
    }

    /**
     * refuel ship
     * @param quantity how much fuel to add
     */
    public void refuel(int quantity) {
        fuelLevel += quantity;
    }

    /**
     * update the fuel based on travel distancce
     * @param first first coordinates
     * @param second second coordinates
     */
    public void updateFuel(Coord first, Coord second) {
        int fuelDecrement = first.calculateDistance(second);
        fuelLevel -= fuelDecrement;
    }

    /**
     * Updates prices of cargo on the ship
     * @param e New planet's events
     * @param tl New planet's tech level
     * @param r New planet's resources
     */
    public void updateCargoPrices(Event e, TechLevel tl, Resources r) {
        cargo.forEach( (k, v) -> {
            int val = cargo.remove(k);
            k.calculatePrice(e, tl, r);
            cargo.put(k, val);
        });
    }

    /**
     * check if travel is possible based on coordinates
     * @param curr current coordinates
     * @param next coordinates for where you want to go
     * @return if you have enough fuel to travel
     */
    public boolean canTravel(Coord curr, Coord next) {
        return fuelLevel >= curr.calculateDistance(next);
    }

    /**
     * remove from cargo when selling
     * @param item item to remove
     * @param quantityRemoved how much to remove
     * @return successful removal
     */
    public boolean removeItem(MarketInfo item, Integer quantityRemoved) {
        //if item is in your cargo and you are removing an acceptable amount
        if (cargo.containsKey(item) && (quantityRemoved <= cargo.get(item))) {
            //get original amount of that item
            int originalQuantity = cargo.get(item);
            //put the original amount minus the removed amount
            cargo.put(item, originalQuantity - quantityRemoved);
            remainingCargo += quantityRemoved;
            if(cargo.get(item) == 0) {
                cargo.remove(item);
            }
            return true;
        }
        return false;

    }

    /**
     * Removes any illegal goods from the cargo if present.
     * @return true if there were illegal goods and they were removed. False otherwise.
     */
    public boolean removeIllegalGoods() {
        Set<MarketInfo> keySet = cargo.keySet();
        boolean removedIllegalGood = false;

        for (MarketInfo s: keySet) {
            if (!s.getItem().isLegal){ //if the good is not legal (ie it is narcotics/firearms)
                if (cargo.get(s) > 0) { //and cargo contains some amount > 0 of it
                    int removedQuantity = cargo.get(s);
                    cargo.put(s, 0);
                    remainingCargo += removedQuantity;
                    removedIllegalGood = true;
                }
            }
        }

        return removedIllegalGood;
    }

    /**
     * Empties out cargo and updates remaining cargo space
     */
    public void clearCargo() {
        this.cargo = new HashMap<>();
        remainingCargo = MAX_CARGO;
    }

    /**
     * to string method
     * @return name of ship
     */
    public String toString() {
        return name;
    }

    /**
     * Setter for the fuel level. Used for testing
     * @param fuel The new fuel level
     */
    public void setFuelLevel(int fuel) {
        fuelLevel = fuel;
    }
}
