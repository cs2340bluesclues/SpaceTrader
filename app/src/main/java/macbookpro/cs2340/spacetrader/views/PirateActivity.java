package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.viewmodels.PirateViewModel;

public class PirateActivity extends AppCompatActivity {
    private PirateViewModel pirateViewModel;

    private TextView introMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pirate_activity);

        pirateViewModel = ViewModelProviders.of(this).get(PirateViewModel.class);

        introMessage = findViewById(R.id.intro_message_police);
    }
}
