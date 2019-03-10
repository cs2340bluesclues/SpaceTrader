package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;

public class Machines extends MarketItem {

    public Machines () {
        super(4,3,5,900,-30,5,
                IncreaseEvents.LACK_OF_WORKERS, null, null);

    }

}
