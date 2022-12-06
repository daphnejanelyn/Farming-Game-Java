package Model;

import Model.Crops.*;
import Model.Tools.*;
import java.util.ArrayList;

public class Farmer {

    private String name;
    private ArrayList<Crop> plantList;
    private Level level;
    private ObjectCoin amount;
    private Farmtile tile;
    private int day = 0;
    private int tileIndex;
    private Farm land;

    private int bonusEarning = 0;
    protected double costReduction = 0;
    protected double registrationFee = 0;
    protected int waterLimitIncrease = 0;
    protected int fertilizerLimitIncrease = 0;

    private int productsProduced;
    private double finalHarvestPrice;

    private int minDayHarvest = 0;

    /**
     * This constructor initializes the name of the player, and
     * the assets of the player such a list of all his/her crops,
     * level number, money stored, and farm land.
     * 
     * @param name is the user's chosen name.
     */
    public Farmer(String name) {
        this.name = name;
        this.plantList = new ArrayList<Crop>();
        this.level = new Level();
        this.amount = new ObjectCoin();
        this.tile = new Farmtile();
        this.land = new Farm();
    }

    /**
     * This method identifies which tile the farmer is navigating.
     * 
     * @param tileClicked index of tile the player has clicked
     */

    public void assignTile(int tileClicked) {
        this.tileIndex = tileClicked;
        this.tile = land.getTile(tileIndex);
    }

    /**
     * This method returns the whole list of farm tiles that the player's farm lot
     * has.
     * 
     * @return arraylist of farm tiles that the farm lot has
     */
    public ArrayList<Farmtile> getAllTiles() {
        return this.land.getTileList();
    }

    /**
     * This method identifies which crop is stored in the tile.
     * 
     * @param index index of tile that the program wants to examine
     * @return crop type of the crop in the tile associated with the given index
     */

    public String determineCrop(int index) {
        Crop temp = this.land.getTile(index).identifyCropinTile();

        if (temp instanceof Turnip) {
            return "Turnip";
        } else if (temp instanceof Carrot) {
            return "Carrot";
        } else if (temp instanceof Potato) {
            return "Potato";
        } else if (temp instanceof Rose) {
            return "Rose";
        } else if (temp instanceof Sunflower) {
            return "Sunflower";
        } else if (temp instanceof Tulip) {
            return "Tulip";
        } else if (temp instanceof Mango) {
            return "Mango";
        } else {
            return "Apple";
        }

    }

    /**
     * This method gets the index of tile clicked.
     * 
     * @return index of tile clicked
     */

    public int determineTile() {
        return this.tileIndex;
    }

    /**
     * This method gets the name of the player
     * 
     * @return name of the player
     */

    public String getName() {
        return this.name;
    }

    /**
     * This method gets the day in which the player is currently in in the game.
     * 
     * @return current day of the game
     */

    public int getDay() {
        return this.day;
    }

    /**
     * This method gets the amount of object coins the player has.
     * 
     * @return updated amount of object coins
     */

    public double getObjectCoin() {
        return this.amount.getObjectCoin();
    }

    /**
     * This method sets the level of the player based on his/her XP.
     * 
     * @return level of the player
     */

    public int getLevel() {
        this.level.determineLevel();
        return this.level.getLevel();
    }

    /**
     * This method gets the current XP the player has
     * 
     * @return updated number of XP
     */

    public double getXP() {
        return this.level.getXP();
    }

    /**
     * This method gets the minimum harvest time of the crop
     * stored in the assigned tile.
     * 
     * @return minimum harvest time of crop
     */

    public int getminHarvestTime() {
        return this.minDayHarvest;
    }

    /**
     * This method gets the registration fee needed to upgrade to a specific farmer
     * type.
     * 
     * @return registration fee for farmer upgrade
     */
    public double getRegFee() {
        return this.registrationFee;
    }

    /**
     * This method gets the tile currently clicked by the player
     * 
     * @return tile clicked
     */

    public Farmtile getTile() {
        return this.tile;
    }

    /**
     * This method gets the number of products produced
     * once a crop is harvested.
     * 
     * @return number of products produced
     */

    public int getProductsProduced() {
        return this.productsProduced;
    }

    /**
     * This method gets the final harvest price
     * of a specific harvest.
     * 
     * @return final harvest price
     */
    public double getFinalHarvestPrice() {
        return this.finalHarvestPrice;
    }

    /**
     * This method adds bought seed to the list of crops that the player has.
     * 
     * @param crop crop that the player bought
     */

    public void addCrop(Crop crop) {
        this.plantList.add(crop);
    }

