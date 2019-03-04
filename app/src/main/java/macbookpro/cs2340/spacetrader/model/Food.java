package macbookpro.cs2340.spacetrader.model;

public class Food extends MarketItem {

    public Food () {

        super(1,0,1,100,5,5,
                IncreaseEvents.CROP_FAIL, Resources.RICH_SOIL, Resources.POOR_SOIL);

    }

}
