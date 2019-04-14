package macbookpro.cs2340.spacetrader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.Items.Firearms;
import macbookpro.cs2340.spacetrader.model.Items.Food;
import macbookpro.cs2340.spacetrader.model.Items.Narcotics;
import macbookpro.cs2340.spacetrader.model.Items.Water;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.Resources;
import macbookpro.cs2340.spacetrader.model.Ship;
import macbookpro.cs2340.spacetrader.model.ShipType;
import macbookpro.cs2340.spacetrader.model.TechLevel;

import static org.junit.Assert.*;

/**
 * Ship method unit test, which will execute on the development machine (host).
 * Written by Hamna Khan (GT Username Hkhan60)
 */
public class ShipTest {
    private static final int TIMEOUT = 200;
    private Ship ship;
    private Random rand;
    private MarketInfo narcInfo;
    private MarketInfo fireInfo;
    private MarketInfo waterInfo;
    private MarketInfo foodInfo;

    @Before
    public void setUp() {
        ship = new Ship(ShipType.GNAT);
        rand = new Random();

        Narcotics narcotics = new Narcotics();
        Firearms firearms = new Firearms();
        Water water = new Water();
        Food food = new Food();

        narcInfo = new MarketInfo(narcotics, Event.DROUGHT, TechLevel.HI_TECH,
                Resources.NO_SPECIAL_RESOURCES);
        fireInfo = new MarketInfo(firearms, Event.BOREDOM, TechLevel.POST_INDUSTRIAL,
                Resources.LOTS_OF_HERBS);
        waterInfo = new MarketInfo(water, Event.COLD, TechLevel.AGRICULTURE, Resources.ARTISTIC);
        foodInfo = new MarketInfo(food, Event.WAR, TechLevel.MEDIEVAL, Resources.MINERAL_RICH);
    }


    //Case 1: You do not have illegal goods - empty cargo
    @Test(timeout = TIMEOUT)
    public void noIllegalGoodsEmptyCargo() {
        boolean removedIllegalGoods = ship.removeIllegalGoods();
        //method returned false, meaning nothing was removed
        assertEquals(removedIllegalGoods, false);

    }

    //Case 2: You have non illegal goods in cargo - inhabited cargo
    @Test(timeout = TIMEOUT)
    public void noIllegalGoodsNotEmptyCargo() {

        int randomQuantity = rand.nextInt(ship.getRemainingCargo() - 1) + 1;
        ship.addItem(waterInfo, randomQuantity);

        int remainingQuantity = ship.getRemainingCargo();
        ship.addItem(foodInfo, remainingQuantity);

        boolean removedIllegalGoods = ship.removeIllegalGoods();

        //method returned false, meaning nothing was removed
        assertEquals(removedIllegalGoods, false);

        int quantityOfWater = ship.getCargo().get(waterInfo);
        int quantityOfFood = ship.getCargo().get(foodInfo);

        //make sure initial and final quantities are unchanged
        assertEquals(quantityOfFood, remainingQuantity);
        assertEquals(quantityOfWater, randomQuantity);

    }

    //Case 3: You have only illegal goods - inhabited cargo
    @Test(timeout = TIMEOUT)
    public void bothIllegalGoodsCargo() {

        //add some quantity of both illegal goods
        ship.addItem(narcInfo, 3);
        ship.addItem(fireInfo, 6);

        boolean removedIllegalGoods = ship.removeIllegalGoods();

        //--> method returned true, meaning something was removed
        assertEquals(removedIllegalGoods, true);

        int quantityOfNarc = ship.getCargo().get(narcInfo);
        int quantityOfFire = ship.getCargo().get(fireInfo);
        assertEquals(quantityOfNarc, 0);
        assertEquals(quantityOfFire, 0);

    }

    @Test(timeout = TIMEOUT)
    public void firearmsIllegalGoodsCargo() {

        //if only one kind of illegal good, full cargo
        ship.addItem(narcInfo, 0);
        ship.addItem(fireInfo, ship.getRemainingCargo());

        boolean removedIllegalGoods2 = ship.removeIllegalGoods();

        //--> method returned true, meaning something was removed
        assertEquals(removedIllegalGoods2, true);

        int quantityOfNarc2 = ship.getCargo().get(narcInfo);
        int quantityOfFire2 = ship.getCargo().get(fireInfo);
        assertEquals(quantityOfNarc2, 0);
        assertEquals(quantityOfFire2, 0);


    }

    @Test(timeout = TIMEOUT)
    public void narcoticsIllegalGoodsCargo() {

        //if only other kind of illegal good, full cargo
        ship.addItem(fireInfo, 0);
        ship.addItem(narcInfo, ship.getRemainingCargo());


        boolean removedIllegalGoods3 = ship.removeIllegalGoods();
        //--> method returned true, meaning something was removed
        assertEquals(removedIllegalGoods3, true);

        int quantityOfNarc3 = ship.getCargo().get(narcInfo);
        int quantityOfFire3 = ship.getCargo().get(fireInfo);
        assertEquals(quantityOfNarc3, 0);
        assertEquals(quantityOfFire3, 0);

    }

    //Case 4: You have both illegal and non illegal goods in cargo
    @Test(timeout = TIMEOUT)
    public void bothIllegalNonIllegal() {

        ship.addItem(narcInfo, 2);
        ship.addItem(fireInfo, 3);
        ship.addItem(waterInfo, 2);
        ship.addItem(foodInfo, 4);

        boolean removedIllegalGoods = ship.removeIllegalGoods();

        assertEquals(removedIllegalGoods, true);


        int narcQuantity = ship.getCargo().get(narcInfo);
        int fireQuantity = ship.getCargo().get(fireInfo);
        int waterQuantity = ship.getCargo().get(waterInfo);
        int foodQuantity = ship.getCargo().get(foodInfo);

        assertEquals(narcQuantity, 0);
        assertEquals(fireQuantity, 0);
        assertEquals(waterQuantity, 2);
        assertEquals(foodQuantity, 4);

    }

    @After
    public void clear() {
        ship.clearCargo();
    }
}
