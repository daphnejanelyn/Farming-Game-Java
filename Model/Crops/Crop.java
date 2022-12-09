package Model.Crops;

import java.util.Random;

/**
 * This class initializes all methods needed
 * to plant and harvest a single seed.
 */
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

    /**
     * This constructor initializes all the attributes needed by a crop
     * 
     * @param name            name of the crop
     * @param cropType        crop type of the crop
     * @param harvestTime     minimum harvest time of the crop
     * @param seedCost        amount of money needed to buy a seed
     * @param basePrice       base price of harvested crop
     * @param expGained       experience gain from harvested crop
     * @param cropMinProduce  minimum number of produce
     * @param cropMaxProduce  maximum number of produce
     * @param waterMin        minimum number of times a crop should be watered
     * @param waterLimit      maximum number of times a crop can be watered with
     *                        bonus
     * @param fertilizerMin   minimum number of times a crop should be fertilized
     * @param fertilizerLimit maximum number of times a crop can be fertilized with
     *                        bonus
     */

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

    /**
     * This method gets the name of the crop.
     * 
     * @return name of the crop
     */

    public String getName() {
        return this.name;
    }

    /**
     * This method gets the crop type of the crop.
     * 
     * @return crop type
     */

    public String getCropType() {
        return this.cropType;
    }

    /**
     * This method gets the harvest time of the crop.
     * 
     * @return harvest time of crop
     */

    public int getHarvestTime() {
        return this.harvestTime;
    }

    /**
     * This method gets the seed cost of the crop.
     * 
     * @return crop's seed cost
     */

    public double getSeedCost() {
        return this.seedCost;
    }

    /**
     * This method gets the base price of the crop.
     * 
     * @return crop's base price
     */

    public double getBasePrice() {
        return this.basePrice;
    }

    /**
     * This method gets the experience gain when harvesting a crop.
     * 
     * @return experience gain from crop harvest
     */

    public double getExpGained() {
        return this.expGained;
    }

    /**
     * This method gets the harvest that a crop produces.
     * 
     * @return products produced from crop harvest
     */

    public int getProductsProduced() {
        return this.productsProduced;
    }

    /**
     * This method gets the minimum number of produce that a crop produces.
     * 
     * @return minimum number of produce that a crop can produce
     */

    public int getCropMinProduce() {
        return this.cropMinProduce;
    }

    /**
     * This method gets the maximum number of produce that a crop produces.
     * 
     * @return maximum number of produce that a crop can produce
     */

    public int getCropMaxProduce() {
        return this.cropMaxProduce;
    }

    /**
     * This method gets the minimum water requirement that a crop needs.
     * 
     * @return minimum water requirement of the crop
     */

    public int getWaterMin() {
        return this.waterMin;
    }

    /**
     * This method gets the maximum water requirement for the bonus.
     * 
     * @return maximum water requirement of the crop
     */

    public int getWaterLimit() {
        return this.waterLimit;
    }

    /**
     * This method gets the minimum fertilizer requirement needed by the crop.
     * 
     * @return minimum fertilizer requirement of the crop
     */

    public int getFertilizerMin() {
        return this.fertilizerMin;
    }

    /**
     * This method gets the maximum fertilizer requirement for the bonus.
     * 
     * @return maximum fertilizer requirement of the crop
     */

    public int getFertilizerLimit() {
        return this.fertilizerLimit;
    }

    /**
     * This method gets the number of times the crop has been watered.
     * 
     * @return number of times crop has been watered
     */

    public int getWaterCount() {
        return this.waterCount;
    }

    /**
     * This method gets the number of time the crop has been fertilized.
     * 
     * @return number of times crop has been fertilized
     */

    public int getFertilizerCount() {
        return this.fertilizerCount;
    }

    /**
     * This method initializes the water count back to zero.
     */

    public void setWaterCount() {
        this.waterCount = 0;
    }

    /**
     * This method initializes the fertilizer count back to zero.
     */

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

    /**
     * This method determines how many products can be produced by a crop given its
     * specified range of minimum and maximum number of produce.
     * 
     * @return number of products that can be produced
     */
    public int generateProduce() {
        Random random = new Random();
        this.productsProduced = random.nextInt(this.cropMaxProduce - this.cropMinProduce + 1) + this.cropMinProduce;
        return this.productsProduced;
    }

    /**
     * This method updates the water count if
     * maximum water capacity has not been reached.
     */

    public void updateWaterCount() {
        if (this.waterCount < waterLimit) {
            this.waterCount += 1;
        } else {
            System.out.println("Water limit reached. Bonus will not be applied");
        }
    }

    /**
     * This method updates the fertilizer count if
     * maximum fertilizer capacity has not been reached.
     */

    public void updateFertilizerCount() {
        if (this.fertilizerCount < fertilizerLimit) {
            this.fertilizerCount += 1;
        } else {
            System.out.println("Fertilizer limit reached. Bonus will not be applied");
        }
    }

    /**
     * This method updates the maximum water capacity.
     * 
     * @param increase additional times that a crop can be watered with bonus
     */

    public void updateWaterLimit(int increase) {
        this.waterLimit = this.waterLimit + increase;
    }

    /**
     * This method updates the maximum fertilizer capacity.
     * 
     * @param increase additional times that a crop can be fertilized with bonus.
     */

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