package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;

public class Robots extends MarketItem {

    public Robots () {
        super("Robots",6, 4,7,5000,-150,100,
                Event.LACK_OF_WORKERS, null, null, true);
    }
}
