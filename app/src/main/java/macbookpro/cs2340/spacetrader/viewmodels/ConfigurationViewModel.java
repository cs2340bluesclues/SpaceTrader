package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import macbookpro.cs2340.spacetrader.model.Player;

public class ConfigurationViewModel {

    private int totalCount;

    private int pilotCount;

    private int fighterCount;

    private int traderCount;

    private int engineerCount;

    public ConfigurationViewModel() {
        totalCount = 0;
        pilotCount = 0;
        fighterCount = 0;
        traderCount = 0;
        engineerCount = 0;
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
        return totalCount <= 16;
    }

    public boolean checkCountLess0() { return totalCount >= 0; }

}
