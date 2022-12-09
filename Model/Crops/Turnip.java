package Model.Crops;

/**
 * This class initializes all attributes of a turnip crop.
 */
public class Turnip extends Crop {
    /**
     * This constructor initializes all attributes of crop Turnip.
     * 
     * @param cropName name of the crop
     * @param cropType crop type of the crop
     */
    public Turnip(String cropName, String cropType) {
        super("Turnip", "Root Crop", 2, 5, 6, 5, 1, 2, 1, 2, 0, 1);
    }
}
