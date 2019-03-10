package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Pair;

import java.util.List;
import java.util.Map;


import macbookpro.cs2340.spacetrader.model.MarketInfo;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class StartViewModel extends AndroidViewModel {

    Map<MarketInfo, Integer> marketInfoList;

    public StartViewModel(@NonNull Application application, Map<MarketInfo, Integer> marketInfoList) {

        super(application);
        this.marketInfoList = marketInfoList;
    }

    public Map<MarketInfo, Integer> getMarketInfos() {
        marketInfoList = getPlanetMarket();
        return marketInfoList;
    }




}