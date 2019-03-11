package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Medicine extends MarketItem {

    public Medicine () {

        super("Medicine",4, 1,6,650, -20, 10,
                Event.PLAGUE, Resources.LOTS_OF_HERBS, null);

    }

}
