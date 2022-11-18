package Model.Tools;

import Model.Farmtile;
import Model.Level;
import Model.ObjectCoin;

public class Fertilizer extends Tools {

    public Fertilizer() {
        super(10, 4);
    }

    /**
     * This method allows the tile or plant to be fertilized.
     * 
     * @param Tile   designated tile to apply fertilizer
     * @param amount current number of ObjectCoins
     * @param level  current level of the player
     */

    public void useTool(Farmtile Tile, ObjectCoin amount, Level level) {
        Tile.updateRockStatus(true);

        /* Deduct cost of using the fertilizer tool */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the fertlizer tool */
        level.updateXP(getExperienceGain());
    }

}
