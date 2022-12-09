package Model;

/**
 * This class initializes the current game level the player is currently in.
 */
public class Level {
    private double numberofXP = 0;
    private int levelNumber = 0;

    /** This constructor initializes the player's level. */
    public Level() {

    }

    /**
     * This method returns the current number of XP.
     * 
     * @return number of XP
     */
    public double getXP() {
        return this.numberofXP;
    }

    /**
     * This method returns the current level of the player.
     * 
     * @return player's current level
     */

    public int getLevel() {
        return this.levelNumber;
    }

    /**
     * This method updates the number of XP.
     * 
     * @param exp number of XP gained or lost
     */

    public void updateXP(double exp) {
        numberofXP += exp;
    }

    /**
     * This method converts the number of XP points
     * to its equivalent level number.
     */

    public void determineLevel() {
        this.levelNumber = ((int) this.numberofXP / 100);
    }

}
