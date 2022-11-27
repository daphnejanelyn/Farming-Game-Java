package Model.Crops;

public abstract class Crop {

    private String name;
    private String cropType;
    private int harvestTime;
    private double seedCost;
    private double basePrice;
    private double expGained;

    private int productsProduced;
    private int cropMinProduce;
    private int cropMaxProduce;

    protected int waterMin;
    protected int waterLimit;
    protected int fertilizerMin;
    protected int fertilizerLimit;

    protected int waterCount = 0;
    protected int fertilizerCount = 0;

    public Crop(String name, String cropType, int harvestTime, double seedCost, double basePrice, double expGained,
            int cropMinProduce, int cropMaxProduce, int waterMin, int waterLimit,
            int fertilizerMin, int fertilizerLimit) {

        this.name = name;
        this.cropType = cropType;
        this.harvestTime = harvestTime;
        this.seedCost = seedCost;
        this.basePrice = basePrice;
        this.expGained = expGained;

        this.cropMinProduce = cropMinProduce;
        this.cropMaxProduce = cropMaxProduce;
        this.waterMin = waterMin;
        this.waterLimit = waterLimit;
        this.fertilizerMin = fertilizerMin;
        this.fertilizerLimit = fertilizerLimit;

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

    public double getExpGained() {
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

    abstract public double computeSellPrice(double basePrice, int productsProduced);

    abstract public int generateProduce();

    abstract public void updateWaterCount();

    abstract public void updateFertilizerCount();

    abstract public void updateFertilizerLimit(int increase);

    abstract public void updateWaterLimit(int increase);
}