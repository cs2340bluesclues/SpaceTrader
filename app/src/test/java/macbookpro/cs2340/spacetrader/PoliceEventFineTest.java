package macbookpro.cs2340.spacetrader;

import android.media.Image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Random;


import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.Items.Water;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Resources;
import macbookpro.cs2340.spacetrader.model.Ship;
import macbookpro.cs2340.spacetrader.model.TechLevel;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

import static macbookpro.cs2340.spacetrader.model.Event.NONE;
import static org.junit.Assert.*;


/**
 * Buy method unit test
 * Saachi Wadhwani
 * GT username: swadhwani6
 */

public class BuyTest {
    private static final int TIMEOUT = 200;
    private Player player;
    private Ship ship;
    private SolarSystem ss;
    private Planet currPlanet;
    private Market currMarket;
    private Random rand;
    private MarketInfo waterInfo;
    private MarketInfo notAvailable;
    private int buyQuanitity;

    @Before
    public void setUp() {
        rand = new Random();
        ss = new SolarSystem(rand);
        player = new Player("name", 4, 4, 4, 4, ss);
        ship = player.getShip();
        currPlanet = player.getCurrentPlanet();
        currMarket = currPlanet.getMarket();
        //currMarket = new Market(TechLevel.HI_TECH, Resources.NO_SPECIAL_RESOURCES, Event.NONE);
        Water water = new Water();
        waterInfo = new MarketInfo(water, Event.COLD, TechLevel.AGRICULTURE, Resources.ARTISTIC);
        notAvailable = null;
    }

//    @Test (timeout = TIMEOUT)
//    public void notEnoughCredits() {
//        Map<MarketInfo, Integer> cargo = ship.getCargo();
//        int remainingCargo = ship.getRemainingCargo();
//        player.setCredits(0);
//        //make sure it didn't actually buy
//        assertFalse(player.buy(waterInfo, 1));
//        //make sure quantity of cargo didn't change
//        assertEquals(remainingCargo, ship.getRemainingCargo());
//        //make sure items in cargo didn't change
//        assertEquals(cargo, ship.getCargo());
//    }
//
//
//    @Test (timeout = TIMEOUT)
//    public void buyItem() {
//        int cost = waterInfo.getPrice();
//        int currCredits = player.getCredits();
//        int quant = 1;
//
//        Map<MarketInfo, Integer> cargo = ship.getCargo();
//        cargo.put(waterInfo, quant);
//        int remainingCargo = ship.getRemainingCargo();
//
//        assertTrue(player.buy(waterInfo, quant));
//        assertEquals(currCredits - cost, player.getCredits());
//        assertEquals(cargo, ship.getCargo());
//        assertEquals(remainingCargo, ship.getRemainingCargo());
//
//    }


    @Test (timeout = TIMEOUT)
    public void policeEventHappens() {
        //player should not have lawful status
        player.setLawfulStatus(false);

        assertEquals(true, player.policeEvent());

    }


    @Test (timeout = TIMEOUT)
    public void noPoliceEventHappens() {
        //player should have lawful status
        player.setLawfulStatus(true);

        assertEquals(false, player.policeEvent());
    }
}
