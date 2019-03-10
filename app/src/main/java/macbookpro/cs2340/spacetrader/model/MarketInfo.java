package macbookpro.cs2340.spacetrader.model;

import java.util.Random;

public class MarketInfo implements Comparable<MarketInfo> {

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
        quantity = calculateQuantity(techLevel);
    }

    @Override
    public int compareTo(MarketInfo o) {
        return this.getItem().compareTo(o.getItem());
    }

    private int calculatePrice(IncreaseEvents ie,  TechLevel techlevel, Resources resources) {
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
        return price;
    }

    private int calculateQuantity(TechLevel techLevel) {
        Random rand = new Random();
        quantity = rand.nextInt(20);
        if (item.getTtp() == techLevel.ordinal()) {
            quantity += rand.nextInt(20);
        }
        return quantity;
    }

    public MarketItem getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getSellable() {
        return sellable;
    }

    public boolean getBuyable() {
        return buyable;
    }
}
