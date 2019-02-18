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
    //some experimental shit
    Button addPilot, subtractPilot, addFighter, subtractFighter, addTrader, subtractTrader, addEngineer, subtractEngineer;
    TextView pilotSkill, fighterSkill, traderSkill, engineerSkill;
    ConfigurationViewModel pilotVM, fighterVM, traderVM, engineerVM;
    int totalSkillCount;
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

        addPilot = findViewById(R.id.add_pilot_skill_button);
        subtractPilot = findViewById(R.id.subtract_pilot_skill_button);
        pilotSkill = findViewById(R.id.pilot_skill_tracker);

        addFighter = findViewById(R.id.add_fighter_skill_button);
        subtractFighter = findViewById(R.id.subtract_fighter_skill_button);
        fighterSkill = findViewById(R.id.fighter_skill_tracker);

        addTrader = findViewById(R.id.add_trader_skill_button);
        subtractTrader = findViewById(R.id.subtract_trader_skill_button);
        traderSkill = findViewById(R.id.trader_skill_tracker);

        addEngineer = findViewById(R.id.add_engineer_skill_button);
        subtractEngineer = findViewById(R.id.subtract_engineer_skill_button);
        engineerSkill = findViewById(R.id.engineer_skill_tracker);

        Button submit = findViewById(R.id.submit_player_info_button);

        //makes difficulties visible in the spinner
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        //updates the textview of each skill, still need to figure out how to cap at 16 total

        pilotVM = new ConfigurationViewModel();
        fighterVM = new ConfigurationViewModel();
        traderVM = new ConfigurationViewModel();
        engineerVM = new ConfigurationViewModel();

        addPilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pilotVM.setCount(pilotVM.getCount() + 1);
                pilotSkill.setText("" + pilotVM.getCount());
            }
        });

        subtractPilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pilotVM.getCount() > 0) {
                    pilotVM.setCount(pilotVM.getCount() - 1);
                    pilotSkill.setText("" + pilotVM.getCount());
                }
            }
        });

        addFighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fighterVM.setCount(fighterVM.getCount() + 1);
                fighterSkill.setText("" + fighterVM.getCount());
            }
        });

        subtractFighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fighterVM.getCount() > 0) {
                    fighterVM.setCount(fighterVM.getCount() - 1);
                    fighterSkill.setText("" + fighterVM.getCount());
                }
            }
        });

        addTrader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                traderVM.setCount(traderVM.getCount() + 1);
                traderSkill.setText("" + traderVM.getCount());
            }
        });

        subtractTrader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (traderVM.getCount() > 0) {
                    traderVM.setCount(traderVM.getCount() - 1);
                    traderSkill.setText("" + traderVM.getCount());
                }
            }
        });

        addEngineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engineerVM.setCount(engineerVM.getCount() + 1);
                engineerSkill.setText("" + engineerVM.getCount());
            }
        });

        subtractEngineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (engineerVM.getCount() > 0) {
                    engineerVM.setCount(engineerVM.getCount() - 1);
                    engineerSkill.setText("" + engineerVM.getCount());
                }
            }
        });
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
