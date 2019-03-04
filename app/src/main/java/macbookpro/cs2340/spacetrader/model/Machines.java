package macbookpro.cs2340.spacetrader.model;

public class Machines extends MarketItem {

    public Machines () {
        //Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
        mtlp = 4;
        //Minimum Tech Level to Use this resource (You can't sell on planets below this level)
        mtlu = 3;
        //Tech Level which produces the most of this item
        ttp = 5;

        basePrice = 900;

        //Price increase per tech level
        ipl = -30;
        //Variance is the maximum percentage that the price can vary above or below the base
        var = 5;

        //Radical price increase event, when this even happens on a planet,
        // the price may increase astronomically
        ie = IncreaseEvents.LACK_OF_WORKERS;

    }

}
