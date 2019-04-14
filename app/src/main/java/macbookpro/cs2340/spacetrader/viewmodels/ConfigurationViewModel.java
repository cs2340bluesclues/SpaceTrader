package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;

import macbookpro.cs2340.spacetrader.model.GameDifficulty;
import macbookpro.cs2340.spacetrader.model.ModelFacade;
import macbookpro.cs2340.spacetrader.model.Player;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class ConfigurationViewModel extends AndroidViewModel {

    private int totalCount;
    private int pilotCount;
    private int fighterCount;
    private int traderCount;
    private int engineerCount;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        pilotCount = 0;
        fighterCount = 0;
        traderCount = 0;
        engineerCount = 0;
        totalCount = pilotCount + fighterCount + traderCount + engineerCount;
    }

    public void setPilotCount(int count) {
        this.pilotCount = count;
        updateTotalCount();
    }

    public void setFighterCount(int count) {
        this.fighterCount = count;
        updateTotalCount();
    }

    public void setTraderCount(int count) {
        this.traderCount = count;
        updateTotalCount();
    }

    public void setEngineerCount(int count) {
        this.engineerCount = count;
        updateTotalCount();
    }

    private void updateTotalCount() {
        totalCount = pilotCount + fighterCount + traderCount + engineerCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPilotCount() {
        return pilotCount;
    }

    public int getFighterCount() {
        return fighterCount;
    }

    public int getTraderCount() {
        return traderCount;
    }

    public int getEngineerCount() {
        return engineerCount;
    }

    public boolean checkCountGreater16() {
        return totalCount < 16;
    }

    //if its true, show toast
    public boolean checkCount16() {
        return totalCount != 16;
    }

    //if its true, show toast
    public boolean checkNameLength(String name) {
        return name.isEmpty();
    }

    public String sendData(String name, GameDifficulty diff) {
        createGame(diff);
        return createPlayer(name, pilotCount, fighterCount, traderCount, engineerCount);
    }
}
