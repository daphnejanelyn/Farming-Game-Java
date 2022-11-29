package Model.Tools;

import Model.Farmtile;
import Model.Level;
import Model.ObjectCoin;

public abstract class Tools {

    private double cost;
    private double experienceGain;

    public Tools(double cost, double experienceGain) {
        this.cost = cost;
        this.experienceGain = experienceGain;
    }

    abstract public void useTool(ObjectCoin amount, Level level);

    /**
     * This method returns the money needed to use the tool.
     * 
     * @return cost of using a tool
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * This method returns experience gained after using the tool.
     * 
     * @return experience gained in using the tool
     */

    public double getExperienceGain() {
        return this.experienceGain;
    }

}
