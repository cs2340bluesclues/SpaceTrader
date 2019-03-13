package macbookpro.cs2340.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.model.Market;
import macbookpro.cs2340.spacetrader.model.MarketInfo;
import macbookpro.cs2340.spacetrader.viewmodels.MarketViewModel;

public class MarketActivity extends AppCompatActivity {

    /** a reference to our view model */
    private MarketViewModel marketViewModel;

    //MarketViewModel startvm = new MarketViewModel();

    /** make an adapter for the list */
    private ItemAdapter adapter;

    public static final String EXTRA_ITEM = "macbookpro.cs2340.spacetrader.views.EXTRA_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_activity);

        //grab the reference to our view model
        marketViewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

        adapter = new ItemAdapter(marketViewModel.getMarketInfos());

        //first grab a reference to the widget
        RecyclerView recyclerView = findViewById(R.id.marketInfoRecycler);
        //Set the layout manager for the list to just be a vertical list of stuff
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Setup the adapter for the view
        recyclerView.setAdapter(adapter);

        adapter.setOnMarketInfoClickListener(new ItemAdapter.OnMarketInfoClickListener() {
            @Override
            public void onMarketInfoClicked(MarketInfo marketInfo) {
                Intent intent = new Intent(MarketActivity.this, ItemDetailActivity.class);
                intent.putExtra("Market Item", marketInfo.getItem().getName());
                startActivity(intent);
            }
        });
    }


}
