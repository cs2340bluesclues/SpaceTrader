package macbookpro.cs2340.spacetrader.model;

public enum Ship {

    FLEA("flea"),
    GNAT("gnat"),;

    private String shipName;

    Ship (String shipName) {
        this.shipName = shipName;
    }

    public String getShipName() {
        return shipName;
    }
}
