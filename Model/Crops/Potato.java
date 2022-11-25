package Model.Crops;

public class Potato extends Crop {
    public Potato(String cropName, String cropType) {
        super("Potato", "Root Crop", 5, 20, 3, 12.5, 1, 10, 3, 4, 1, 2);

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
