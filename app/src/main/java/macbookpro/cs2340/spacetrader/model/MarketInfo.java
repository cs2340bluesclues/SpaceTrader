package macbookpro.cs2340.spacetrader.model;

public class MarketInfo {

    private MarketItem item;
    private int price;
    private int quantity;

    public MarketInfo(MarketItem item, IncreaseEvents ie, TechLevel techLevel, Resources resources) {
        this.item = item;
        price =  calculatePrice(ie,  techLevel, resources);
        quantity = calculateQuantity(ie,  techLevel, resources);
    }

    private int calculatePrice(IncreaseEvents ie,  TechLevel techlevel, Resources resources) {
        return 0;
    }

    private int calculateQuantity(IncreaseEvents ie,  TechLevel techlevel, Resources resources) {
        return 0;
    }
}
