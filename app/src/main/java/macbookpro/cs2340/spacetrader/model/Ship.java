package macbookpro.cs2340.spacetrader.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Ship {

    private String name;
    private boolean fueled;
    private Map<MarketInfo, Integer> cargo;

    private final int MAX_CARGO;
    private final int MAX_RANGE;

    private int remainingCargo;

    public Ship(ShipType shipType) {
        this.name = shipType.getShipName();
        this.fueled = false;
        this.cargo = new HashMap<>();

        this.MAX_CARGO = shipType.getCargoSpace();
        this.MAX_RANGE = shipType.getRange();
        remainingCargo = MAX_CARGO;
    }

    public String getName() {
        return name;
    }

    public int getMAX_RANGE() {
        return MAX_RANGE;
    }

    public int getRemainingCargo() {
        return remainingCargo;
    }

    /**
     * Getter for list of cargo items
     * @return
     */
    public Map<MarketInfo,Integer> getCargo() {
        return cargo;
    }

    public int usedCargoSpace() {
        Collection<Integer> allValues = cargo.values();
        int count = 0;
        for (int i: allValues) {
            count = count + i;
        }

        return count;
    }

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

    public void refuel() {
        fueled = true;
    }

    public boolean canTravel() {
        return fueled;
    }

    public boolean removeItem(MarketInfo item, Integer quantityRemoved) {
        //if item is in your cargo and you are removing an acceptable amount
        if (cargo.containsKey(item) && quantityRemoved <= cargo.get(item)) {
            //get original amount of that item
            int originalQuantity = cargo.get(item);
            //put the original amount minus the removed amount
            cargo.put(item, originalQuantity - quantityRemoved);
            remainingCargo += quantityRemoved;
            return true;git
        }
        return false;

    }
}
