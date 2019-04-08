package macbookpro.cs2340.spacetrader.model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Items.Firearms;
import macbookpro.cs2340.spacetrader.model.Items.Food;
import macbookpro.cs2340.spacetrader.model.Items.Furs;
import macbookpro.cs2340.spacetrader.model.Items.Games;
import macbookpro.cs2340.spacetrader.model.Items.Machines;
import macbookpro.cs2340.spacetrader.model.Items.Medicine;
import macbookpro.cs2340.spacetrader.model.Items.Narcotics;
import macbookpro.cs2340.spacetrader.model.Items.Ore;
import macbookpro.cs2340.spacetrader.model.Items.Robots;
import macbookpro.cs2340.spacetrader.model.Items.Water;

public class Market {


    static MarketItem[] items = {new Water(), new Furs(), new Food(), new Ore(), new Games(),
            new Firearms(), new Medicine(), new Machines(), new Narcotics(), new Robots()};

    private Map<MarketInfo, Integer> map = new HashMap<>();

    private Event event;
    private TechLevel techLevel;
    private Resources resources;

    public Market(TechLevel planetTechLevel, Resources planetResources, Event ie) {
        techLevel = planetTechLevel;
        resources = planetResources;
        generateMarket(ie);
    }

    /**
     * makes the new market after a different event happens to the planet
     * @param ie the event that happened to the planet
     */
    public void generateMarket(Event ie) {
        event = ie;
        map.clear();
        for (int index = 0; index < items.length; index++) {
            MarketInfo key = new MarketInfo(items[index], event, techLevel, resources);
            int quantity = calculateQuantity(key.getItem());
            if (quantity > 0) {
                map.put(key, quantity);
            }
        }
    }

    /**
     * calculates market quantity based on tech level
     * @param item item in the market
     * @return number of items in the market
     */
    private int calculateQuantity(MarketItem item) {
        Random rand = new Random();
        if (item.getMtlp() > techLevel.ordinal()) {
            return 0;
        }
        int quantity = rand.nextInt(20);
        if (map.containsKey(item) && map.get(item) < 40) {
            if (item.getTtp() == techLevel.ordinal()) {
                quantity += rand.nextInt(20);
            }
        }
        return quantity;
    }

    /**
     * buy items from market
     * @param item item to buy
     * @param quantityPurchased how much to buy
     * @return successful purchase
     */
    public boolean buyAsPlayer(MarketInfo item, int quantityPurchased) {
        if (map.containsKey(item)) {
            Log.i("wedunnit!", "map " + map + " map get item " + map.get(item));

            int originalQuantity = map.get(item);
            map.put(item, originalQuantity - quantityPurchased);

            return true;
        }
        return false;
    }

    /**
     * sell items to market
     * @param item item to sell
     * @return successful sale
     */
    public boolean sellAsPlayer(MarketInfo item) {
        map.remove(item);
        map.put(item, map.containsKey(item) ? map.get(item) + 1 : 1);
        return true;
    }

    /**
     * get hashmap of market goods
     * @return hashmap
     */
    public Map<MarketInfo, Integer> getMarketGoods() {
        return map;
    }

}
