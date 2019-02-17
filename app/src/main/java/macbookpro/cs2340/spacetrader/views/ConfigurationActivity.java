package macbookpro.cs2340.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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




    }

}
