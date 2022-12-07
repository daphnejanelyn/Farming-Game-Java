package Model.Tools;

import Model.Level;
import Model.ObjectCoin;

public class Pickaxe extends Tools {
    /**
     * This constructor initializes the amount of money
     * needed and experience gaines when using the
     * pickaxe tool.
     */
    public Pickaxe() {
        super(50, 15);
    }

    /**
     * This method allows the rock to be removed.
     * 
     * @param amount current number of ObjectCoins
     * @param level  current level of the player
     */

    public void useTool(ObjectCoin amount, Level level) {

        /* Deduct cost of using the pickaxe tool */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the pickaxe tool */
        level.updateXP(getExperienceGain());
    }

}
