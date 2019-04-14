package macbookpro.cs2340.spacetrader.PoliceEscapeMiniGame;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
//import android.os.Handler;
import android.view.Display;

public class PoliceEscapeActivity extends Activity {

    // Declare an instance of SnakeEngine
    private PoliceEscapeEngine policeEscapeEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Initialize the result into a Point object
        Point size = new Point();
        display.getSize(size);

        // Create a new instance of the SnakeEngine class
        policeEscapeEngine = new PoliceEscapeEngine(this, size);

        // Make policeEscapeEngine the view of the Activity
        setContentView(policeEscapeEngine);

        policeEscapeEngine.run();

    }

    // Start the thread in policeEscapeEngine
    @Override
    protected void onResume() {
        super.onResume();
        policeEscapeEngine.resume();
    }

    // Stop the thread in policeEscapeEngine
    @Override
    protected void onPause() {
        super.onPause();
        policeEscapeEngine.pause();
    }

}
