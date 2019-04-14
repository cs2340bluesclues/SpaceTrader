package macbookpro.cs2340.spacetrader.model;

public enum Resources {
    NO_SPECIAL_RESOURCES("No special resources"),
    MINERAL_RICH("Mineral rich"),
    MINERAL_POOR("Mineral poor"),
    DESERT("Desert"),
    LOTS_OF_WATER("Lots of water"),
    RICH_SOIL("Rich soil"),
    POOR_SOIL("Poor soil"),
    RICHFAUNA("Rich fauna"),
    LIFELESS("Lifeless"),
    WEIRD_MUSHROOMS("Weird mushrooms"),
    LOTS_OF_HERBS("Lots of herbs"),
    ARTISTIC("Artistic"),
    WARLIKE("Warlike");

    private final String resourceLevel;

    Resources(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    @Override
    public String toString(){
        return resourceLevel;
    }
}
