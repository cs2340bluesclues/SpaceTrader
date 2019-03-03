package macbookpro.cs2340.spacetrader.model;

public class Food implements MarketItem {
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int basePrice;
    private int ipl;
    private int var;

    private IncreaseEvents ie;
    private Resources cr;
    private Resources er;

    public Food () {
        //Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
        mtlp = 1;
        //Minimum Tech Level to Use this resource (You can't sell on planets below this level)
        mtlu = 0;
        //Tech Level which produces the most of this item
        ttp = 1;

        basePrice = 100;

        //Price increase per tech level
        ipl = 5;
        //Variance is the maximum percentage that the price can vary above or below the base
        var = 5;

        //Radical price increase event, when this even happens on a planet,
        // the price may increase astronomically
        ie = IncreaseEvents.CROP_FAIL;

        //When this condition is present, the price of this resource is unusually low
        cr = Resources.RICH_SOIL;

        // When this condition is present, the resource is expensive
        er = Resources.POOR_SOIL;

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

    public Resources getCr() {
        return cr;
    }

    public Resources getEr() {
        return er;
    }
}