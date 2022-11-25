package Model.Crops;

public class Turnip extends Crop {

    public Turnip(String name, String cropType) {
        super("Turnip", "Root Crop", 2, 5, 6, 5, 1, 2, 1, 2, 0, 1);
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
