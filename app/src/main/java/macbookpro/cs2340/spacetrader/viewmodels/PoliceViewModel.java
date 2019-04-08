package macbookpro.cs2340.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import macbookpro.cs2340.spacetrader.model.Player;
import macbookpro.cs2340.spacetrader.model.Ship;

import static macbookpro.cs2340.spacetrader.model.ModelFacade.getNewPlayer;

public class PoliceViewModel extends AndroidViewModel {

    private Player player;
    private Ship ship;

    public PoliceViewModel(@NonNull Application application) {
        super(application);
        player = getNewPlayer();
        ship = player.getShip();
    }

    /**
     * Calls method to check cargo and remove illegal goods
     * @return true if illegal goods were removed, false otherwise
     */
    public boolean checkCargoAndRemoveItems(){
        return ship.removeIllegalGoods();
    }

    /**
     * Sets lawfulness status of player
     * @param a boolean true or false to indicate lawful status
     */
    public void setLawfulnessStatus(boolean a) {
        player.setLawfulStatus(a);
    }

    /**
     * Calls method for player to pay a fine for carrying illegal goods
     */
    public void payFine() {
        player.payFine();
    }

    /**
     * Calls  method payBribe in player class
     */
    public void bribe() {
        player.payBribe();
    }

    /**
     * Calls flee method in player class
     * @return Whether or not you successfully flee
     */
    public boolean flee() {return player.flee();}
}
