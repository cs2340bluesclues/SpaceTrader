package macbookpro.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import macbookpro.cs2340.spacetrader.R;

public class PlanetActivity extends AppCompatActivity {
    //private CourseViewModel courseViewModel;

    Button marketButton;
    TextView planetLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_activity);

        marketButton = findViewById(R.id.market_button);
        planetLabel = findViewById(R.id.planet_label);
        planetLabel.setText("Current Planet: ");

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMarket();
            }
        });
    }

    private void goToMarket() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}
