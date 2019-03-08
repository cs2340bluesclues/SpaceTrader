package macbookpro.cs2340.spacetrader.model;
import android.util.Log;

import java.util.List;
import java.util.Random;

public class Planet {

    private String name;
    private Resources resources;
    private TechLevel techLevel;
    private IncreaseEvents ie;
    private Market market;

    /**
     * Planet constructor. Assigns name from parameter, and randomly sets the planet resource,
     * increase event, and tech level using the Resources, IncreaseEvents, & TechLevel enums
     * @param name
     */
    public Planet(String name) {
        this.name = name;
        int resourceOrdinal = randomGen(12);
        int techOrdinal = randomGen(7);
        int ieOrdinal = randomGen(7);

        resources = Resources.values()[resourceOrdinal];
        techLevel = TechLevel.values()[techOrdinal];
        ie = IncreaseEvents.values()[ieOrdinal];

        generateMarket();
    }

    public void generateMarket() {
        market = new Market(techLevel, ie, resources);
    }

    /**
     * Random generator used to return a random number to assign resource and tech level
     * @param max The largest random number to be produced
     * @return a random integer
     */
    private int randomGen(int max) {
        Random generator = new Random();
        int output = generator.nextInt(max);
        return output;
    }

    /**
     * Getter for planet name
     * @return planet market
     */
    public Market getMarket() {
        return market;
    }

    public List<MarketInfo> getMarketInfos() {
        return market.getMarketInfos();
    }

    /**
     * Getter for planet name
     * @return planet name String
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for planet tech level
     * @return TechLevel for the planet
     */
    public TechLevel getTechLevel(){
        return techLevel;
    }

    /**
     * Getter for planet resources
     * @return Resources for the planet
     */
    public Resources getResources(){
        return resources;
    }

    /**
     * Getter for IncreaseEvent
     * @return IncreaseEvent currently happening on the planet
     */
    public IncreaseEvents getIe() {
        return ie;
    }

    /**
     * Method to reassign a random IncreaseEvent to the planet using the IncreaseEvents enum
     */
    public void regenerateIE() {
        int ieOrdinal = randomGen(7);
        ie = IncreaseEvents.values()[ieOrdinal];
    }

    /**
     * Method used to print each planet with its attributes to LOGCAT
     */
    public void printPlanet() {
        Log.i("Universe", "A Planet made: \n" + getName() + ".\n Tech Level: "
                + getTechLevel() + ".\n Resources: " + getResources());
    }
}
