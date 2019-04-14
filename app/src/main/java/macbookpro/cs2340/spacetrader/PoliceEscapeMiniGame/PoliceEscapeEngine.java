package macbookpro.cs2340.spacetrader.PoliceEscapeMiniGame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.Random;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import macbookpro.cs2340.spacetrader.views.PlanetActivity;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

public class PoliceEscapeEngine extends SurfaceView implements Runnable {
    private Thread thread;

    private final Context context;

    public enum Heading {UP, RIGHT, DOWN, LEFT}
    private Heading heading = Heading.LEFT;

    private final int screenX;
    private final int screenY;

    private final int[] bobXs;
    private final int[] bobYs;

    private final int blockSize;
    private final int NUM_BLOCKS_WIDE = 40;
    private final int numBlocksHigh;

    private long nextFrameTime;
    private final long FPS = 10;
    private final long MILLIS_PER_SECOND = 1000;
    private int snakeX;
    private int snakeY;

    volatile boolean isPlaying;
    boolean gameWon;

    private Canvas canvas;
    private final SurfaceHolder surfaceHolder;
    private final Paint paint;

    public PoliceEscapeEngine(Context context, Point size) {
        super(context);

        this.context = context;

        screenX = size.x;
        screenY = size.y;

        blockSize = screenX / NUM_BLOCKS_WIDE;
        numBlocksHigh = screenY / blockSize;

        // Initialize the drawing objects
        surfaceHolder = getHolder();
        paint = new Paint();

        snakeX = NUM_BLOCKS_WIDE / 2;
        snakeY = numBlocksHigh - 2;

        bobXs = new int[20];
        bobYs = new int[bobXs.length];

        // Start the game
        newGame();
    }

    @Override
    public void run() {

        while (isPlaying) {
            if(updateRequired()) {
                update();
                draw();
            }

        }
    }

    public void pause() {
        isPlaying = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            // Error
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void newGame() {
        spawnBob();

        nextFrameTime = System.currentTimeMillis();
    }

    public void spawnBob() {
        Random random = new Random();
        int xpos = 0;
        int ypos = 0;
        for (int i = 0; i < bobXs.length; i++) {
            xpos = random.nextInt(NUM_BLOCKS_WIDE - 10) + 1;
            ypos = random.nextInt(numBlocksHigh - 1) + 1;
            if (xpos != snakeX && ypos != snakeY) {
                bobXs[i] = xpos;
                bobYs[i] = ypos;
            }
        }
    }

    private boolean crash(){
        for (int i = 0; i < bobXs.length; i++) {
            if (snakeX == bobXs[i] && snakeY == bobYs[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean detectDeath(){
        boolean dead = false;

        if (snakeX == -1) dead = true;
        if (snakeX >= NUM_BLOCKS_WIDE) dead = true;
        if (snakeY == numBlocksHigh) dead = true;

        return dead;
    }

    private boolean win() {
        if (snakeY == -1) {
            gameWon = true;
        }
        return gameWon;
    }

    private void moveSnake(){
        switch (heading) {
            case UP:
                snakeY--;
                break;

            case RIGHT:
                snakeX++;
                break;

            case DOWN:
                snakeY++;
                break;

            case LEFT:
                snakeX--;
                break;
        }
    }

    public void update() {
        if (win()) {
            isPlaying = false;
        } else if (crash()) {
            isPlaying = false;
        } else {
            moveSnake();
            if (detectDeath()) {
                isPlaying = false;
            }
        }

        if (!isPlaying) {
            if (!gameWon) {
                getNewPlayer().payFine();
                getNewPlayer().setLawfulStatus(false);
                // Toast.makeText(context,
                // "You have been arrested by the police and lost money." ,
                // Toast.LENGTH_LONG).show();
                Log.d("Lost Game:","You have been arrested by the police and lost money.");
            } else {
                //Toast.makeText(context, "You have escaped the police.", Toast.LENGTH_LONG).show();
                Log.d("Won Game:","You have escaped the police.");
            }

            Intent intent = new Intent(context, PlanetActivity.class);
            context.startActivity(intent);
        }
    }

    public void draw() {
        // Get a lock on the canvas
        if (surfaceHolder.getSurface().isValid()) {
            canvas = surfaceHolder.lockCanvas();

            // Fill the screen with Game Code School blue
            canvas.drawColor(Color.argb(255, 26, 128, 182));

            // Set the color of the paint to draw the snake white
            paint.setColor(Color.argb(255, 255, 255, 255));

            // Draw the snake one block at a time
            canvas.drawRect(snakeX * blockSize,
                    snakeY * blockSize,
                    (snakeX * blockSize) + blockSize,
                    (snakeY * blockSize) + blockSize, paint);

            // Set the color of the paint to draw Bob red
            paint.setColor(Color.argb(255, 255, 0, 0));

            for (int i = 0; i < bobXs.length; i++) {
                canvas.drawRect(bobXs[i] * blockSize,
                        (bobYs[i] * blockSize),
                        (bobXs[i] * blockSize) + blockSize,
                        (bobYs[i] * blockSize) + blockSize,
                        paint);
            }
            // Unlock the canvas and reveal the graphics for this frame
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public boolean updateRequired() {

        // Are we due to update the frame
        if(nextFrameTime <= System.currentTimeMillis()){
            // Tenth of a second has passed

            // Setup when the next update will be triggered
            nextFrameTime =System.currentTimeMillis() + MILLIS_PER_SECOND / FPS;

            // Return true so that the update and draw
            // functions are executed
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                if (motionEvent.getX() >= screenX / 2
                        && (motionEvent.getY() > screenY / 4
                        && motionEvent.getY() < screenY * 3 / 4)) {
                    heading = Heading.RIGHT;
                } else if (motionEvent.getX() < screenX / 2
                        && (motionEvent.getY() > screenY / 4
                        && motionEvent.getY() < screenY * 3 / 4)) {
                    heading = Heading.LEFT;
                } else if (motionEvent.getY() <= screenY / 4) {
                    heading = Heading.UP;
                } else {
                    heading = Heading.DOWN;
                }
        }
        return true;
    }
}
