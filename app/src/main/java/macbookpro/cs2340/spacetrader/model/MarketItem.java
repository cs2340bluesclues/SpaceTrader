package macbookpro.cs2340.spacetrader.model;

public abstract class MarketItem {

    protected int mtlp;
    protected int mtlu;
    protected int ttp;
    protected int basePrice;
    protected int ipl;
    protected int var;

    protected IncreaseEvents ie;
    protected Resources cr;
    protected Resources er;

    public MarketItem(int mtlp, int mtlu, int ttp, int basePrice, int ipl, int var,
                      IncreaseEvents ie, Resources cr, Resources er) {
        //Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
        this.mtlp = mtlp;
        //Minimum Tech Level to Use this resource (You can't sell on planets below this level)
        this.mtlu = mtlu;
        //Tech Level which produces the most of this item
        this.ttp = ttp;

        this.basePrice = basePrice;

        //Price increase per tech level
        this.ipl = ipl;
        //Variance is the maximum percentage that the price can vary above or below the base
        this.var = var;

        //Radical price increase event, when this even happens on a planet,
        // the price may increase astronomically
        this.ie = ie;

        //When this condition is present, the price of this resource is unusually low
        this.cr = cr;

        // When this condition is present, the resource is expensive
        this.er = er;
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
