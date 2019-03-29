package macbookpro.cs2340.spacetrader.views;

import macbookpro.cs2340.spacetrader.R;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.viewmodels.PlanetViewModel;

public class PlanetActivity extends AppCompatActivity {
    private PlanetViewModel planetViewModel;

    Button marketButton;
    TextView planetLabel;
    Button cargoButton;
    Button travelButton;
    TextView credits, playerName, shipName, fuelPrice, maxShipFuel, fuelQuantity;
    Button increase, decrease, refuelButton;


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

        maxShipFuel = findViewById(R.id.text_ship_max);
        maxShipFuel.setText(String.valueOf(planetViewModel.getShipFuel()));

        fuelQuantity = findViewById(R.id.quantity_tracker);
        fuelQuantity.setText(String.valueOf(1));

        increase = findViewById(R.id.increase_quantity_button);
        decrease = findViewById(R.id.decrease_quantity_button);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = Integer.parseInt(fuelQuantity.getText().toString());
                int price = Integer.parseInt(fuelPrice.getText().toString());
                if (temp + 1 <= planetViewModel.getShipFuel()) {
                    fuelQuantity.setText(String.valueOf(++temp));
                    fuelPrice.setText(String.valueOf(temp*planetViewModel.getFuelPrice()));
                }
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = Integer.parseInt(fuelQuantity.getText().toString());
                int price = Integer.parseInt(fuelPrice.getText().toString());
                if (temp - 1 > 0) {
                    fuelQuantity.setText(String.valueOf(--temp));
                    fuelPrice.setText(String.valueOf(temp*planetViewModel.getFuelPrice()));
                }
            }
        });


        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMarket();
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
}
