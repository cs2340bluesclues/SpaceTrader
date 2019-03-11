package macbookpro.cs2340.spacetrader.model.Universe;
import android.util.Log;

import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.Resources;
import macbookpro.cs2340.spacetrader.model.TechLevel;

public class Planet {

    private String name;
    private Resources resources;
    private TechLevel techLevel;
    private Event event;
    private Market market;

    /**
     * Planet constructor. Assigns name from parameter, and randomly sets the planet resource,
     * increase event, and tech level using the Resources, Event, & TechLevel enums
     * @param name
     */
    public Planet(String name) {
        this.name = name;
        int resourceOrdinal = randomGen(12);
        int techOrdinal = randomGen(7);
        int ieOrdinal = randomGen(7);

        resources = Resources.values()[resourceOrdinal];
        techLevel = TechLevel.values()[techOrdinal];
        event = Event.values()[ieOrdinal];

        market = new Market(techLevel, resources, event);
    }

   // public void generateMarket() {
       // market.generateMarket(eventOccur());
   // }

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
     * Getter for Event
     * @return Event currently happening on the planet
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Method to reassign a random IncreaseEvent to the planet using the Event enum
     */
    public Event eventOccur() {
        int ieOrdinal = randomGen(7);
        return Event.values()[ieOrdinal];
    }

    /**
     * Method used to print each planet with its attributes to LOGCAT
     */
    public void printPlanet() {
        Log.i("Universe", "A Planet made: \n" + getName() + ".\n Tech Level: "
                + getTechLevel() + ".\n Resources: " + getResources());
    }
}
