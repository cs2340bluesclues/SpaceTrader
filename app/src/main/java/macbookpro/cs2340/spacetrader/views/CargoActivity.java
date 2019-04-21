package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import macbookpro.cs2340.spacetrader.R;
//import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.view.View;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.viewmodels.CargoViewModel;
//import macbookpro.cs2340.spacetrader.viewmodels.CargoViewModel;

/**
 * Activity class for the cargo screen
 */
public class CargoActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cargo_activity);

        CargoViewModel cargoViewModel;
        ItemAdapter adapter;
        TextView playerName;
        TextView playerCredits;
        TextView remainingCargo;

        cargoViewModel = ViewModelProviders.of(this).get(CargoViewModel.class);

        playerName = findViewById(R.id.player_name_label);
        playerName.setText(cargoViewModel.getPlayerName());
        playerCredits = findViewById(R.id.credits);
        playerCredits.setText(String.valueOf(cargoViewModel.getPlayerCredits()));
        remainingCargo = findViewById(R.id.remaining_cargo);
        remainingCargo.setText(String.valueOf("Remaining Cargo: "
                + cargoViewModel.getRemainingCargo()));

        adapter = new ItemAdapter(cargoViewModel.getCargoMap(), false,
                cargoViewModel.getPlayer(), cargoViewModel.getMarket());

        //first grab a reference to the widget
        RecyclerView recyclerView = findViewById(R.id.cargoRecycler);
        //Set the layout manager for the list to just be a vertical list of stuff
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Setup the adapter for the view
        recyclerView.setAdapter(adapter);
    }

    //this makes the credits on the planet activity page update when you return from cargo
    //to planetActivity screen using the back button
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, PlanetActivity.class);
        startActivity(intent);
    }
}
