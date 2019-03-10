package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Water extends MarketItem {

    public Water () {
        super(0,0,2,30,3,4,
                IncreaseEvents.DROUGHT, Resources.LOTS_OF_WATER, Resources.DESERT);

    }

}

