package macbookpro.cs2340.spacetrader.model;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String name;
    private List<MarketItem> cargo;

    private final int MAX_CARGO;
    private final int MAX_SPEED;

    public Ship(ShipType shipType) {
        this.name = shipType.getShipName();
        this.cargo = new ArrayList<>();

        this.MAX_CARGO = shipType.getCargoSpace();
        this.MAX_SPEED = shipType.getSpeed();
    }

    public String getName() {
        return name;
    }

    public boolean addItem(MarketItem item) {
        if (cargo.size() < MAX_CARGO) {
            return cargo.add(item);
        }
        return false;
    }

    public boolean removeItem(MarketItem item) {
        return cargo.remove(item);
    }
}
