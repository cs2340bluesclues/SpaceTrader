package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;
import macbookpro.cs2340.spacetrader.viewmodels.TravelPlanetViewModel;

public class TravelPlanetActivity extends AppCompatActivity {

    TravelPlanetViewModel travelPlanetViewModel;

    private TextView planetMap;
    private TextView solarSystemMap;
    private TextView coords;

    private RadioGroup planetGroup;
    private RadioGroup solarSystemGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_activity);

        travelPlanetViewModel = ViewModelProviders.of(this).get(TravelPlanetViewModel.class);

        solarSystemMap = findViewById(R.id.SS_map_title);
        planetMap = findViewById(R.id.planet_map_title);

        planetMap.setText(travelPlanetViewModel.getCurrPlanet().getName());

        planetGroup = findViewById(R.id.planet_button_group);
        solarSystemGroup = findViewById(R.id.solar_system_button_group);

        coords = findViewById(R.id.coords);

        addPlanetButtons(travelPlanetViewModel.getCurrSolarSystem());
        addSolarSystemButtons();
    }

    private void addSolarSystemButtons() {
        for(SolarSystem s : travelPlanetViewModel.getAllSS()) {
            final SolarSystem selectedSolarSystem = s;
            RadioButton rb = new RadioButton(TravelPlanetActivity.this);
            rb.setText(selectedSolarSystem.getName());
            solarSystemGroup.addView(rb);

            if (s.equals(travelPlanetViewModel.getCurrSolarSystem())) {
                rb.setChecked(true);
                coords.setText(selectedSolarSystem.getCoords().toString());
                solarSystemMap.setText("Travel in " + selectedSolarSystem.getName() + " Solar System");
            }

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    coords.setText(selectedSolarSystem.getCoords().toString());
                    addPlanetButtons(selectedSolarSystem);

                    solarSystemMap.setText("Travel to " + selectedSolarSystem.getName() + " Solar System");
                }
            });
        }
    }

    private void addPlanetButtons(SolarSystem s) {
        planetGroup.removeAllViews();
        for(Planet p : s.getPlanets()) {
            final Planet selectedPlanet = p;
            RadioButton rb = new RadioButton(TravelPlanetActivity.this);
            rb.setText(selectedPlanet.getName());
            planetGroup.addView(rb);

            if (selectedPlanet.equals(travelPlanetViewModel.getCurrPlanet())) {
                rb.setChecked(true);
            }

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // display whatever information here
                }
            });
        }
    }

}
