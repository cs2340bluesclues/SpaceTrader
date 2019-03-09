package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;


import macbookpro.cs2340.spacetrader.model.MarketInfo;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class StartViewModel extends AndroidViewModel {

    List<MarketInfo> marketInfoList;

    public StartViewModel(@NonNull Application application, List<MarketInfo> marketInfoList) {

        super(application);
        this.marketInfoList = marketInfoList;
    }

    public List<MarketInfo> getMarketInfos() {
        marketInfoList = getPlanetMarket();
        return marketInfoList;
    }




}