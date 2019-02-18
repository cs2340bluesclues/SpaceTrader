package macbookpro.cs2340.spacetrader.model;

public class ModelFacade {
    private static ModelFacade instance;

    private ModelFacade() {

    }


    public static ModelFacade getInstance() {
        if(instance == null){
            instance = new ModelFacade();
        }
        return instance;
    }

    public static void createGame(GameDifficulty difficulty) {
        Game newGame = new Game(difficulty);
    }

    public static void createPlayer(String name, int pilot, int fighter, int trader, int engineer) {
        Player player = new Player(name, pilot, fighter, trader, engineer);
    }
}
