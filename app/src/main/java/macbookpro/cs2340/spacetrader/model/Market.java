package macbookpro.cs2340.spacetrader.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    private Map<MarketInfo, Integer> goods = new TreeMap<>();

    private IncreaseEvents ie;
    private TechLevel techLevel;
    private Resources resources;

    public Market(TechLevel planetTechLevel, IncreaseEvents planetIE, Resources planetResources) {
        techLevel = planetTechLevel;
        ie = planetIE;
        resources = planetResources;
        generateMarket();
    }

    private void generateMarket() {
        for (int index = 0; index < items.length; index++) {
            MarketInfo key = new MarketInfo(items[index], ie, techLevel, resources);
            goods.put(key, goods.containsKey(key) ? goods.get(key) + 1 : 1);
        }
    }

    public boolean buy(MarketInfo item) {
        if (goods.containsKey(item)) {
            goods.put(item, goods.get(item) - 1);

        }
        return false;
    }

    public Map<MarketInfo, Integer> getMarketGoods() {
        return goods;
    }

    public IncreaseEvents getIe() {
        return ie;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public Resources getResources() {
        return resources;
    }



}
