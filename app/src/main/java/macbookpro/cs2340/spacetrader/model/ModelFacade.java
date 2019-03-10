package macbookpro.cs2340.spacetrader.model;

import java.util.Map;

public class ModelFacade {
    private static ModelFacade instance;
    private static Game newGame;
    private static Player newPlayer;
    private ModelFacade() {

    }

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
        newPlayer = new Player(name, pilot, fighter, trader, engineer);
        return newPlayer.toString();
    }

    public static Map<MarketInfo, Integer> getPlanetMarket() {
        return newPlayer.getMarketInfos();
    }

    public static Game getNewGame() {
        return newGame;
    }

    public static Player getNewPlayer() {
        return newPlayer;
    }


}
