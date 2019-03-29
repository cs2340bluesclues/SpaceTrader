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
import macbookpro.cs2340.spacetrader.viewmodels.TravelViewModel;

public class TravelActivity extends AppCompatActivity {

    TravelViewModel travelViewModel;

    private TextView planetMap;
    private TextView solarSystemMap;
    private TextView coords;

    private RadioGroup planetGroup;
    private RadioGroup solarSystemGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_activity);

        travelViewModel = ViewModelProviders.of(this).get(TravelViewModel.class);

        planetGroup = findViewById(R.id.planet_button_group);
        solarSystemGroup = findViewById(R.id.solar_system_button_group);

        planetMap = findViewById(R.id.planet_map_title);
        planetMap.setText(travelViewModel.getCurrPlanet().getName());
        solarSystemMap = findViewById(R.id.SS_map_title);
        solarSystemMap.setText(travelViewModel.getCurrSolarSystem().getName());

        coords = findViewById(R.id.coords);
        coords.setText(travelViewModel.getCurrSolarSystem().getCoords().toString());

        addPlanetButtons(travelViewModel.getCurrSolarSystem());
        addSolarSystemButtons();
    }

    private void addSolarSystemButtons() {
        for(SolarSystem s : travelViewModel.getAllSS()) {
            final SolarSystem selected = s;
            RadioButton rb = new RadioButton(TravelActivity.this);
            rb.setText(s.getName());
            solarSystemGroup.addView(rb);

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    coords.setText(selected.getCoords().toString());
                    addPlanetButtons(selected);
                }
            });
        }
    }

    private void addPlanetButtons(SolarSystem s) {
        final SolarSystem selected = s;
        planetGroup.removeAllViews();
        for(Planet p : s.getPlanets()) {
            RadioButton rb = new RadioButton(TravelActivity.this);
            rb.setText(p.getName());
            planetGroup.addView(rb);

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // display whatever information here
                }
            });
        }
    }

}
