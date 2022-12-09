package Model.Crops;

/**
 * This class initializes all attributes of an apple crop.
 */

public class Apple extends Crop {
    /**
     * This constructor initializes all attributes of crop Apple.
     * 
     * @param cropName name of the crop
     * @param cropType crop type of the crop
     */
    public Apple(String cropName, String cropType) {
        super("Apple", "Fruit Tree", 10, 200, 5, 25, 10, 15, 7, 7, 5, 5);
    }
}
