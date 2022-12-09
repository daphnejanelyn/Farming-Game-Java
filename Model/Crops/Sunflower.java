package Model.Crops;

/**
 * This class initializes all attributes of a sunflower crop.
 */

public class Sunflower extends Crop {
    /**
     * This constructor initializes all attributes of crop Sunflower.
     * 
     * @param cropName name of the crop
     * @param cropType crop type of the crop
     */
    public Sunflower(String cropName, String cropType) {
        super("Sunflower", "Flower", 3, 20, 19, 7.5, 1, 1, 2, 3, 1, 2);
    }
}