package macbookpro.cs2340.spacetrader.model.Universe;
import android.util.Log;

import java.util.Random;

import macbookpro.cs2340.spacetrader.model.Event;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.Resources;
import macbookpro.cs2340.spacetrader.model.TechLevel;

/**
 * Class for the planets within the universe
 */
public class Planet {

    private final String name;
    private final Resources resources;
    private final TechLevel techLevel;
    private Event event;
    private final Market market;
    private int fuelCost;

    /**
     * Planet constructor. Assigns name from parameter, and randomly sets the planet resource,
     * increase event, and tech level using ordinals in the Resources, Event, & TechLevel enums
     * @param name The name of the planet
     */
    public Planet(String name) {
        this.name = name;
        resources = Resources.values()[randomGen(12)];
        techLevel = TechLevel.values()[randomGen(7)];
        event = Event.values()[randomGen(7)];

        market = new Market(techLevel, resources, event);
        calculateFuelCost();
    }

    /**
     * Calculates how much a gallon of fuel will cost on the planet
     */
    private void calculateFuelCost() {
        fuelCost = randomGen(7) + 5;
        if (techLevel.ordinal() > 3) {
            fuelCost -= techLevel.ordinal() / 3;
        }
    }

    /**
     * Method to reassign a random IncreaseEvent to the planet using a random ordinal in
     * the Event enum
     */
    private void eventOccur() {
        event = Event.values()[randomGen(7)];
        //market.generateMarket(event);
    }

    /**
     * Regenerates the planet's markets and events
     */
    public void regeneratePlanet() {
        calculateFuelCost();
        eventOccur();
        market.generateMarket(event);
    }

    /**
     * Random generator used to return a random number to assign resource and tech level
     * @param max The largest random number to be produced
     * @return a random integer
     */
    private int randomGen(int max) {
        Random generator = new Random();
        return generator.nextInt(max + 1);
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
     * Getter for fuelCost
     * @return Cost of fuel on the planet
     */
    public int getFuelCost() {
        return fuelCost;
    }

    /**
     * Getter for Event
     * @return Event currently happening on the planet
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Method used to print each planet with its attributes to LOGCAT
     */
    public void printPlanet() {
        Log.i("Universe", "A Planet made: \n" + getName() + ".\n Tech Level: "
                + getTechLevel() + ".\n Resources: " + getResources());
    }

    @Override
    public String toString() {
        return name;
    }
}
