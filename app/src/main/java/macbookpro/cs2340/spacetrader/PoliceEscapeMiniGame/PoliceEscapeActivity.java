package macbookpro.cs2340.spacetrader.PoliceEscapeMiniGame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import macbookpro.cs2340.spacetrader.views.TravelPlanetActivity;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

public class PoliceEscapeActivity extends Activity {

    // Declare an instance of SnakeEngine
    PoliceEscapeEngine policeEscapeEngine;

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
        endGame();
    }

    public void endGame() {
        if (!policeEscapeEngine.isPlaying) {
            if (!policeEscapeEngine.gameWon) {

                if (getNewPlayer().getCredits() > 200) {
                    getNewPlayer().setCredits(getNewPlayer().getCredits() - 200);
                    getNewPlayer().setLawfulStatus(false);
                } else {
                    getNewPlayer().setCredits(0);
                    getNewPlayer().setLawfulStatus(false);
                }
            }
        }
        Intent intent = new Intent(this, TravelPlanetActivity.class);
        startActivity(intent);
    }

//    // Start the thread in policeEscapeEngine
//    @Override
//    protected void onResume() {
//        super.onResume();
//        policeEscapeEngine.resume();
//    }
//
//    // Stop the thread in policeEscapeEngine
//    @Override
//    protected void onPause() {
//        super.onPause();
//        policeEscapeEngine.pause();
//    }
}
