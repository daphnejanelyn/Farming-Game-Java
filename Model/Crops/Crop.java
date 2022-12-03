package Model.Crops;

import java.util.Random;

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

    public void setWaterCount() {
        this.waterCount = 0;
    }

    public void setFertilizerCount() {
        this.fertilizerCount = 0;
    }

    /**
     * This method takes generate the final selling price of the crop
     * using the crop's basePrice and the generated produce.
     * 
     * @param basePrice        base price of per piece of crop upon harvest
     * @param productsProduced how many pieces a crop can produce
     * @return final selling price of crop
     */

    public double computeSellPrice(double basePrice, int productsProduced) {
        double harvestTotal;
        double fertilizerBonus, waterBonus, finalHarvestPrice;

        /*
         * compute for harvestTotal
         * Harvest Total = ProductsProduced x
         * (BaseSellingPricePerPiece +
         * FarmerTypeEarningBonus)
         */

        harvestTotal = productsProduced * (basePrice); // Farmer Type has not yet been declared.

        /*
         * compute for fertilizerBonus
         * FertilizerBonus = HarvestTotal x 0.5 x
         * TimesCropAddedFertilizer
         */
        fertilizerBonus = harvestTotal * 0.5 * fertilizerCount;

        /*
         * compute for waterBonus
         * WaterBonus = HarvestTotal x 0.2
         * x (TimesCropWasWatered – 1)
         */
        waterBonus = harvestTotal * 0.2 * waterCount;

        /*
         * compute FinalHarvestPrice
         * finalHarvestPrice = harvestTotal + waterBonus
         * + fertilizerBonus;
         */
        if (this instanceof Tulip || this instanceof Sunflower || this instanceof Rose) {

            finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;
            finalHarvestPrice = finalHarvestPrice * 1.1;
        } else {
            finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;
        }

        return finalHarvestPrice;
    }

    // abstract public int generateProduce();
    public int generateProduce() {
        Random random = new Random();
        this.productsProduced = random.nextInt(this.cropMaxProduce - this.cropMinProduce + 1) + this.cropMinProduce;
        return this.productsProduced;
    }

    public void updateWaterCount() {
        if (this.waterCount < waterLimit) {
            this.waterCount += 1;
        } else {
            System.out.println("Water limit reached. Bonus will not be applied");
        }
    }

    public void updateFertilizerCount() {
        if (this.fertilizerCount < fertilizerLimit) {
            this.fertilizerCount += 1;
        } else {
            System.out.println("Fertilizer limit reached. Bonus will not be applied");
        }
    }

    public void updateWaterLimit(int increase) {
        this.waterLimit = this.waterLimit + increase;
    }

    public void updateFertilizerLimit(int increase) {
        this.fertilizerLimit = this.fertilizerLimit + increase;
    }

    /**
     * This method evaluates if the
     * minimum water count for the crop has been reached.
     * 
     * @return true if minimum water count has been reached
     *         false if minimum water count hasn't been reached
     */

    public boolean reachedWaterMin() {
        if (waterCount >= this.waterMin) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method evaluates if the
     * minimum fertilizer count for the crop has been reached.
     * 
     * @return true if minimum fertilizer count has been reached
     *         false if minimum fertilizer count hasn't been reached
     */

    public boolean reachedFertilizerMin() {
        if (fertilizerCount >= this.fertilizerMin) {
            return true;
        } else {
            return false;
        }
    }

}