package macbookpro.cs2340.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.viewmodels.ConfigurationViewModel;

public class ConfigurationActivity extends AppCompatActivity {

    /** reference to our view model */
    private ConfigurationViewModel viewModel;

    /* ************************
        Widgets we will need for binding and getting information
     */
    private TextView playerNameLabel;
    private EditText inputName;
    private Spinner difficultySpinner;
    //private ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config.xml);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        /*
         * Grab the dialog widgets so we can get info for later
         */
        playerNameLabel = findViewById(R.id.player_name_label);
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        inputName = findViewById(R.id.input_name);

        Button addPilot = findViewById(R.id.add_pilot_skill_button);
        Button subtractPilot = findViewById(R.id.subtract_pilot_skill_button);
        Button addFighter = findViewById(R.id.add_fighter_skill_button);
        Button subtractFighter = findViewById(R.id.subtract_fighter_skill_button);
        Button addTrader = findViewById(R.id.add_Trader_skill_button);
        Button subtractTrader = findViewById(R.id.subtract_trader_skill_button);
        Button addEngineer = findViewById(R.id.add_engineer_skill_button);
        Button subtractEngineer = findViewById(R.id.subtract_engineer_skill_button);




    }

}
