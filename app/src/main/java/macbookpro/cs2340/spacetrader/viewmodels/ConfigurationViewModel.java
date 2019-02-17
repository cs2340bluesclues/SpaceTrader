package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import macbookpro.cs2340.spacetrader.model.Player;

public class ConfigurationViewModel extends AndroidViewModel {
    private Player player;

    public ConfigurationViewModel(@NonNull Application app) {
        super(app);
    }

}
