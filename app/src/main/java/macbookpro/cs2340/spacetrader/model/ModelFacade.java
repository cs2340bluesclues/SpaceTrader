package macbookpro.cs2340.spacetrader.model;

import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;

public class ModelFacade {
    private static ModelFacade instance;
    private static Game newGame;
    private static Player newPlayer;

    public static ModelFacade getInstance() {
        if(instance == null){
            instance = new ModelFacade();
        }
        return instance;
    }

    public static void createGame(GameDifficulty difficulty) {
        newGame = new Game(difficulty);
    }

    public static String createPlayer(String name, int pilot, int fighter, int trader, int engineer) {
        SolarSystem beginnerSolarSystem = newGame.getUniverse().retrieveBeginnerSolarSystem();
        newPlayer = new Player(name, pilot, fighter, trader, engineer, beginnerSolarSystem);
        return newPlayer.toString();
    }

    public static Game getNewGame() {
        return newGame;
    }

    public static boolean travel(SolarSystem system, Planet planet) {
        newGame.travel();
        return newPlayer.travel(system, planet);
    }

    public static Player getNewPlayer() {
        return newPlayer;
    }

    public static SolarSystem getCurrentSolarSystem() { return newPlayer.getCurrentSolarSystem(); }

    public static Planet getCurrentPlanet( ){ return newPlayer.getCurrentPlanet(); }

    public static Market getCurrentMarket() {return newPlayer.getMarket(); }

    public static Ship getCurrentShip() {return newPlayer.getShip();}

    public static int getCurrentCredits() {return newPlayer.getCredits();}


}
