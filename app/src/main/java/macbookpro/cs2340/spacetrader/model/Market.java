package macbookpro.cs2340.spacetrader.model;

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
        event = ie;
        generateMarket(event);
    }

    public void generateMarket(Event ie) {
        event = ie;
        Random r = new Random(10);
        for (int index = 0; index < items.length; index++) {
            MarketInfo key = new MarketInfo(items[index], event, techLevel, resources);
            int quantity = calculateQuantity(techLevel, key.getItem());
            if (quantity > 0) {
                map.put(key, quantity);
            }
        }
    }

    private int calculateQuantity(TechLevel techLevel, MarketItem item) {
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

    public boolean buyAsPlayer(MarketInfo item, int quantityPurchased) {
        if (map.containsKey(item)) {
            map.remove(item);
            map.put(item, map.get(item) - quantityPurchased);

            return true;
        }
        return false;
    }

    public boolean sellAsPlayer(MarketInfo item) {
        map.remove(item);
        map.put(item, map.containsKey(item) ? map.get(item) + 1 : 1);
        return true;
    }

    public Map<MarketInfo, Integer> getMarketGoods() {
        return map;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public Resources getResources() {
        return resources;
    }



}
