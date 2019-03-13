package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.viewmodels.CargoViewModel;
import macbookpro.cs2340.spacetrader.viewmodels.CargoViewModel;

public class CargoActivity extends AppCompatActivity {

    private CargoViewModel cargoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cargo_activity);

        cargoViewModel = ViewModelProviders.of(this).get(CargoViewModel.class);
    }
}
