package macbookpro.cs2340.spacetrader.model;

import java.util.ArrayList;
import java.util.List;

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

    private List<MarketInfo> marketInfos = new ArrayList<>();

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
        for (int i = 0; i < items.length; i++) {
            marketInfos.add(new MarketInfo(items[i], ie, techLevel, resources));
        }
    }

    public List<MarketInfo> getMarketInfos() {
        return marketInfos;
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
