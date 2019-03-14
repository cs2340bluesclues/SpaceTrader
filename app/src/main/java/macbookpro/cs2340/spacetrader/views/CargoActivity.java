package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.viewmodels.CargoViewModel;
import macbookpro.cs2340.spacetrader.viewmodels.CargoViewModel;

public class CargoActivity extends AppCompatActivity {

    private CargoViewModel cargoViewModel;
    private ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cargo_activity);

        cargoViewModel = ViewModelProviders.of(this).get(CargoViewModel.class);
        adapter = new ItemAdapter(cargoViewModel.getCargoMap(), false, cargoViewModel.getPlayer(), cargoViewModel.getMarket());

        //first grab a reference to the widget
        RecyclerView recyclerView = findViewById(R.id.cargoRecycler);
        //Set the layout manager for the list to just be a vertical list of stuff
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Setup the adapter for the view
        recyclerView.setAdapter(adapter);
    }
}
