package Model.Crops;

public class Tulip extends Crop implements Flower {
    public Tulip(String cropName, String cropType) {
        super("Tulip", "Flower", 2, 10, 9, 5, 1, 1, 2, 3, 0, 1);
    }

    @Override
    public double addFlowerBonus() {
        // TODO Auto-generated method stub
        return 0;
    }
}
