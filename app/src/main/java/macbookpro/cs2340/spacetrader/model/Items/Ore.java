package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

/**
 * MarketItem Ore
 */
public class Ore extends MarketItem {
    /**
     * Constructor for ore class
     */
    public Ore () {

        super("Ore",2,2,3,350,20,10,
                Event.WAR, Resources.MINERAL_RICH, Resources.MINERAL_POOR, true);

    }

}
