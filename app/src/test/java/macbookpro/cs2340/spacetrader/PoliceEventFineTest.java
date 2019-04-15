package macbookpro.cs2340.spacetrader;

import android.media.Image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

import static org.junit.Assert.*;


/**
 * Buy method unit test
 * Saachi Wadhwani
 * GT username: swadhwani6
 */

public class PoliceEventFineTest {
    private static final int TIMEOUT = 200;
    private Player player;
    private SolarSystem ss;
    private Random rand;

    @Before
    public void setUp() {
        rand = new Random();
        ss = new SolarSystem(rand);
        player = new Player("name", 4, 4, 4, 4, ss);
    }


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


    @Test (timeout = TIMEOUT)
    public void pay5000Fine() {
        //has more than 5000 credits so pay 5000 fine
        player.setCredits(5001);
        int creditsLeft = player.getCredits() - 5000;

        player.payFine();
        assertEquals(creditsLeft, player.getCredits());


    }

    @Test (timeout = TIMEOUT)
    public void payFine() {
        //doesn't have enough credits so looses all credits
        player.setCredits(1000);

        player.payFine();
        assertEquals(0, player.getCredits());

    }


}