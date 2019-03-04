package macbookpro.cs2340.spacetrader.model;

public class Robots extends MarketItem {

    public Robots () {
        super(6, 4,7,5000,-150,100,
                IncreaseEvents.LACK_OF_WORKERS, null, null);
    }
}
