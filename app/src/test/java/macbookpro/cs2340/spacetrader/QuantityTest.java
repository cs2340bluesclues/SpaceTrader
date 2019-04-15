package macbookpro.cs2340.spacetrader;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;
import macbookpro.cs2340.spacetrader.model.TechLevel;

public class QuantityTest {

    Random r;
    Market m1;
    int m1TL;
    MarketItem item1;
    MarketItem item2;
    MarketItem item3;

    @Before
    public void setUp() {
         r = new Random();
         m1 = new Market(TechLevel.values()[r.nextInt(8)], Resources.DESERT, Event.BOREDOM);
         m1TL = m1.getTechLevel().ordinal();
         item1 = m1.getItems()[r.nextInt(10)];
         item2 = m1.getItems()[r.nextInt(10)];
         item3 = m1.getItems()[r.nextInt(10)];
    }

    @Test
    public void quantityTest() {
        assertEquals("item1 min tech level (" + item1.getMtlp() + ") is less than m1 tech level " + m1TL,
                item1.getMtlp() <= m1TL, m1.calculateQuantity(item1) > 0);
        assertEquals("item1 tech level (" + item1.getTtp() + ") is equal to m1 tech level " + m1TL,
                item1.getTtp() == m1TL, m1.calculateQuantity(item1) > 15);

        assertEquals("item2 min tech level (" + item2.getMtlp() + ") is less than m1 tech level " + m1TL,
                item2.getMtlp() <= m1.getTechLevel().ordinal(),
                m1.calculateQuantity(item2) > 0);
        assertEquals("item2 tech level (" + item2.getTtp() + ") is equal to m1 tech level " + m1TL,
                item2.getTtp() == m1TL, m1.calculateQuantity(item2) > 15);

        assertEquals("item3 min tech level (" + item3.getMtlp() + ") is greater than m1 tech level " + m1TL,
                item3.getMtlp() > m1.getTechLevel().ordinal(),
                m1.calculateQuantity(item3) == 0);
    }
}
