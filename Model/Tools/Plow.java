package Model.Tools;

import Model.Farmtile;
import Model.Level;
import Model.ObjectCoin;

public class Plow extends Tools {

    public Plow() {
        super(0, 0.5);
    }

    public void useTool(Farmtile Tile, ObjectCoin amount, Level level) {
        Tile.updatePlowed(true);

        /* Deduct cost of using the Plowing tool */
        amount.loseObjectCoin(getCost());

        /* XP gained from using the Plowing tool */
        level.updateXP(getExperienceGain());
    }

}
