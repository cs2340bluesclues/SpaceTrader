package macbookpro.cs2340.spacetrader.model;

public enum GameDifficulty {
    BEGINNER("beginner"),
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    IMPOSSIBLE("impossible");

    private String difficultyLevel;

    private GameDifficulty(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }
}
