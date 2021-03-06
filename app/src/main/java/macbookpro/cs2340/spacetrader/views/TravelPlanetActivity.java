package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import macbookpro.cs2340.spacetrader.R;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import macbookpro.cs2340.spacetrader.model.Universe.Planet;
import macbookpro.cs2340.spacetrader.model.Universe.SolarSystem;
import macbookpro.cs2340.spacetrader.viewmodels.TravelPlanetViewModel;

/**
 * Activity class for the Travel Screen
 */

public class TravelPlanetActivity extends AppCompatActivity {

    private TravelPlanetViewModel travelPlanetViewModel;

    private TextView planetMap;
    private TextView solarSystemMap;
    private TextView coords;
    private TextView planetDetails;


    private SolarSystem travelToThisSolarSystem;
    private Planet travelToThisPlanet;

    private RadioGroup planetGroup;
    private RadioGroup solarSystemGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_activity);

        Button travelHere;
        travelPlanetViewModel = ViewModelProviders.of(this).get(TravelPlanetViewModel.class);

        planetDetails = findViewById(R.id.planet_details);
        solarSystemMap = findViewById(R.id.SS_map_title);
        planetMap = findViewById(R.id.planet_map_title);


        planetMap.setText(travelPlanetViewModel.getCurrPlanetName());

        planetGroup = findViewById(R.id.planet_button_group);
        solarSystemGroup = findViewById(R.id.solar_system_button_group);

        coords = findViewById(R.id.coords);

        travelHere = findViewById(R.id.travel_here_button);
        addPlanetButtons(travelPlanetViewModel.getCurrSolarSystem());
        addSolarSystemButtons();

        travelHere.setOnClickListener( v -> {
            MediaPlayer mp2 = MediaPlayer.create(this, R.raw.error_buzzer_audio);
                if (travelToThisPlanet.equals(travelPlanetViewModel.getCurrPlanet())) {
                    Toast.makeText(getApplicationContext(),
                            "You are already at this planet",
                            Toast.LENGTH_LONG).show();
                } else if (!travelPlanetViewModel.travel(travelToThisSolarSystem,
                        travelToThisPlanet)) {
                    //this is if you are unable to travel, so the travel method returns false
                    Toast.makeText(getApplicationContext(),
                            "You do not have enough fuel to travel here",
                            Toast.LENGTH_LONG).show();
                } else if (travelPlanetViewModel.policeEvent()) {
                    travelPlanetViewModel.travel(travelToThisSolarSystem, travelToThisPlanet);
                    mp2.start();
                    goToPoliceActivity();
                } else if (travelPlanetViewModel.pirateEvent()) {
                    travelPlanetViewModel.travel(travelToThisSolarSystem, travelToThisPlanet);
                    mp2.start();
                    goToPirateActivity();
                } else  {
                    travelPlanetViewModel.travel(travelToThisSolarSystem, travelToThisPlanet);
                    MediaPlayer mp = MediaPlayer.create(this, R.raw.travel_audio);
                    mp.start();
                    goToPlanetActivity();
                }
        });
    }

    /**
     * Returns user to PlanetActivity page of current planet
     */
    private void goToPlanetActivity() {
        Intent intent = new Intent(this, PlanetActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToPoliceActivity() {
        Intent intent = new Intent(this, PoliceActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToPirateActivity() {
        Intent intent = new Intent(this, PirateActivity.class);
        startActivity(intent);
        finish();
    }

    private void addSolarSystemButtons() {
        for(SolarSystem s : travelPlanetViewModel.getAllSS()) {
            final SolarSystem selectedSolarSystem = s;
            RadioButton rb = new RadioButton(TravelPlanetActivity.this);
            rb.setText(selectedSolarSystem.getName());
            solarSystemGroup.addView(rb);

            if (s.equals(travelPlanetViewModel.getCurrSolarSystem())) {
                rb.setChecked(true);
                String s1 = "System Coordinates: " + selectedSolarSystem.coordsToString();
                coords.setText(s1);
                String s2 = "Travel to a planet within the " + selectedSolarSystem.getName() +
                        " Solar System";
                planetMap.setText(s2);
                coords.setText("System Coordinates: " + selectedSolarSystem.coordsToString());
                planetMap.setText("Travel to a planet within the " + selectedSolarSystem.getName()
                        + " Solar System");

                travelToThisSolarSystem = selectedSolarSystem;


            }

            rb.setOnClickListener( v -> {
                    String s1 = "System Coordinates: " + selectedSolarSystem.coordsToString()
                        + "\nDistance away: " + travelPlanetViewModel.calculateDistance(selectedSolarSystem);
                    coords.setText(s1);
                    addPlanetButtons(selectedSolarSystem);
                    String s2 = "Selected Planet Details: ";
                    planetDetails.setText(s2);
                    String s3 = "Travel to the " + selectedSolarSystem.getName() + " Solar System";
                    solarSystemMap.setText(s3);
                    String s4 = "Travel to a planet within the " + selectedSolarSystem.getName() +
                            " Solar System";
                    planetMap.setText(s4);
                    coords.setText("System Coordinates: "
                            + selectedSolarSystem.coordsToString()
                            + "\nDistance away: " + travelPlanetViewModel.calculateDistance(selectedSolarSystem));
                    addPlanetButtons(selectedSolarSystem);
                    planetDetails.setText("Selected Planet Details: ");

                    solarSystemMap.setText("Travel to the " + selectedSolarSystem.getName()
                            + " Solar System");
                    planetMap.setText("Travel to a planet within the "
                            + selectedSolarSystem.getName() + " Solar System");

                    travelToThisSolarSystem = selectedSolarSystem;
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
                travelToThisPlanet = selectedPlanet;

                String s5 = "Selected Planet Details: "
                        + "\nPlanet Name: " + selectedPlanet.getName()
                        + "\nTech Level: " + selectedPlanet.getTechLevel()
                        + "\nCurrent Event: " + selectedPlanet.getEvent()
                        + "\nFuel Cost: " + selectedPlanet.getFuelCost() + " credits/gallon"
                        + "\nResources: " + selectedPlanet.getResources();

                planetDetails.setText(s5);
            }

            rb.setOnClickListener( v-> {
                    travelToThisPlanet = selectedPlanet;
                    // display whatever information here
                    String s6 = "Selected Planet Details: "
                            + "\nPlanet Name: " + selectedPlanet.getName()
                            + "\nTech Level: " + selectedPlanet.getTechLevel()
                            + "\nCurrent Event: " + selectedPlanet.getEvent()
                            + "\nFuel Cost: " + selectedPlanet.getFuelCost() + " credits/gallon"
                            + "\nResources: " + selectedPlanet.getResources();
                    planetDetails.setText(s6);
            });
        }
    }

}
