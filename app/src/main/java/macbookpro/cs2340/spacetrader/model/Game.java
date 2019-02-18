package macbookpro.cs2340.spacetrader.model;

public class Game {
    private GameDifficulty diff;

    public Game(GameDifficulty diff) {
        this.diff = diff;
    }

    public void setDiff(GameDifficulty diff) {
        this.diff = diff;
    }

    public GameDifficulty getDiff() {
        return diff;
    }
}
