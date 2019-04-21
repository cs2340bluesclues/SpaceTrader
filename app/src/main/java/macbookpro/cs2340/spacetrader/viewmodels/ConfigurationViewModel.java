package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

//import com.google.firebase.database.DatabaseReference;

import macbookpro.cs2340.spacetrader.model.GameDifficulty;
//import macbookpro.cs2340.spacetrader.model.ModelFacade;
//import macbookpro.cs2340.spacetrader.model.Player;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

/**
 * ViewModel for configuration screen, carrying the necessary data
 */
public class ConfigurationViewModel extends AndroidViewModel {

    private int totalCount;
    private int pilotCount;
    private int fighterCount;
    private int traderCount;
    private int engineerCount;

    /** Constructor for the configuration viewmodel
     * @param application The application
     */
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        pilotCount = 0;
        fighterCount = 0;
        traderCount = 0;
        engineerCount = 0;
        totalCount = pilotCount + fighterCount + traderCount + engineerCount;
    }

    /**
     * Setter method for pilotCount
     * @param count The data for the instance variable to be se to
     */
    public void setPilotCount(int count) {
        this.pilotCount = count;
        updateTotalCount();
    }

    /**
     * Setter method for fighterCount
     * @param count The data for the instance variable to be se to
     */
    public void setFighterCount(int count) {
        this.fighterCount = count;
        updateTotalCount();
    }


    /**
     * Setter method for traderCount
     * @param count The data for the instance variable to be se to
     */
    public void setTraderCount(int count) {
        this.traderCount = count;
        updateTotalCount();
    }

    /**
     * Setter method for engineerCount
     * @param count The data for the instance variable to be se to
     */
    public void setEngineerCount(int count) {
        this.engineerCount = count;
        updateTotalCount();
    }

    private void updateTotalCount() {
        totalCount = pilotCount + fighterCount + traderCount + engineerCount;
    }

    /**
     * Getter method for totalCount instance variable
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * Getter method for pilotCount instance variable
     * @return pilotCount
     */
    public int getPilotCount() {
        return pilotCount;
    }

    /**
     * Getter method for fighterCount instance variable
     * @return fighterCount
     */
    public int getFighterCount() {
        return fighterCount;
    }

    /**
     * Getter method for traderCount instance variable
     * @return traderCount
     */
    public int getTraderCount() {
        return traderCount;
    }

    /**
     * Getter method for engineerCount instance variable
     * @return engineerCount
     */
    public int getEngineerCount() {
        return engineerCount;
    }


    /**
     * Checks if the skill count is less than 16
     * @return true if total count < 16 and false otherwise
     */
    public boolean checkCountGreater16() {
        return totalCount < 16;
    }

    /**
     * Check to se if total skill count is not 16
     * @return if total count is not 16
     */
    //if its true, show toast
    public boolean checkCount16() {
        return totalCount != 16;
    }

    /**
     * Checks to see if the name is length zero
     * @param name The name to check
     * @return true if the name is empty and false if not
     */
    //if its true, show toast
    public boolean checkNameLength(String name) {
        return name.isEmpty();
    }
    /**
     * Creates player and game
     * @param name name of the player
     * @param diff selected game difficulty
     * @return String containing all the data
     */
    public void sendData(String name, GameDifficulty diff) { //made void from string
//        createGame(diff);
        createGame(diff, name, pilotCount, fighterCount, traderCount, engineerCount);
    }
}
