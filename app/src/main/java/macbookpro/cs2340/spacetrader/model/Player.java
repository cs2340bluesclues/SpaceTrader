package macbookpro.cs2340.spacetrader.model;

import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;
import java.util.Random;

public class Player {
    private String name;
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
    private Random rand;


    public Player(String name, int pilot, int fighter, int trader, int engineer, SolarSystem solarSystem) {
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
        rand = new Random();
    }

    public void refuelShip(int quantityToRefuel) {
        if (credits > currentPlanet.getFuelCost()) {
            credits -= currentPlanet.getFuelCost() * quantityToRefuel;
            ship.refuel(quantityToRefuel);
        }
    }

    public boolean travel(SolarSystem nextSol, Planet nextPlanet) {
        if (ship.canTravel(nextSol.getCoords(), currentSolarSystem.getCoords())) {
            ship.updateFuel(nextSol.getCoords(), currentSolarSystem.getCoords());
            currentPlanet = nextPlanet;
            currentSolarSystem = nextSol;
            return true;
        }
        return false;
    }

    public boolean buy(MarketInfo item, int quantityToPurchase) {
        //int count = 0;
        boolean bought = false;

        if (credits > item.getPrice() && currentPlanet.getMarket().buyAsPlayer(item, quantityToPurchase)) {
            if (ship.addItem(item, quantityToPurchase)) {
                credits -= (item.getPrice()*quantityToPurchase);
                //count++;
                bought = true;
            }
        }
        return bought;
    }

    public boolean sell(MarketInfo item, int quantity) {
        int count = 0;
        boolean sold = false;
        while (count < quantity && ship.removeItem(item, quantity)) {
            credits += (item.getPrice()*quantity);
            currentPlanet.getMarket().sellAsPlayer(item);
            count++;
            sold = true;
        }
        return sold;
    }

    public boolean policeEvent() {
        if (!lawfulStatus) {
            return rand.nextInt(10) <= 2;
        }
        return rand.nextInt(10) == 0;
    }

    public boolean pirateEvent() {
        return rand.nextInt(10) == 0;
    }

    public int calculateCargoPrice(MarketInfo item) {
        return item.getPrice();
    }

    public String getName() {
        return name;
    }

    public int getTotalSkillPoints() {
        return totalSkillPoints;
    }

    public void setTotalSkillPoints(int totalSkillPoints) {
        this.totalSkillPoints = totalSkillPoints;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getFighter() {
        return fighter;
    }

    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    public int getTrader() {
        return trader;
    }

    public void setTrader(int trader) {
        this.trader = trader;
    }

    public int getEngineer() {
        return engineer;
    }

    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean isLawfulStatus() {
        return lawfulStatus;
    }

    public void setLawfulStatus(boolean lawfulStatus) {
        this.lawfulStatus = lawfulStatus;
    }

    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    public void setCurrentSolarSystem(SolarSystem currentSolarSystem) {
        this.currentSolarSystem = currentSolarSystem;
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    public String toString() {
        return "name: " + this.getName() + "\n pilot: " + this.getPilot() + "\n fighter: "
                + this.getFighter() + "\n trader:" + this.getTrader() + "\n engineer: "
                + this.getEngineer() + "\n total skill points: " + this.getTotalSkillPoints()
                + "\n credits: " + this.getCredits() + "\n ship: " + this.getShip().getName();
    }

    public Market getMarket() { return currentPlanet.getMarket(); }
}
