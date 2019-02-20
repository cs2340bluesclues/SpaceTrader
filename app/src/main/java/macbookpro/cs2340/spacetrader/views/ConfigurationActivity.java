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
    Button addPilot, subtractPilot, addFighter, subtractFighter, addTrader, subtractTrader, addEngineer, subtractEngineer, submit;
    TextView pilotSkill, fighterSkill, traderSkill, engineerSkill;
    ConfigurationViewModel pilotVM, fighterVM, traderVM, engineerVM, totalVM;
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

        submit = findViewById(R.id.submit_player_info_button);

        //makes difficulties visible in the spinner
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        //updates the textview of each skill, still need to figure out how to cap at 16 total
        totalVM = new ConfigurationViewModel();

        addPilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.checkCountGreater16()) {
                    totalVM.setPilotCount(totalVM.getPilotCount() + 1);
                    pilotSkill.setText("" + totalVM.getPilotCount());
                }
            }
        });

        subtractPilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.getPilotCount() > 0) {
                    totalVM.setPilotCount(totalVM.getPilotCount() - 1);
                    pilotSkill.setText("" + totalVM.getPilotCount());
                }
            }
        });

        addFighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.checkCountGreater16()) {
                    totalVM.setFighterCount(totalVM.getFighterCount() + 1);
                    fighterSkill.setText("" + totalVM.getFighterCount());
                }
            }
        });

        subtractFighter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.getFighterCount() > 0) {
                    totalVM.setFighterCount(totalVM.getFighterCount() - 1);
                    fighterSkill.setText("" + totalVM.getFighterCount());
                }
            }
        });

        addTrader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.checkCountGreater16()) {
                    totalVM.setTraderCount(totalVM.getTraderCount() + 1);
                    traderSkill.setText("" + totalVM.getTraderCount());
                }
            }
        });

        subtractTrader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.getTraderCount() > 0) {
                    totalVM.setTraderCount(totalVM.getTraderCount() - 1);
                    traderSkill.setText("" + totalVM.getTraderCount());
                }
            }
        });

        addEngineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.checkCountGreater16()) {
                    totalVM.setEngineerCount(totalVM.getEngineerCount() + 1);
                    engineerSkill.setText("" + totalVM.getEngineerCount());
                }
            }
        });

        subtractEngineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalVM.getEngineerCount() > 0) {
                    totalVM.setEngineerCount(totalVM.getEngineerCount() - 1);
                    engineerSkill.setText("" + totalVM.getEngineerCount());
                }
            }
        });

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                String name = inputName.getText().toString();
                GameDifficulty level = (GameDifficulty) difficultySpinner.getSelectedItem();
                if (totalVM.checkCount16() && totalVM.checkNameLength(name)) {
                    Toast.makeText(getApplicationContext(), "Name field cannot be blank and total skill count must be 16", Toast.LENGTH_LONG).show();
                } else if (totalVM.checkCount16()) {
                    Toast.makeText(getApplicationContext(), "Total skill count must be 16", Toast.LENGTH_LONG).show();
                } else if (totalVM.checkNameLength(name)) {
                    Toast.makeText(getApplicationContext(), "Name field cannot be blank", Toast.LENGTH_LONG).show();
                } else {
                    String s = totalVM.sendData(name, level);
                    //Intent messageIntent = new Intent(ConfigurationActivity.this, StartActivity.class);
                    //messageIntent.putExtra("PRINT_PLAYER_MESSAGE", s);
                    //startActivity(messageIntent);
                    Log.i("player info!", s);
                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
