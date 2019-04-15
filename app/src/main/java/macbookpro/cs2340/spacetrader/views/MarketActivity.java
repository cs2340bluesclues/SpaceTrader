package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.helper.ItemTouchHelper;
//import android.widget.Button;
import android.widget.TextView;
//import android.widget.Toast;

//import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketItem;
//import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.viewmodels.MarketViewModel;

/**
 * Activity class for the market screen
 */
public class MarketActivity extends AppCompatActivity {

    /** a reference to our view model */
    private MarketViewModel marketViewModel;

    /** widgets*/
    private TextView playerName;
    private TextView playerCredits;
    private TextView remainingCargo;


    /** make an adapter for the list */
    private ItemAdapter adapter;

    public static final String EXTRA_ITEM = "macbookpro.cs2340.spacetrader.views.EXTRA_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_activity);

        //grab the reference to our view model
        marketViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

        playerName = findViewById(R.id.player_name_label);
        playerName.setText(marketViewModel.getPlayerName());
        playerCredits = findViewById(R.id.credits);
        playerCredits.setText(String.valueOf(marketViewModel.getPlayerCredits()));
        remainingCargo = findViewById(R.id.remaining_cargo);
        remainingCargo.setText(String.valueOf("Remaining Cargo: "
                + marketViewModel.getRemainingCargo()));

        adapter = new ItemAdapter(marketViewModel.getMarketInfos(),
                true, marketViewModel.getPlayer(),
                marketViewModel.getMarket());

        //first grab a reference to the widget
        RecyclerView recyclerView = findViewById(R.id.marketInfoRecycler);
        //Set the layout manager for the list to just be a vertical list of stuff
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Setup the adapter for the view
        recyclerView.setAdapter(adapter);

        adapter.setOnMarketInfoClickListener(marketInfo -> {
            Intent intent = new Intent(MarketActivity.this, ItemDetailActivity.class);
            MarketItem item = marketInfo.getItem();
            intent.putExtra("Market Item", item.getName());
            startActivity(intent);
        });


    }

    //this makes the credits on the planet activity page update when you return from market
    //to planetActivity screen using the back button
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, PlanetActivity.class);
        startActivity(intent);
    }


}
