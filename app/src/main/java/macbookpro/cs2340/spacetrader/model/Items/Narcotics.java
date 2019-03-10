package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Narcotics extends MarketItem {

    public Narcotics () {
        super(5, 0, 5, 3500, -125, 150,
                IncreaseEvents.BOREDOM, Resources.WEIRD_MUSHROOMS, null);

    }

}
