package macbookpro.cs2340.spacetrader.model.Items;
import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.MarketItem;
import macbookpro.cs2340.spacetrader.model.Resources;

public class Food extends MarketItem {

    public Food () {

        super("Food", 1,0,1,100,5,5,
                Event.CROP_FAIL, Resources.RICH_SOIL, Resources.POOR_SOIL);

    }

}
