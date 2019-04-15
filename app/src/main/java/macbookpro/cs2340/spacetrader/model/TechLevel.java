package macbookpro.cs2340.spacetrader.model;

/**
 * Enumeration for the Tech Level of a planet
 */
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

    public String toString() {
        return techLevel;
    }
}
