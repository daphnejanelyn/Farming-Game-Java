package Model.Crops;

public class Turnip extends Crop {

    public Turnip(String name, String cropType, int harvestTime, double seedCost, double basePrice, int expGained,
            int productsProduced, int cropMinProduce, int cropMaxProduce, int waterMin, int waterLimit,
            int fertilizerMin, int fertilizerLimit, int waterCount, int fertilizerCount) {
        super("Turnip", "Root Crop", 2, 5, 1, 2, 6, 1, 0, 2, 1);
    }

    @Override
    public void updateWaterCount() {
        // TODO Auto-generated method stub

    }
}
