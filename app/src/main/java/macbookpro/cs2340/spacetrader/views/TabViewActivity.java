package macbookpro.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import macbookpro.cs2340.spacetrader.R;


public class TabViewActivity extends AppCompatActivity{
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_view_activity);

        TabHost host = findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Market");
        //spec.setContent(R.id.tab1);
        spec.setIndicator("Market");

        Intent intent = new Intent(this, PlanetActivity.class);
        spec.setContent(intent);

        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Travel");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Travel");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Player Stats");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Player Stats");
        host.addTab(spec);

//        //Tab4
//        TabHost.TabSpec spec4 = host.newTabSpec("Planet");
//        spec.setIndicator("Planet");
//
//        Intent intent4 = new Intent(this, PlanetActivity.class);
//        spec.setContent(intent4);
//        host.addTab(spec4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

