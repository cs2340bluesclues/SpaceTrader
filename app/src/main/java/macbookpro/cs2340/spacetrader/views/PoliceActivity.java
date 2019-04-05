package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.viewmodels.PoliceViewModel;

public class PoliceActivity extends AppCompatActivity {
    private PoliceViewModel policeViewModel;

    private TextView introMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_activity);

        policeViewModel = ViewModelProviders.of(this).get(PoliceViewModel.class);

        introMessage = findViewById(R.id.intro_message_police);
    }
}
