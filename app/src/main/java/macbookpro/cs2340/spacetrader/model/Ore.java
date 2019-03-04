package macbookpro.cs2340.spacetrader.model;

public class Ore extends MarketItem {

    public Ore () {

        super(2,2,3,350,20,10,
                IncreaseEvents.WAR, Resources.MINERAL_RICH, Resources.MINERAL_POOR);

    }

}
