package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Firearms extends MarketItem {

    public Firearms () {
        super("Firearms", 3, 1, 5, 1250, -75, 100,
                Event.WAR, Resources.WARLIKE, null, false);

    }

}
