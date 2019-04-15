package macbookpro.cs2340.spacetrader.model;

public enum TechLevel {
    PRE_AGRICULTURE("Pre-agriculture"),
    AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"),
    RENAISSANCE("Renaissance"),
    EARLY_INDUSTRY("Early Industry"),
    INDUSTRIAL("Industrial"),
    POST_INDUSTRIAL("Post Industrial"),
    HI_TECH("Hi-Tech");
    
    private final String techLevel;

    TechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

    @Override
    public String toString() {
        return techLevel;
    }
}
