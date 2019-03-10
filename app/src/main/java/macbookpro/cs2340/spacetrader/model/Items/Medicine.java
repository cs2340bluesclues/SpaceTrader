package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Medicine extends MarketItem {

    public Medicine () {

        super(4, 1,6,650, -20, 10,
                IncreaseEvents.PLAGUE, Resources.LOTS_OF_HERBS, null);

    }

}
