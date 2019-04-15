package macbookpro.cs2340.spacetrader;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.Items.Games;
import macbookpro.cs2340.spacetrader.model.Items.Water;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Resources;
import macbookpro.cs2340.spacetrader.model.Ship;
import macbookpro.cs2340.spacetrader.model.TechLevel;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;
//import macbookpro.cs2340.spacetrader.model.Universe.Universe;

import static org.junit.Assert.*;

public class SellTest {
    private static final int TIMEOUT = 200;
    private Player player;
    private Ship ship;
    private SolarSystem ss;
    private Planet currPlanet;
    private Market currMarket;
    private Random rand;
    private MarketInfo waterInfo;
    private MarketInfo gamesInfo;
    private MarketInfo notAvailable;

    @Before
    public void setUp() {
        rand = new Random();
        ss = new SolarSystem(rand);
        player = new Player("name", 4, 4, 4, 4, ss);
        ship = player.getShip();
        currPlanet = player.getCurrentPlanet();
        currMarket = currPlanet.getMarket();
        Water water = new Water();
        waterInfo = new MarketInfo(water, Event.COLD, TechLevel.AGRICULTURE, Resources.ARTISTIC);
        Games games = new Games();
        gamesInfo = new MarketInfo(games, Event.COLD, TechLevel.AGRICULTURE, Resources.ARTISTIC);
        ship.addItem(waterInfo, 5);
        notAvailable = null;
    }

    @Test(timeout = TIMEOUT)
    public void notInCargo() {
        Map<MarketInfo, Integer> cargo = ship.getCargo();
        int credits = player.getCredits();
        int remainingCargo = ship.getRemainingCargo();
        //checks if it buys when doesn't exist in cargo
        assertFalse(player.sell(gamesInfo, 3));
        //checks if cargo is still the same
        assertEquals(remainingCargo, ship.getRemainingCargo());
        assertEquals(credits, player.getCredits());
    }

    @Test(timeout = TIMEOUT)
    public void inCargo() {
        Map<MarketInfo, Integer> cargo = ship.getCargo();
        int credits = player.getCredits();
        int price = waterInfo.getPrice();
        int remainingCargo = ship.getRemainingCargo();
        //checks if player can sell item in cargo and sells an item
        player.sell(waterInfo, 1);
        assertEquals(12, ship.getRemainingCargo());
        //checks if credits match after selling
        assertEquals(credits + price, player.getCredits());
    }
    @Test(timeout = TIMEOUT)
    public void sellUntilGone() {
        //sells all the waters currently in the cargo
        player.sell(waterInfo, 5);
        //checks if remaining cargo equals the ship's starting empty cargo
        assertEquals(15, ship.getRemainingCargo());
        //checks if player can sell a nonexistent item
        assertFalse(player.sell(waterInfo, 1));
    }
}
