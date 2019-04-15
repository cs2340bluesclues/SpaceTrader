package macbookpro.cs2340.spacetrader.model;

public enum Event {
    NONE("None"),
    DROUGHT("Drought"),
    COLD("Cold"),
    CROP_FAIL("Crop Fail"),
    WAR("War"),
    BOREDOM("Boredom"),
    PLAGUE("Plague"),
    LACK_OF_WORKERS("Lack of workers");

    private String event;

    Event(String s) {
        event = s;
    }

    @Override
    public String toString() {
        return event;
    }
}
