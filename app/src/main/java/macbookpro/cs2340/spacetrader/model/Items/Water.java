package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Water extends MarketItem {

    public Water () {
        super("Water",0,0,2,30,3,4,
                Event.DROUGHT, Resources.LOTS_OF_WATER, Resources.DESERT);

    }

}

