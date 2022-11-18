package Model;

public class ObjectCoin {
    private double amount;

    /**
     * This constructor initializes the farmer's
     * object coins to 100.
     */
    public ObjectCoin() {
        this.amount = 100;
    }

    /**
     * This method returns the player's updated object coins.
     * 
     * @return player's updated object coins
     */

    public double getObjectCoin() {
        return this.amount;
    }

    /**
     * This method increases the player's object coin.
     * 
     * @param amount player's gained object coins
     */

    public void gainObjectCoin(double amount) {
        this.amount += amount;
    }

    /**
     * This method decreases the player's object coin.
     * 
     * @param amount player's spent object coins
     */

    public void loseObjectCoin(double amount) {
        this.amount -= amount;

    }
}
