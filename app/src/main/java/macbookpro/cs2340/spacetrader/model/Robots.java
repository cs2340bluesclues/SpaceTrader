package macbookpro.cs2340.spacetrader.model;

public class Robots implements MarketItem {
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int basePrice;
    private int ipl;
    private int var;

    private IncreaseEvents ie;

    public Robots () {
        //Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
        mtlp = 6;
        //Minimum Tech Level to Use this resource (You can't sell on planets below this level)
        mtlu = 4;
        //Tech Level which produces the most of this item
        ttp = 7;

        basePrice = 5000;

        //Price increase per tech level
        ipl = -150;
        //Variance is the maximum percentage that the price can vary above or below the base
        var = 100;

        //Radical price increase event, when this even happens on a planet,
        // the price may increase astronomically
        ie = IncreaseEvents.LACK_OF_WORKERS;

    }

    public int getMtlp() {
        return mtlp;
    }

    public int getMtlu() {
        return mtlu;
    }

    public int getTtp() {
        return ttp;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getIpl() {
        return ipl;
    }

    public int getVar() {
        return var;
    }

    public IncreaseEvents getIe() {
        return ie;
    }
}
