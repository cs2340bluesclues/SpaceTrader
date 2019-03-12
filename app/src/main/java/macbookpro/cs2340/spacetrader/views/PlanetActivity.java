package macbookpro.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.ModelFacade;

public class PlanetActivity extends AppCompatActivity {
    //private CourseViewModel courseViewModel;

    Button marketButton;
    TextView planetLabel;
    Button cargoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_activity);

        marketButton = findViewById(R.id.market_button);
        planetLabel = findViewById(R.id.planet_label);
        planetLabel.setText("Current Planet: " + ModelFacade.getCurrentPlanet().getName());
        cargoButton = findViewById(R.id.cargo_button);

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

    }

    private void goToMarket() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    private void goToCargo() {
        Intent intent = new Intent(this, CargoActivity.class);
        startActivity(intent);
    }
}
