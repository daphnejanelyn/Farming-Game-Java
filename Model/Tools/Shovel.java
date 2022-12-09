package Model.Tools;

import Model.Level;
import Model.ObjectCoin;

/**
 * This class initializes tool cost and experience gained for shovel tool.
 */

public class Shovel extends Tools {

    /**
     * This constructor initializes the amount of money
     * needed and experience gaines when using the
     * shovel tool.
     */

    public Shovel() {
        super(7, 2);
    }

    /**
     * This method allows the plant to be shoveled.
     *
     * @param amount current number of ObjectCoins
     * @param level  current level of the player
     */

    public void useTool(ObjectCoin amount, Level level) {
        /* Deduct cost of using the shovel tool */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the shovel tool */
        level.updateXP(getExperienceGain());
    }

}
