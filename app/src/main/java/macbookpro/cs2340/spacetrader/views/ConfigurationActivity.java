package macbookpro.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.GameDifficulty;
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
        setContentView(R.layout.config);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }

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
        intent.putExtra(name);
        intent.putExtra(level);

        setResult(RESULT_OK, intent);

        finish();

    }

}
