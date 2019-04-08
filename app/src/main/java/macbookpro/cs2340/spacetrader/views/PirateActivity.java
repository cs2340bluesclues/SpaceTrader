package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.viewmodels.PirateViewModel;

public class PirateActivity extends AppCompatActivity {
    private PirateViewModel pirateViewModel;

    //private TextView introMessage, directions;

    private Button surrenderButton, fightButton, fleeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pirate_activity);

        pirateViewModel = ViewModelProviders.of(this).get(PirateViewModel.class);

        surrenderButton = findViewById(R.id.surrender_button);
        fightButton = findViewById(R.id.fight_button);
        fleeButton = findViewById(R.id.flee_button);

        //introMessage = findViewById(R.id.intro_message_police);

        surrenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pirateViewModel.clearCargo();
                goToPlanetActivity();
                Toast.makeText(getApplicationContext(), "Your cargo has been emptied!", Toast.LENGTH_LONG).show();

            }
        });

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //maybe reroute to the mini game here
                //also should consider the fighter points
                boolean defeatedPirates = pirateViewModel.fight();
                if (defeatedPirates) {
                    Toast.makeText(getApplicationContext(), "You fought off the pirates!", Toast.LENGTH_LONG).show();
                    goToPlanetActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "The pirates defeated you in battle.", Toast.LENGTH_LONG).show();
                }
            }
        });

        fleeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //maybe reroute to the mini game here
                //also should consider the pilot points
                boolean fled = pirateViewModel.flee();
                if (fled) {
                    Toast.makeText(getApplicationContext(), "You escaped the pirates in your ship!", Toast.LENGTH_LONG).show();
                    goToPlanetActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "You did not escape the pirates.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Returns the player to the planet page
     */
    private void goToPlanetActivity() {
        Intent intent = new Intent(this, PlanetActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(), "Please select an option", Toast.LENGTH_LONG).show();
    }
}
