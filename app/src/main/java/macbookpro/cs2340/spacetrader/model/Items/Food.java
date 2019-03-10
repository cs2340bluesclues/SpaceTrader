package macbookpro.cs2340.spacetrader.model.Items;

import macbookpro.cs2340.spacetrader.model.IncreaseEvents;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Food extends MarketItem {

    public Food () {

        super(1,0,1,100,5,5,
                IncreaseEvents.CROP_FAIL, Resources.RICH_SOIL, Resources.POOR_SOIL);

    }

}
