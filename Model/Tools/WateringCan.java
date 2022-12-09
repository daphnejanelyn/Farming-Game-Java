package Model.Tools;

import Model.Level;
import Model.ObjectCoin;
/**
 * This class initializes tool cost and experience gained for watering can.
 */
public class WateringCan extends Tools {

    /**
     * This constructor initializes the amount of money
     * needed and experience gained when using the
     * watering can.
     */

    public WateringCan() {
        super(0, 0.5);
    }

    /**
     * This method allows the tile or plant to be watered.
     * 
     * @param amount current number of ObjectCoins
     * @param level  current level of the player
     */
    public void useTool(ObjectCoin amount, Level level) {

        /* Deduct cost of using the Watering Can */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the Watering Can */
        level.updateXP(getExperienceGain());
    }

}
