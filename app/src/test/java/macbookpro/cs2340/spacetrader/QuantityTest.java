package macbookpro.cs2340.spacetrader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.Items.Firearms;
import macbookpro.cs2340.spacetrader.model.Items.Food;
import macbookpro.cs2340.spacetrader.model.Items.Furs;
import macbookpro.cs2340.spacetrader.model.Items.Games;
import macbookpro.cs2340.spacetrader.model.Items.Machines;
import macbookpro.cs2340.spacetrader.model.Items.Medicine;
import macbookpro.cs2340.spacetrader.model.Items.Narcotics;
import macbookpro.cs2340.spacetrader.model.Items.Ore;
import macbookpro.cs2340.spacetrader.model.Items.Robots;
import macbookpro.cs2340.spacetrader.model.Items.Water;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;
import macbookpro.cs2340.spacetrader.model.TechLevel;

public class MarketTest {

    Random r;
    Market m1;
    MarketItem item1;
    MarketItem item2;
    MarketItem item3;

    @Before
    public void setUp() {
         r = new Random();
         m1 = new Market(TechLevel.values()[r.nextInt(8)], Resources.DESERT, Event.BOREDOM);
         item1 = m1.getItems()[r.nextInt(10)];
         item2 = m1.getItems()[r.nextInt(10)];
         item3 = m1.getItems()[r.nextInt(10)];
    }

    @Test
    public void quantityTest() {
        assertEquals("Item1 min tech level is less than m1 tech level",
                item1.getMtlp() <= m1.getTechLevel().ordinal(),
                m1.calculateQuantity(item1) > 0);
        assertEquals("Item1 min tech level is less than m2 tech level",
                item2.getMtlp() <= m1.getTechLevel().ordinal(), m1.calculateQuantity(item2) > 0);
        assertEquals("Item1 min tech level is less than m3 tech level",
                item3.getMtlp() <= m1.getTechLevel().ordinal(), m1.calculateQuantity(item3) > 0);
    }
}
