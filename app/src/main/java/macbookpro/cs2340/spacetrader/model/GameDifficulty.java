package macbookpro.cs2340.spacetrader.model;

/**
 * Enumeration for Game Difficulties
 */
public enum GameDifficulty {
    BEGINNER("beginner"),
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    IMPOSSIBLE("impossible");

    private String difficultyLevel;

    GameDifficulty(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Getter for the game difficulty
     * @return The game difficulty
     */
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Setter for Game Difficulty
     * @param difficultyLevel The new Game Difficulty
     */
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