    /**
     * This method gets the entire list of crop the player has
     * 
     * @return entire list of crops
     */

    public ArrayList<Crop> getCrop() {
        return this.plantList;
    }

    /**
     * This method identifies if the player is allowed to plow a tile.
     * 
     * @return true if plowing of tile is allowed
     *         false if plowing of tile is not allowed
     */

    public boolean plowedAllow() {

        /*
         * Plowing is not allowed if there is a crop planted
         * and a rock placed in the assigned tile
         */

        if (this.tile.isPlowed() == false && this.tile.isPlanted() == false && this.tile.isRockThere() == false) {
            return true;
        } else if (this.tile.isRockThere() == true) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * This method allows the player to use the plowing tool
     * and deducts its cost and experience gain in his/her assets.
     */

    public void plowTile() {
        Plow plow = new Plow();
        plow.useTool(amount, level);
        this.tile.updatePlowed(true);
    }

    /**
     * This method identifies if the player is allowed to water a tile.
     * 
     * @return true if watering of tile is allowed
     *         false if watering of tile is not allowed
     */

    public boolean waterAllowed() {
        /* Watering can is only activated if tile has been plowed. */
        if (this.tile.isPlowed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method allows the player to use the watering can
     * and deducts its cost and experience gain in his/her assets.
     */

    public void waterTile() {
        WateringCan water = new WateringCan();
        water.useTool(amount, level);
        tile.updateWaterStatus(true);
        /* If there is a crop planted in the tile, update water count. */
        if (tile.isPlanted()) {
            this.tile.identifyCropinTile().updateWaterLimit(waterLimitIncrease);
            this.tile.identifyCropinTile().updateWaterCount();
        }

    }

    /**
     * This method identifies if the player is allowed to fertilize a tile.
     * 
     * @return true if fertilizing of tile is allowed
     *         false if fertilizing of tile is not allowed
     */

    public boolean fertilizerAllowed() {
        /* Fertilizer tool can only be used once tile has been plowed. */
        if (this.tile.isPlowed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method allows the player to use the fertilizing tool
     * and deducts its cost and experience gain in his/her assets.
     */

    public void fertilizeTile() {
        Fertilizer fertilize = new Fertilizer();
        fertilize.useTool(amount, level);
        tile.updateFertilizerStatus(true);
        /* If there is a crop planted in the tile, update fertilizer count. */
        if (tile.isPlanted()) {
            this.tile.identifyCropinTile().updateFertilizerLimit(fertilizerLimitIncrease);
            this.tile.identifyCropinTile().updateFertilizerCount();
        }
    }

    /**
     * This method identifies if the player is allowed to shovel a crop.
     * 
     * @return true if use of shovel is allowed
     *         false if use of shovel is not allowed
     */

    public boolean isShovelAllowed() {
        /* Shovel can only be used on withered or living crops. */
        if (this.tile.isWithered() || this.tile.isPlanted()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method allows the player to use the shovel tool
     * and deducts its cost and experience gain in his/her assets.
     */

    public void weedOutCrop() {
        Shovel shovel = new Shovel();
        shovel.useTool(amount, level);
        tile.updatePlantedStatus(false);
        tile.updatePlowed(false);
        tile.updateWithered(false);
    }

    /**
     * This method identifies if the player is allowed to pickaxe a rock.
     * 
     * @return true if use of pickaxe is allowed
     *         false if use of pickaxe is not allowed
     */

    public boolean isPickAxeAllowed() {
        /* Pickaxe can only be used if there is a rock on the tile */
        if (this.tile.isRockThere()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method allows the player to use the pickaxe tool
     * and deducts its cost and experience gain in his/her assets.
     */

    public void removedRock() {
        Pickaxe pickaxe = new Pickaxe();
        pickaxe.useTool(amount, level);
        tile.updateRockStatus(false);

    }

    /**
     * This method identifies if the player is allowed to buy
     * or plant a seed on the designated tile.
     * 
     * @return true if buying or planting of seed is allowed
     *         false if buying or planting of seed is not allowed
     */

    public boolean buyAllowed() {
        /*
         * Planting of seed is only allowed once a tile is plowed and does not
         * have any other crop planted.
         */
        if (this.tile.isPlowed() && this.tile.isPlanted() == false) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method identifies if the player is allowed to buy or plant
     * a fruit tree crop on a designated tile.
     * 
     * @return true if the player is allowed to buy a fruit tree
     *         or if player is not buying a fruit tree
     *         false if the player is not allowed to buy a fruit tree
     */

    public boolean checkSides() {
        if (this.tile.identifyCropinTile().getCropType().equals("Fruit Tree")) {
            /*
             * Checks if assigned tile for planting is on the first column of the farm lot
             */
            if (this.tile.getIndex() % 10 == 0) {
                return false;

                /* Checks if assigned tile for planting is on the last column of the farm lot */
            } else if (this.tile.getIndex() % 10 == 9) {
                return false;

                /* Checks if assigned tile for planting is on the first row of the farm lot */
            } else if (this.tile.getIndex() >= 0 && this.tile.getIndex() <= 9) {
                return false;

                /* Checks if assigned tile for planting is on the last row of the farm lot */
            } else if (this.tile.getIndex() >= 39 && this.tile.getIndex() <= 49) {
                return false;
            } else {
                return true;
            }

        } else {
            return true;
        }
    }

    /**
     * This method checks adjacent sides of the assigned tile and identifies
     * if a seed can be planted.
     * 
     * @return true if seed can be planted
     *         false if seed cannot be planted
     */

    public boolean checkadjacent() {

        /*
         * Planting of fruit tree is only allowed if its adjacent sides does not
         * have any crop planted and does not have any rocks in it.
         */
        if (this.tile.identifyCropinTile().getCropType().equals("Fruit Tree")) {
            if (this.land.getTile(this.tile.getIndex() - 10).isPlanted()
                    || this.land.getTile(this.tile.getIndex() - 10).isRockThere()) {
                return false;
            } else if (this.land.getTile(this.tile.getIndex() + 10).isPlanted()
                    || this.land.getTile(this.tile.getIndex() + 10).isRockThere()) {
                return false;
            } else if (this.land.getTile(this.tile.getIndex() + 1).isPlanted()
                    || this.land.getTile(this.tile.getIndex() + 1).isRockThere()) {
                return false;
            } else if (this.land.getTile(this.tile.getIndex() - 1).isPlanted()
                    || this.land.getTile(this.tile.getIndex() - 1).isRockThere()) {
                return false;
            } else {
                return true;
            }
        } else {
            /*
             * Planting of any other seed aside from fruit tree
             * is only allowed if it is planted on the sides of the farm lot and
             * if its adjacent sides do not contain any fruit tree crops.
             */
            if (this.tile.getIndex() % 10 == 0 || this.tile.getIndex() % 10 == 9
                    || this.tile.getIndex() >= 0 && this.tile.getIndex() <= 9
                    || this.tile.getIndex() >= 39 && this.tile.getIndex() <= 49) {
                if (this.tile.getIndex() % 10 == 0 && this.tile.getIndex() / 10 >= 1
                        && this.tile.getIndex() / 10 <= 8) {
                    if (this.land.getTile(this.tile.getIndex() + 1).identifyCropinTile() instanceof Mango ||
                            this.land.getTile(this.tile.getIndex() + 1).identifyCropinTile() instanceof Apple) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (this.tile.getIndex() % 10 == 9 && this.tile.getIndex() / 10 >= 1
                        && this.tile.getIndex() / 10 <= 8) {
                    if (this.land.getTile(this.tile.getIndex() - 1).identifyCropinTile() instanceof Mango ||
                            this.land.getTile(this.tile.getIndex() - 1).identifyCropinTile() instanceof Apple) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (this.tile.getIndex() >= 1 && this.tile.getIndex() <= 8) {
                    if (this.land.getTile(this.tile.getIndex() + 10).identifyCropinTile() instanceof Mango ||
                            this.land.getTile(this.tile.getIndex() + 10).identifyCropinTile() instanceof Apple) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (this.tile.getIndex() >= 40 && this.tile.getIndex() <= 48) {
                    if (this.land.getTile(this.tile.getIndex() - 10).identifyCropinTile() instanceof Mango ||
                            this.land.getTile(this.tile.getIndex() - 10).identifyCropinTile() instanceof Apple) {
                        return false;
                    } else {
                        return true;
                    }

                } else {
                    return true;
                }
            }

            else if (this.land.getTile(this.tile.getIndex() - 10).identifyCropinTile() instanceof Mango ||
                    this.land.getTile(this.tile.getIndex() - 10).identifyCropinTile() instanceof Apple) {
                return false;
            } else if (this.land.getTile(this.tile.getIndex() + 10).identifyCropinTile() instanceof Mango ||
                    this.land.getTile(this.tile.getIndex() + 10).identifyCropinTile() instanceof Apple) {
                return false;
            } else if (this.land.getTile(this.tile.getIndex() - 1).identifyCropinTile() instanceof Mango ||
                    this.land.getTile(this.tile.getIndex() - 1).identifyCropinTile() instanceof Apple) {
                return false;
            } else if (this.land.getTile(this.tile.getIndex() + 1).identifyCropinTile() instanceof Mango ||
                    this.land.getTile(this.tile.getIndex() + 1).identifyCropinTile() instanceof Apple) {
                return false;
            } else {
                return true;
            }
        }

    }

    /**
     * This method allows the player to buy seeds of his/her chosen crop/
     * 
     * @param crop seed that player bought
     * @return true if buying of seed is successful
     *         false if buying of seed is not successful
     */

    public boolean buySeeds(Crop crop) {

        tile.storeCropinTile(crop);
        /*
         * Buying of seed is only allowed if the player has enough money to buy,
         * all adjacent sides and farm lot border sides have been checked.
         */
        if (this.tile.identifyCropinTile().getSeedCost() - this.costReduction <= amount.getObjectCoin()) {
            if (checkSides()) {
                if (checkadjacent()) {
                    this.amount.loseObjectCoin((this.tile.identifyCropinTile()).getSeedCost() - this.costReduction);
                    this.level.updateXP(this.tile.identifyCropinTile().getExpGained());
                    this.level.determineLevel();
                    this.tile.updatePlantedStatus(true);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * This method identifies if harvesting a crop is allowed.
     * 
     * @return true if harvest is allowed
     *         false if harvest is not allowed.
     */

    public boolean harvestAllowed() {
        /*
         * Harvesting is only allowed if the crop has reached it minimum
         * water, fertilizer and harvest day requirements.
         */
        if (this.tile.identifyCropinTile().reachedWaterMin() == true &&
                this.tile.identifyCropinTile().reachedFertilizerMin() == true &&
                (this.tile.getDayPlanted() +
                        this.tile.identifyCropinTile().getHarvestTime()) == this.day) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method allows the player to harvest
     * the crop of a designated tile.
     */

    public void harvestCrop() {
        /*
         * Compute for final harvest price with the products produces
         * and adding this to the player's assets.
         */
        double basePrice = tile.identifyCropinTile().getBasePrice();
        this.productsProduced = tile.identifyCropinTile().generateProduce();
        this.finalHarvestPrice = tile.identifyCropinTile().computeSellPrice(basePrice, productsProduced);
        level.updateXP(tile.identifyCropinTile().getExpGained());
        amount.gainObjectCoin((finalHarvestPrice + this.bonusEarning) * productsProduced);

        // intializing variables back to 0 or null
        this.tile.identifyCropinTile().setWaterCount();
        this.tile.identifyCropinTile().setFertilizerCount();
        this.tile.setDayPlanted(0);
        tile.updatePlowed(false);
        tile.updatePlantedStatus(false);
        tile.updateWithered(false);
        tile.storeCropinTile(null);
    }

    /**
     * This method updates the day count,
     * once the next day option is chosen.
     */

    public void updateDay() {
        this.day += 1;
    }

    /**
     * This method allows the player to upgrade
     * his/her farmer type.
     * 
     * @param status farmer upgrade chosen
     * @return true if upgrade is successful
     *         false if upgrade is not successful
     */

    public boolean upgradeFarmerType(String status) {
        /*
         * The player has to have enough money and
         * level requirement to successfully upgrade.
         */

        /* upgrade to Registered Farmer */
        if (status.equals("Registered") && this.getLevel() >= 5
                && amount.getObjectCoin() >= 200) {
            this.bonusEarning += 1;
            this.costReduction = this.costReduction - 1;
            this.waterLimitIncrease = 0;
            this.fertilizerLimitIncrease = 0;
            this.registrationFee = 200;
            amount.loseObjectCoin(getRegFee());
            return true;
        }

        /* upgrade to Distinguished Farmer */
        else if (status.equals("Distinguished") && this.getLevel() >= 10
                && amount.getObjectCoin() >= 300) {
            this.bonusEarning += 2;
            this.costReduction = this.costReduction - 2;
            this.waterLimitIncrease = 1;
            this.fertilizerLimitIncrease = 0;
            this.registrationFee = 300;
            amount.loseObjectCoin(getRegFee());
            return true;
        }

        /* upgrade to Legendary Farmer */
        else if (status.equals("Legendary") && this.getLevel() >= 15
                && amount.getObjectCoin() >= 400) {
            this.bonusEarning += 4;
            this.costReduction = this.costReduction - 3;
            this.waterLimitIncrease = 2;
            this.fertilizerLimitIncrease = 1;
            this.registrationFee = 400;
            amount.loseObjectCoin(getRegFee());
            return true;

        } else {
            System.out.println("Upgrade Farmer Type has failed!");
            return false;
        }
    }
}
