package Model.Crops;

public class Rose extends Crop implements Flower {
    public Rose(String cropName, String cropType) {
        super("Rose", "Flower", 1, 5, 5, 2.5, 1, 1, 1, 2, 0, 1);
    }

    @Override
    public double addFlowerBonus() {
        // TODO Auto-generated method stub
        return 0;
    }
}
