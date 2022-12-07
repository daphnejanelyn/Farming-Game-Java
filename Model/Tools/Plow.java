package Model.Tools;

import Model.Level;
import Model.ObjectCoin;

public class Plow extends Tools {
    /**
     * This constructor initializes the amount of money
     * needed and experience gaines when using the
     * plowing tool.
     */

    public Plow() {
        super(0, 0.5);
    }

    /**
     * This method allows the tile or plant to be plowed.
     *
     * @param amount current number of ObjectCoins
     * @param level  current level of the player
     */

    public void useTool(ObjectCoin amount, Level level) {

        /* Deduct cost of using the Plowing tool */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the Plowing tool */
        level.updateXP(getExperienceGain());
    }

}
