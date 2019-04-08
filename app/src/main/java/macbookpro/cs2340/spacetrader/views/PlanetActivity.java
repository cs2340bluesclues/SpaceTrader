package macbookpro.cs2340.spacetrader.views;

import macbookpro.cs2340.spacetrader.R;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import macbookpro.cs2340.spacetrader.viewmodels.PlanetViewModel;

public class PlanetActivity extends AppCompatActivity {
    private PlanetViewModel planetViewModel;

    Button marketButton;
    TextView planetLabel;
    Button cargoButton;
    Button travelButton;
    TextView credits, playerName, shipName, fuelPrice, maxShipFuel, fuelQuantity, currFuel;
    Button increase, decrease, refuelButton;
    ImageView fuelbar1, fuelbar2, fuelbar3, fuelbar4, fuelbar5, fuelbar6, fuelbar7;
    ImageView[] fuelbarsArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_activity);

        planetViewModel = ViewModelProviders.of(this).get(PlanetViewModel.class);

        marketButton = findViewById(R.id.market_button);
        cargoButton = findViewById(R.id.cargo_button);
        travelButton = findViewById(R.id.travel_button);

        planetLabel = findViewById(R.id.planet_label);
        planetLabel.setText("Current Planet: " + planetViewModel.getCurrPlanet());

        playerName = findViewById(R.id.player_name_label);
        playerName.setText(planetViewModel.getPlayerName());
        credits = findViewById(R.id.credits);
        credits.setText(String.valueOf(planetViewModel.getCredits()));
        shipName = findViewById(R.id.ship_name);
        shipName.setText(planetViewModel.getShip());
        fuelPrice = findViewById(R.id.fuel_price);
        fuelPrice.setText(String.valueOf(planetViewModel.getFuelPrice()));

        currFuel = findViewById(R.id.current_fuel);
        currFuel.setText((String.valueOf(planetViewModel.getCurrFuel())) + " gallon(s)");
        fuelbar1 = findViewById(R.id.fuelbar1);
        fuelbar2 = findViewById(R.id.fuelbar2);
        fuelbar3 = findViewById(R.id.fuelbar3);
        fuelbar4 = findViewById(R.id.fuelbar4);
        fuelbar5 = findViewById(R.id.fuelbar5);
        fuelbar6 = findViewById(R.id.fuelbar6);
        fuelbar7 = findViewById(R.id.fuelbar7);
        fuelbarsArray = new ImageView[]{fuelbar1, fuelbar2, fuelbar3, fuelbar4, fuelbar5, fuelbar6, fuelbar7};
        displayFuelBars();

        maxShipFuel = findViewById(R.id.text_ship_max);
        maxShipFuel.setText(String.valueOf(planetViewModel.getMaxFuel()));

        fuelQuantity = findViewById(R.id.quantity_tracker);
        fuelQuantity.setText(String.valueOf(0));

        increase = findViewById(R.id.increase_quantity_button);
        decrease = findViewById(R.id.decrease_quantity_button);
        refuelButton = findViewById(R.id.refuel_button);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = Integer.parseInt(fuelQuantity.getText().toString());
                if (temp + 1 + planetViewModel.getCurrFuel() <= planetViewModel.getMaxFuel()) {
                    fuelQuantity.setText(String.valueOf(++temp));
                    fuelPrice.setText(String.valueOf(temp*planetViewModel.getPlayer().getCurrentPlanet().getFuelCost()));
                }
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = Integer.parseInt(fuelQuantity.getText().toString());
                if (temp - 1 > 0) {
                    fuelQuantity.setText(String.valueOf(--temp));
                    fuelPrice.setText(String.valueOf(temp*planetViewModel.getPlayer().getCurrentPlanet().getFuelCost()));
                }
            }
        });

        refuelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                planetViewModel.refuelShip(Integer.parseInt(fuelQuantity.getText().toString()));
                recreate();
                Log.i("refueling", "refueled, amt: "
                        + Integer.parseInt(fuelQuantity.getText().toString())
                        + " price: " + Integer.parseInt(fuelPrice.getText().toString()) );
            }
        });

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMarket();
                //recreate();
            }
        });
        cargoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCargo();
            }
        });

        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTravel();
            }
        });

    }

    private void goToMarket() {
        Intent intent = new Intent(this, MarketActivity.class);
        startActivity(intent);
    }

    private void goToCargo() {
        Intent intent = new Intent(this, CargoActivity.class);
        startActivity(intent);
    }

    private void goToTravel() {
        Intent intent = new Intent(this, TravelPlanetActivity.class);
        startActivity(intent);
    }

    private void displayFuelBars() {
        int currentFuel = planetViewModel.getCurrFuel();

        int fuelbarnumber = 0;
        for (int i = currentFuel; i > -2; i-=2) {
            if (i - 2 > -2) {
                fuelbarsArray[fuelbarnumber].setVisibility(View.VISIBLE);
                fuelbarnumber++;
            }
        }
    }

    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(), "Travel to another planet", Toast.LENGTH_LONG).show();
    }
}
