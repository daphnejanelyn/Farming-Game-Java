package Model.Crops;

public abstract class Crop {

    private String name;
    private String cropType;
    private int harvestTime;
    private double seedCost;
    private double basePrice;
    private int expGained;

    private int productsProduced;
    private int cropMinProduce;
    private int cropMaxProduce;
    private int waterMin;
    private int waterLimit;
    private int fertilizerMin;
    private int fertilizerLimit;

    private int waterCount = 0;
    private int fertilizerCount = 0;

    public Crop(String name, String cropType, int harvestTime, double seedCost, double basePrice, int expGained,
            int productsProduced, int cropMinProduce, int cropMaxProduce, int waterMin, int waterLimit,
            int fertilizerMin, int fertilizerLimit, int waterCount, int fertilizerCount) {

        this.name = name;
        this.cropType = cropType;
        this.harvestTime = harvestTime;
        this.seedCost = seedCost;
        this.basePrice = basePrice;
        this.expGained = expGained;

        this.productsProduced = productsProduced;
        this.cropMinProduce = cropMinProduce;
        this.cropMaxProduce = cropMaxProduce;
        this.waterMin = waterMin;
        this.waterLimit = waterLimit;
        this.fertilizerMin = fertilizerMin;
        this.fertilizerLimit = fertilizerLimit;

        this.waterCount = waterCount;
        this.fertilizerCount = fertilizerCount;
    }

    public String getName() {
        return this.name;
    }

    public String getCropType() {
        return this.cropType;
    }

    public int getHarvestTime() {
        return this.harvestTime;
    }

    public double getSeedCost() {
        return this.seedCost;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public int getExpGained() {
        return this.expGained;
    }

    public int getProductsProduced() {
        return this.productsProduced;
    }

    public int getCropMinProduce() {
        return this.cropMinProduce;
    }

    public int getCropMaxProduce() {
        return this.cropMaxProduce;
    }

    public int getWaterMin() {
        return this.waterMin;
    }

    public int getWaterLimit() {
        return this.waterLimit;
    }

    public int getFertilizerMin() {
        return this.fertilizerMin;
    }

    public int getFertilizerLimit() {
        return this.fertilizerLimit;
    }

    public int getWaterCount() {
        return this.waterCount;
    }

    public int getFertilizerCount() {
        return this.fertilizerCount;
    }

    public abstract void updateWaterCount();

    public abstract void updateFertilizerCount();

    public abstract void updateWaterLimit();

    public abstract void updateFertilizerLimit();

}