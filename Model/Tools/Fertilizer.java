package Model.Tools;

import Model.Level;
import Model.ObjectCoin;

public class Fertilizer extends Tools {

    /**
     * This constructor initializes the amount of money
     * needed and experience gained when using the
     * fertilizer tool.
     */

    public Fertilizer() {
        super(10, 4);
    }

    /**
     * This method allows the tile or plant to be fertilized.
     * 
     * @param amount current number of ObjectCoins
     * @param level  current level of the player
     */

    public void useTool(ObjectCoin amount, Level level) {

        /* Deduct cost of using the fertilizer tool */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the fertlizer tool */
        level.updateXP(getExperienceGain());
    }

}
