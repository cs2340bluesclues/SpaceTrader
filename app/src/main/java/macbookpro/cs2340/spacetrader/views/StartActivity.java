package macbookpro.cs2340.spacetrader.views;

import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.viewmodels.StartViewModel;

public class StartActivity extends AppCompatActivity {

    /** a reference to our view model */
    private StartViewModel startViewModel;

    //StartViewModel startvm = new StartViewModel();

    /** make an adapter for the list */
    private final ItemAdapter adapter = new ItemAdapter(startViewModel.getMarketInfos());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_activity);

        StartViewModelFactory svmf = new StartViewModelFactory(new Application());
        //grab the reference to our view model
        startViewModel = ViewModelProviders.of(this, svmf).get(StartViewModel.class);

        //first grab a reference to the widget
        RecyclerView recyclerView = findViewById(R.id.marketInfoRecycler);
        //Set the layout manager for the list to just be a vertical list of stuff
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Setup the adapter for the view
        recyclerView.setAdapter(adapter);
    }

}
