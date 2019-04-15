package macbookpro.cs2340.spacetrader.model;

import org.json.JSONObject;

import java.io.Serializable;

public abstract class MarketItem implements Comparable<MarketItem>, Serializable {

    private final int mtlp;
    private final int mtlu;
    private final int ttp;
    private final int basePrice;
    private final int ipl;
    private final int var;


    private final Event ie;
    private final Resources cr;
    private final Resources er;

    final boolean isLegal;

    private final String name;


    protected MarketItem(String name, int mtlp, int mtlu, int ttp, int basePrice, int ipl, int var,
                      Event ie, Resources cr, Resources er, boolean isLegal) {
        this.name = name;
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

        //if the trading of this good is legal or not
        this.isLegal = isLegal;
    }

    /**
     * compare market item
     * @param o other market item
     * @return if it is the same
     */
    @Override
    public int compareTo(MarketItem o) {
        if (this.mtlp != o.mtlp) {
            return this.mtlp - o.mtlp;
        } else if (this.mtlu != o.mtlu) {
            return this.mtlu - o.mtlu;
        } else {
            return this.ttp - o.ttp;
        }
    }

    /**
     * getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for mtlp
     * @return mtlp
     */
    public int getMtlp() {
        return mtlp;
    }

    /**
     * getter for mtlu
     * @return mtlu
     */
    public int getMtlu() {
        return mtlu;
    }

    /**
     * getter for ttp
     * @return ttp
     */
    public int getTtp() {
        return ttp;
    }

    /**
     * getter for base price
     * @return base price
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * getter for ipl
     * @return ipl
     */
    public int getIpl() {
        return ipl;
    }

    /**
     * getter for var
     * @return var
     */
    public int getVar() {
        return var;
    }

    /**
     * getter forie
     * @return ie
     */
    public Event getIe() {
        return ie;
    }

    /**
     * getter for cr
     * @return cr
     */
    public Resources getCr() {
        return cr;
    }

    /**
     * getter for er
     * @return er
     */
    public Resources getEr() {
        return er;
    }

//    public JSONObject getJsonObject() {
//
//        JSONObject jo = new JSONObject();
//        jo.put("mtlp", mtlp);
//        jo.put("mtlu", mtlu);
//        jo.put("ttp", ttp);
//        jo.put("basePrice", basePrice);
//    }

    @Override
    public String toString() {
        return "{\"mtlp\":\"" + mtlp + "\"," + "\"mtlu\":\"" + mtlu + "\"," + "\"ttp\":\"" + ttp
                + "\"," + "\"basePrice\":\"" + basePrice + "\"," + "\"ipl\":\"" + ipl + "\","
                + "\"var\":\"" + var + "\"," + "\"ie\":\"" + ie + "\"," + "\"cr\":\"" + cr + "\","
                + "\"er\":\"" + er + "\"," + "\"isLegal\":\"" + isLegal + "\"," + "\"name\":"
                + name + "\"}";
//
//                + mtlu + " " + ttp + " " + basePrice + " " + ipl + " " + var + " "
//                + ie + " " + cr + " " + er + " " + isLegal + " " + name;
    }
}
