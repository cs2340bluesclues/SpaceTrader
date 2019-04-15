package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.Toast;

import macbookpro.cs2340.spacetrader.PoliceEscapeMiniGame.PoliceEscapeActivity;
import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.viewmodels.PoliceViewModel;

/**
 * Activity class for the police encounter screen
 */
public class PoliceActivity extends AppCompatActivity {
    private PoliceViewModel policeViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_activity);

        Button acceptButton;
        Button bribeButton;
        Button fleeButton;
        policeViewModel = ViewModelProviders.of(this).get(PoliceViewModel.class);

        acceptButton = findViewById(R.id.accept_check_button);
        bribeButton = findViewById(R.id.bribe_button);
        fleeButton = findViewById(R.id.flee_button);

        acceptButton.setOnClickListener(v -> {
             if (policeViewModel.checkCargoAndRemoveItems()) {
                 policeViewModel.setLawfulnessStatus(false);
                 policeViewModel.payFine();
                 goToPlanetActivity();
                 Toast.makeText(getApplicationContext(),
                         "You have now been flagged by the police",
                         Toast.LENGTH_LONG).show();
             } else {
                 policeViewModel.setLawfulnessStatus(true);
                 goToPlanetActivity();
                 Toast.makeText(getApplicationContext(),
                         "You have been deemed a lawful citizen",
                         Toast.LENGTH_LONG).show();
             }

        });

        bribeButton.setOnClickListener(v -> {
            policeViewModel.bribe();
            goToPlanetActivity();
            Toast.makeText(getApplicationContext(),
                    "Your credits have decreased by 15%",
                    Toast.LENGTH_LONG).show();

        });

        fleeButton.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),
                    "You are fleeing the police. "
                            + "\nMake it to the top of the screen without crashing into blocks"
                            + "and you'll escape. "
                            + "\nTouch the sides of the screen to change direction.",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PoliceEscapeActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Returns the player to the planet page
     */
    private void goToPlanetActivity() {
        Intent intent = new Intent(this, PlanetActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(), "Please select an option",
                Toast.LENGTH_LONG).show();
    }
}
