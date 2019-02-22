package macbookpro.cs2340.spacetrader.model;

public enum Resources {
    MINERAL_RICH("mineral rich"),
    MINERAL_POOR("mineral poor"),
    DESERT("desert"),
    LOTS_OF_WATER("lots of water"),
    RICH_SOIL("rich soil"),
    POOR_SOIL("poor soil"),
    RICHFAUNA("rich fauna"),
    LIFELESS("lifeless"),
    WEIRD_MUSHROOMS("weird mushrooms"),
    LOST_OF_HERBS("lots of herbs"),
    ARTISTIC("artistic"),
    WARLIKE("warlike");

    private String resourceLevel;

    Resources(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getResourceLevel() {
        return resourceLevel;
    }
}
