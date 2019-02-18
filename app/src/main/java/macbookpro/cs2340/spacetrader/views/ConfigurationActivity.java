package macbookpro.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.GameDifficulty;
import macbookpro.cs2340.spacetrader.model.Player;
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

    //new player??
    private Player player;
    //private ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
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
        Button addTrader = findViewById(R.id.add_trader_skill_button);
        Button subtractTrader = findViewById(R.id.subtract_trader_skill_button);
        Button addEngineer = findViewById(R.id.add_engineer_skill_button);
        Button subtractEngineer = findViewById(R.id.subtract_engineer_skill_button);
        Button submit = findViewById(R.id.submit_player_info_button);

        //makes difficulties visible in the spinner
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
    }

        //ok doesn't work yet but think this is next step to store the data??
//    public void onSubmitPressed(View view) {
//        Log.d("submit", "info submitted");
//        player.setName(playerNameLabel.getText().toString());
//        player.setDifficulty((String) difficultySpinner.getSelectedItem()); // not sure if this should be a string
//        Log.d("submit", "new player data: " + player);
//    }
    private void saveConfiguration() {
        String name = inputName.getText().toString();
        GameDifficulty level = (GameDifficulty) difficultySpinner.getSelectedItem();

        if (name.trim().isEmpty()) {
            Toast.makeText(this, "Fields cannot be blank", Toast.LENGTH_LONG).show();
            return;
        }

        Log.d("APP", "Making intent");
        Log.d("APP", "Data - " + name + " " + " " + level.toString());
        Intent intent = new Intent();
//        intent.putExtra(name);
//        intent.putExtra(level);

        setResult(RESULT_OK, intent);

        finish();

    }

}
