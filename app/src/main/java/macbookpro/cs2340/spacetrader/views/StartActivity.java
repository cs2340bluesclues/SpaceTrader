package macbookpro.cs2340.spacetrader.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import macbookpro.cs2340.spacetrader.R;
import macbookpro.cs2340.spacetrader.views.ItemAdapter;

public class StartActivity extends AppCompatActivity {

    //private CourseViewModel courseViewModel;

    /** make an adapter for the list of courses */
    private final ItemAdapter adapter = new ItemAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        //first grab a reference to the widget
        RecyclerView recyclerView = findViewById(R.id.marketInfoRecycler);
        //Set the layout manager for the list to just be a vertical list of stuff
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Setup the adapter for the view
        recyclerView.setAdapter(adapter);


    }

}
