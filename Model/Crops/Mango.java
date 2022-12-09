package Model.Crops;

/**
 * This class initializes all attributes of a mango crop.
 */
public class Mango extends Crop {
    /**
     * This constructor initializes all attributes of crop Mango.
     * 
     * @param cropName name of the crop
     * @param cropType crop type of the crop
     */
    public Mango(String cropName, String cropType) {
        super("Mango", "Fruit Tree", 10, 100, 8, 25, 5, 15, 7, 7, 4, 4);
    }
}
