package macbookpro.cs2340.spacetrader.model;

import java.util.Random;

public class MarketInfo {

    private MarketItem item;
    private int price;
    private int quantity;
    private boolean buyable;
    private boolean sellable;

    public MarketInfo(MarketItem item, IncreaseEvents ie, TechLevel techLevel, Resources resources) {
        this.item = item;
        buyable = techLevel.ordinal() >= item.getMtlp();
        sellable = techLevel.ordinal() >= item.getMtlu();
        price =  calculatePrice(ie,  techLevel, resources);
        quantity = calculateQuantity(ie,  techLevel, resources);
    }

    private int calculatePrice(IncreaseEvents ie,  TechLevel techlevel, Resources resources) {
        int price = item.getBasePrice();
        int IPLIncrease = techlevel.ordinal() * item.getIpl();
        int variability = item.getVar();
        boolean radicalPriceIncrease = ie.ordinal() == item.getIe().ordinal();
        boolean cheapResource = item.getCr().ordinal() == resources.ordinal();
        boolean expensiveResource =  item.getEr().ordinal() == resources.ordinal();

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
        return price;
    }

    private int calculateQuantity(IncreaseEvents ie,  TechLevel techlevel, Resources resources) {
        return 0;
    }
}
