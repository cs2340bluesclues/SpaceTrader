package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

/**
 * The MarketItem Games
 */
public class Games extends MarketItem {

    /**
     * Constructor for the games class
     */
    public Games () {
        super("Games",3,1,6,250,-10,5,
                Event.BOREDOM, Resources.ARTISTIC, null, true);
    }

}
