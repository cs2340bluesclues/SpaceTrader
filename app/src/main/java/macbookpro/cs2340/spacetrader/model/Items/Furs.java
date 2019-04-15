package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

/**
 * The MarketItem Furs
 */
public class Furs extends MarketItem {

    /**
     * The constructor for the furs class
     */
    public Furs () {

        super("Furs",0, 0, 0, 250, 10, 10,
                Event.COLD, Resources.RICHFAUNA, Resources.LIFELESS, true);
    }
}
