package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Furs extends MarketItem {

    public Furs () {

        super(0, 0, 0, 250, 10, 10,
                IncreaseEvents.COLD, Resources.RICHFAUNA, Resources.LIFELESS);
    }
}
