package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Pair;

import java.util.List;
import java.util.Map;


import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class StartViewModel extends AndroidViewModel {

    List<MarketInfo> marketInfoList;
    Planet currPlanet;

    public StartViewModel(@NonNull Application application, Planet p) {
        super(application);
        currPlanet = p;
        this.marketInfoList = currPlanet.getMarket().setMarketList();
    }

    public List<MarketInfo> getMarketInfos() {
        return marketInfoList;
    }

    public Planet getCurrPlanet() {
        return currPlanet;
    }
}