package Model.Crops;

public class Mango extends Crop {
    public Mango(String cropName, String cropType) {
        super("Mango", "Fruit Tree", 10, 100, 8, 25, 5, 15, 7, 7, 4, 4);
    }

    @Override
    public int generateProduce() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double computeSellPrice(double basePrice, int productsProduced) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void updateWaterCount() {
        // TODO Auto-generated method stub

        if (this.waterCount < this.waterLimit) {

            this.waterCount += 1;

        } else {
            System.out.println("Water limit reached. Bonus will not be applied");
        }
    }

    @Override
    public void updateFertilizerCount() {
        // TODO Auto-generated method stub

        if (this.fertilizerCount < this.fertilizerLimit) {
            this.fertilizerLimit += 1;
        } else {
            System.out.println("Fertilizer Limit reached. Bonus will not be appleid.");
        }
    }

    @Override
    public void updateFertilizerLimit(int increase) {
        // TODO Auto-generated method stub

        this.fertilizerLimit += increase;

    }

    @Override
    public void updateWaterLimit(int increase) {
        // TODO Auto-generated method stub

        this.waterLimit += increase;

    }
}
