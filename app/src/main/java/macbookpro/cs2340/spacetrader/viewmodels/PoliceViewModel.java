package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

public class PoliceViewModel extends AndroidViewModel {

    public PoliceViewModel(@NonNull Application application) {
        super(application);
    }
}
