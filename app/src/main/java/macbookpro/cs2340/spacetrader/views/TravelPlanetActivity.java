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
    private TextView planetDetails;

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
        planetDetails = findViewById(R.id.planet_details);

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
                coords.setText("System Coordinates: " + selectedSolarSystem.getCoords().toString());
                planetMap.setText("Travel to a planet within the " + selectedSolarSystem.getName() + " Solar System");


            }

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    coords.setText("System Coordinates: " + selectedSolarSystem.getCoords().toString());
                    addPlanetButtons(selectedSolarSystem);
                    planetDetails.setText("Selected Planet Details: ");

                    solarSystemMap.setText("Travel to the " + selectedSolarSystem.getName() + " Solar System");
                    planetMap.setText("Travel to a planet within the " + selectedSolarSystem.getName() + " Solar System");
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

                planetDetails.setText(
                        "Selected Planet Details: "
                                + "\nPlanet Name: " + selectedPlanet.getName()
                                + "\nTech Level: " + selectedPlanet.getTechLevel()
                                + "\nCurrent Event: " + selectedPlanet.getEvent()
                                + "\nFuel Cost: " + selectedPlanet.getFuelCost() + " credits/gallon"
                                + "\nResources: " + selectedPlanet.getResources());
            }

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // display whatever information here
                    planetDetails.setText(
                            "Selected Planet Details: "
                            + "\nPlanet Name: " + selectedPlanet.getName()
                            + "\nTech Level: " + selectedPlanet.getTechLevel()
                            + "\nCurrent Event: " + selectedPlanet.getEvent()
                            + "\nFuel Cost: " + selectedPlanet.getFuelCost() + " credits/gallon"
                            + "\nResources: " + selectedPlanet.getResources());
                }
            });
        }
    }

}
