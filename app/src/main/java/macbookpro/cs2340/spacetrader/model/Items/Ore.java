package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Ore extends MarketItem {

    public Ore () {

        super(2,2,3,350,20,10,
                IncreaseEvents.WAR, Resources.MINERAL_RICH, Resources.MINERAL_POOR);

    }

}
