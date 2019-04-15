package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;

/**
 * MarketItem for Robots
 */
public class Robots extends MarketItem {

    /**
     * Constructor for robots class
     */
    public Robots () {
        super("Robots",6, 4,7,5000,-150,100,
                Event.LACK_OF_WORKERS, null, null, true);
    }
}
