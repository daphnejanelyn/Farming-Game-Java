package Model.Tools;

import Model.Level;
import Model.ObjectCoin;

public abstract class Tools {

    private double cost;
    private double experienceGain;

    /**
     * This constructor initializes the cost and experience gained using by tools.
     * 
     * @param cost           amount of money it costs to use a tool
     * @param experienceGain experience gained when using the tool
     */

    public Tools(double cost, double experienceGain) {
        this.cost = cost;
        this.experienceGain = experienceGain;
    }

    /**
     * This abstract method enforces the use of the tool method to
     * all of its subclasses
     * 
     * @param amount amount of money it costs to use a tool
     * @param level  level acquired by the user.
     */

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
