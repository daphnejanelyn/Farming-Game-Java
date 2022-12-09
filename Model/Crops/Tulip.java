package Model.Crops;

/**
 * This class initializes all attributes of a tulip crop.
 */
public class Tulip extends Crop {
    /**
     * This constructor initializes all attributes of crop Tulip.
     * 
     * @param cropName name of the crop
     * @param cropType crop type of the crop
     */
    public Tulip(String cropName, String cropType) {
        super("Tulip", "Flower", 2, 10, 9, 5, 1, 1, 2, 3, 0, 1);
    }
}
