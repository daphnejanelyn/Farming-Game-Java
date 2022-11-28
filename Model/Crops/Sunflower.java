package Model.Crops;

public class Sunflower extends Crop implements Flower {
    public Sunflower(String cropName, String cropType) {
        super("Sunflower", "Flower", 3, 20, 19, 7.5, 1, 1, 2, 3, 1, 2);
    }

    @Override
    public double addFlowerBonus() {
        // TODO Auto-generated method stub
        return 0;
    }
}