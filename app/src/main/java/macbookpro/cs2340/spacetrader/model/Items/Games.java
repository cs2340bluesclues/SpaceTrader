package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Games extends MarketItem {

    public Games () {
        super(3,1,6,250,-10,5,
                IncreaseEvents.BOREDOM, Resources.ARTISTIC, null);
    }

}
