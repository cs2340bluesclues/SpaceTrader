package macbookpro.cs2340.spacetrader.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Market {

    static MarketItem[] items = {new Water(), new Furs(), new Food(), new Ore(), new Games(),
            new Firearms(), new Medicine(), new Machines(), new Narcotics(), new Robots()};
    List<MarketItem> marketItems = new ArrayList<>();

    private IncreaseEvents ie;
    private TechLevel techLevel;
    private Resources resources;

    public Market(TechLevel planetTechLevel, IncreaseEvents planetIE, Resources planetResources) {
        techLevel = planetTechLevel;
        ie = planetIE;
        resources = planetResources;
    }

    public void generateMarket() {
        Random r = new Random();
        int index = r.nextInt(10);

        for(int i = 0; i < r.nextInt(25); i++) {
            while(items[index].getMtlp() > techLevel.ordinal()) {
                index = r.nextInt(10);
            }
            marketItems.add(items[index]);
        }
    }
}
