package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;


import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Ship;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

public class PirateViewModel extends AndroidViewModel {
    private Player player;
    private Ship ship;

    public PirateViewModel(@NonNull Application application) {
        super(application);

        player = getNewPlayer();
        ship = player.getShip();

    }

    /**
     * Getter for player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * getter for ship
     * @return player's ship
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Calls clear cargo method on ship class
     */
    public void clearCargo() {
        ship.clearCargo();
    }

    /**
     * Calls fightPirate method in player class
     * @return Whether or not you win the fight
     */

    public boolean fight() {
        return player.fightPirate();
    }

    /**
     * Calls flee method in player class
     * @return Whether or not you escape
     */

    public boolean flee() {
        return player.flee();
    }

}
