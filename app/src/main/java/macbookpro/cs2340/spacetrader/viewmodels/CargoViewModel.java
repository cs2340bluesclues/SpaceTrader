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
import macbookpro.cs2340.spacetrader.model.Ship;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.*;

public class CargoViewModel extends AndroidViewModel {

    Map<MarketInfo, Integer> cargoMap;
    Ship currShip;


    public CargoViewModel(@NonNull Application application) {
        super(application);
        currShip = getCurrentShip();
        cargoMap = currShip.getCargo();
    }

    public Map<MarketInfo, Integer> getCargoMap() {
        return cargoMap;
    }
}