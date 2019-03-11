package macbookpro.cs2340.spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private Map<MarketInfo, Integer> goods = new HashMap<>();

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
            goods.put(key, goods.containsKey(key) ? calculateQuantity(techLevel, key.getItem()) : 1);
        }
    }

    private int calculateQuantity(TechLevel techLevel, MarketItem item) {
        Random rand = new Random();
        int quantity = rand.nextInt(20);
        if (item.getTtp() == techLevel.ordinal()) {
            quantity += rand.nextInt(20);
        }
        return quantity;
    }

    public boolean buyAsPlayer(MarketInfo item) {
        if (goods.containsKey(item)) {
            goods.put(item, goods.get(item) - 1);
            return true;
        }
        return false;
    }

    public boolean sellAsPlayer(MarketInfo item) {
        goods.put(item, goods.containsKey(item) ? goods.get(item) + 1 : 1);
        return true;
    }

    public Map<MarketInfo, Integer> getMarketGoods() {
        return goods;
    }

    public List<MarketInfo> setMarketList() {
        List<MarketInfo> marketList = new ArrayList<>();

        for (Map.Entry<MarketInfo, Integer> entry : goods.entrySet()) {
            MarketInfo m = entry.getKey();
            int quantity = entry.getValue();
            for (int i = 0; i < quantity; i++) {
                marketList.add(m);
            }
        }

        return marketList;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public Resources getResources() {
        return resources;
    }



}
