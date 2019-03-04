package macbookpro.cs2340.spacetrader.model;

public class Water extends MarketItem {

    public Water () {
        super(0,0,2,30,3,4,
                IncreaseEvents.DROUGHT, Resources.LOTS_OF_WATER, Resources.DESERT);

    }

}

