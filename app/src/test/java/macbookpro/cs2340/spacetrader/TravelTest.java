package macbookpro.cs2340.spacetrader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;


import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;


import static org.junit.Assert.*;

public class TravelTest {
    private static final int TIMEOUT = 200;
    private Random rand;
    private Player player;
    private SolarSystem currSS;
    private Planet currPlanet;
    private SolarSystem nextSS;
    private Planet nextPlanet;

    @Before
    public void setUp() {
        rand = new Random();
        currSS = new SolarSystem(rand);
        player = new Player("Matt", 4, 4, 4, 4, currSS);
        currPlanet = player.getCurrentPlanet();
        nextSS = new SolarSystem(rand);
        nextPlanet = new Planet("New Planet");
    }

    @Test(timeout = TIMEOUT)
    public void cantTravelX() {
        player.getShip().setFuelLevel(5);
        currSS.setCoords(0, 0);
        nextSS.setCoords(6, 0);
        int preFuel = player.getShip().getCurrFuel();
        assertFalse(player.travel(nextSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(currSS, player.getCurrentSolarSystem());
        assertEquals(currPlanet, player.getCurrentPlanet());
        assertEquals(preFuel , postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void canTravelX() {
        player.getShip().setFuelLevel(5);
        currSS.setCoords(0, 0);
        nextSS.setCoords(4, 0);
        assertTrue(player.travel(nextSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(nextSS, player.getCurrentSolarSystem());
        assertEquals(nextPlanet, player.getCurrentPlanet());
        assertEquals(1, postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void cantTravelY() {
        player.getShip().setFuelLevel(5);
        currSS.setCoords(0, 0);
        nextSS.setCoords(0, 6);
        int preFuel = player.getShip().getCurrFuel();
        assertFalse(player.travel(nextSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(currSS, player.getCurrentSolarSystem());
        assertEquals(currPlanet, player.getCurrentPlanet());
        assertEquals(preFuel ,postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void canTravelY() {
        player.getShip().setFuelLevel(5);
        currSS.setCoords(0, 0);
        nextSS.setCoords(0, 4);
        assertTrue(player.travel(nextSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(nextSS, player.getCurrentSolarSystem());
        assertEquals(nextPlanet, player.getCurrentPlanet());
        assertEquals(1, postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void cantTravelDiagonal() {
        player.getShip().setFuelLevel(5);
        currSS.setCoords(0, 0);
        nextSS.setCoords(10, 10);
        int preFuel = player.getShip().getCurrFuel();
        assertFalse(player.travel(nextSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(currSS, player.getCurrentSolarSystem());
        assertEquals(currPlanet, player.getCurrentPlanet());
        assertEquals(preFuel , postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void canTravelDiagonal() {
        player.getShip().setFuelLevel(5);
        currSS.setCoords(0, 0);
        nextSS.setCoords(3, 4);
        assertTrue(player.travel(nextSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(nextSS, player.getCurrentSolarSystem());
        assertEquals(nextPlanet, player.getCurrentPlanet());
        assertEquals(0, postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void travelAtFuelCapacity() {
        player.getShip().setFuelLevel(10);
        currSS.setCoords(10, 0);
        nextSS.setCoords(10, 10);
        assertTrue(player.travel(nextSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(nextSS, player.getCurrentSolarSystem());
        assertEquals(nextPlanet, player.getCurrentPlanet());
        assertEquals(0, postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void travelWithinSS() {
        player.getShip().setFuelLevel(1);
        assertTrue(player.travel(currSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(currSS, player.getCurrentSolarSystem());
        assertEquals(nextPlanet, player.getCurrentPlanet());
        assertEquals(1, postFuel);
    }

    @Test(timeout = TIMEOUT)
    public void travelDiagonalDecimals() {
        player.getShip().setFuelLevel(10);
        currSS.setCoords(0, 0);
        nextSS.setCoords(7, 4);
        assertTrue(player.travel(currSS, nextPlanet));
        int postFuel = player.getShip().getCurrFuel();
        assertEquals(currSS, player.getCurrentSolarSystem());
        assertEquals(nextPlanet, player.getCurrentPlanet());
        assertEquals(2, postFuel);
    }
}
