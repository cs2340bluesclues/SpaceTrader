package macbookpro.cs2340.spacetrader.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

public class MarketInfo implements Comparable<MarketInfo>, Serializable {

    private final MarketItem item;
    private final int price;
    private final boolean buyable;
    private final boolean sellable;

    /**
     * constructor
     * @param item item
     * @param ie event on planet
     * @param techLevel tech level of planet
     * @param resources planet resources
     */
    public MarketInfo(MarketItem item, Event ie, TechLevel techLevel, Resources resources) {
        this.item = item;
        buyable = techLevel.ordinal() >= item.getMtlp();
        sellable = techLevel.ordinal() >= item.getMtlu();
        price = calculatePrice(ie,  techLevel, resources);
    }

    /**
     * compare market info
     * @param o market info to compare
     * @return if they are the same
     */
    @Override
    public int compareTo(MarketInfo o) {
        MarketItem item = this.getItem();
        return item.compareTo(o.getItem());
    }

    /**
     * calculate price of item based on planet information
     * @param ie planet events
     * @param techlevel planet tech level
     * @param resources planet resources
     * @return price of the item
     */
    public int calculatePrice(Event ie, TechLevel techlevel, Resources resources) {
        int price = item.getBasePrice();
        int IPLIncrease = techlevel.ordinal() * item.getIpl();
        int variability = item.getVar();
        boolean radicalPriceIncrease;
        boolean cheapResource;
        boolean expensiveResource;
        if (item.getIe() == null) {
            radicalPriceIncrease =  false;
        } else {
            radicalPriceIncrease = ie.ordinal() == item.getIe().ordinal();
        }
        if (item.getCr() == null) {
            cheapResource = false;
        } else {
            cheapResource = item.getCr().ordinal() == resources.ordinal();
        }
        if (item.getEr() == null) {
            expensiveResource =  false;
        } else {
            expensiveResource =  item.getEr().ordinal() == resources.ordinal();
        }

        Random rand = new Random();
        double varianceDifference = price * .01 * rand.nextInt(variability);
        if (rand.nextBoolean()) {
            varianceDifference *= -1;
        }
        price = price + IPLIncrease + (int) varianceDifference;
        if (radicalPriceIncrease) {
            price *= 3;
        }
        if (expensiveResource) {
            price *= 2;
        }
        if (cheapResource) {
            price = price / 2;
        }
        if (price < 1) {
            price = 1;
        }
        return price;
    }

    /**
     * getter for item
     * @return market item
     */
    public MarketItem getItem() {
        return item;
    }

    /**
     * getter for price
     * @return market item price
     */
    public int getPrice() {
        return price;
    }

//    public JSONObject getJsonObject() {
//        JSONObject jo = new JSONObject();
//        jo.put("item", item.getJsonObject());
//        jo.put("price", price);
//        jo.put("buyable", buyable);
//        jo.put("sellable", sellable);
//        return jo;
//    }

    @Override
    public String toString() {
        return "";
//                "\"item\":\"" + item + "\"," + "\"price\":\"" + price + "\"," + "\"buyable\":\""
//                + buyable + "\"," + "\"sellable\":\"" + sellable + "\"";
    }

}
