package macbookpro.cs2340.spacetrader.model;

public enum ShipType {

    FLEA("Flea", 5, 20),
    GNAT("Gnat", 15, 14),
    FIREFLY("Firefly", 20, 17),
    MOSQUITO("Mosquito", 15, 13),
    BUMBLEBEE("Bumblebee", 15, 15),
    BEETLE("Beetle", 50, 14),
    HORNET("Hornet", 20, 16),
    GRASSHOPPER("Grasshopper", 30, 15),
    TERMITE("Termite", 70, 13),
    WASP("Wasp", 35, 14);

    private String shipName;
    private int cargoSpace;
    private int speed;

    ShipType (String shipName, int cargoSpace, int speed) {
        this.shipName = shipName;
        this.cargoSpace = cargoSpace;
        this.speed = speed;
    }

    public String getShipName() {
        return shipName;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public int getSpeed() {
        return speed;
    }
}
