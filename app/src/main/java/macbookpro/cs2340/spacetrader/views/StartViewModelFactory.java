package macbookpro.cs2340.spacetrader.views;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import macbookpro.cs2340.spacetrader.viewmodels.StartViewModel;

public class StartViewModelFactory implements ViewModelProvider.Factory {
    private Application app;

    public StartViewModelFactory(Application app) {
        this.app = app;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new StartViewModel(app);
    }
}
