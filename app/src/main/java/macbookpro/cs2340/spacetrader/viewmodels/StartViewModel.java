package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;

import java.util.List;
import java.util.Map;


import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.model.ModelFacade;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class StartViewModel extends AndroidViewModel {

    Map<MarketInfo, Integer> marketInfoMap;
    Planet currPlanet;

    public StartViewModel(@NonNull Application application) {
        super(application);
        currPlanet = getCurrentPlanet();
        marketInfoMap = currPlanet.getMarket().getMarketGoods();
        Log.i("StartVM", "got till line 27 in STARTVM. Curr planet is " + currPlanet);
    }

    public Map<MarketInfo,Integer> getMarketInfos() {
        return marketInfoMap;
    }

    public Planet getCurrPlanet() {
        return currPlanet;
    }
}