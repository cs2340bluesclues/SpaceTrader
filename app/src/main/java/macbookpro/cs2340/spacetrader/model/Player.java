package macbookpro.cs2340.spacetrader.model;

public class Player {
    private String name;
    private int totalSkillPoints = 16;
    private int pilot = 1;
    private int fighter = 1;
    private int trader = 1;
    private int engineer = 1;
    private int credits = 1000;
    private GameDifficulty difficulty;
    private Ship ship;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSkillPoints() {
        return totalSkillPoints;
    }

    public void setTotalSkillPoints(int totalSkillPoints) {
        this.totalSkillPoints = totalSkillPoints;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getFighter() {
        return fighter;
    }

    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    public int getTrader() {
        return trader;
    }

    public void setTrader(int trader) {
        this.trader = trader;
    }

    public int getEngineer() {
        return engineer;
    }

    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDifficulty() {
        return difficulty.getDifficultyLevel();
    }

    public void setDifficulty(String difficultyLevel) {
        this.difficulty.setDifficultyLevel(difficultyLevel);
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }


}
