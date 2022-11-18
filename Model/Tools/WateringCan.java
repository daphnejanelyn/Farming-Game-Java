package Model.Tools;

import Model.Farmtile;
import Model.Level;
import Model.ObjectCoin;

public class WateringCan extends Tools {

    public WateringCan() {
        super(0, 0.5);
    }

    /**
     * This method allows the tile or plant to be watered.
     * 
     * @param Tile   designated tile to use watering can
     * @param amount current number of ObjectCoins
     * @param level  current level of the player
     */
    public void useTool(Farmtile Tile, ObjectCoin amount, Level level) {
        Tile.updateWaterStatus(true);

        /* Deduct cost of using the Watering Can */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the Watering Can */
        level.updateXP(getExperienceGain());
    }

}
