package macbookpro.cs2340.spacetrader.model;

public enum TechLevel {
    PRE_AGRICULTURE("pre agriculture"),
    AGRICULTURE("agriculture"),
    MEDIEVAL("medieval"),
    RENAISSANCE("renaissance"),
    EARLY_INDUSTRY("early industry"),
    INDUSTRIAL("industrial"),
    POST_INDUSTRIAL("post industrial"),
    HI_TECH("hi tech");
    
    private String techLevel;

    TechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

    public void setTechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

    public String getTechLevel() {
        return techLevel;
    }
}
