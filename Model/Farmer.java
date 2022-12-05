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

    public Farmer(String name) {
        this.name = name;
        this.plantList = new ArrayList<Crop>();
        this.level = new Level();
        this.amount = new ObjectCoin();
        this.tile = new Farmtile();
        this.land = new Farm();
    }

    /* Tile the farmer is navigating */
    public void assignTile(int tileClicked) {
        // land.setIndexTiles();
        // land.loadMap();
        // need to get Tile itself from Farm
        this.tileIndex = tileClicked;
        this.tile = land.getTile(tileIndex);
    }

    public ArrayList<Farmtile> getAllTiles() {
        return this.land.getTileList();
    }

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

    public int determineTile() {
        return this.tileIndex;
    }

    public String getName() {
        return this.name;
    }

    public int getDay() {
        return this.day;
    }

    public double getObjectCoin() {
        return this.amount.getObjectCoin();
    }

    public int getLevel() {
        this.level.determineLevel();
        return this.level.getLevel();
    }

    public double getXP() {
        return this.level.getXP();
    }

    public int getminHarvestTime() {
        return this.minDayHarvest;
    }

    public double getRegFee() {
        return this.registrationFee;
    }

    public Farmtile getTile() {
        return this.tile;
    }

    public void addCrop(Crop crop) {
        this.plantList.add(crop);
    }

    public ArrayList<Crop> getCrop() {
        return this.plantList;
    }

    public void nextDay() {
        this.day += 1;
    }

    public boolean plowedAllow() {
        if (this.tile.isPlowed() == false && this.tile.isPlanted() == false && this.tile.isRockThere() == false) {
            return true;
        } else if (this.tile.isRockThere() == true) {
            return false;
        } else {
            return false;
        }
    }

    // for tools
    public void plowTile() {
        Plow plow = new Plow();
        plow.useTool(amount, level);
        this.tile.updatePlowed(true);
    }

    public boolean waterAllowed() {
        if (this.tile.isPlowed()) {
            return true;
        } else {
            return false;
        }
    }

    public void waterTile() {
        WateringCan water = new WateringCan();
        water.useTool(amount, level);
        tile.updateWaterStatus(true);
        if (tile.isPlanted()) {
            this.tile.identifyCropinTile().updateWaterLimit(waterLimitIncrease);
            this.tile.identifyCropinTile().updateWaterCount();
        }

    }

    public boolean fertilizerAllowed() {
        if (this.tile.isPlowed()) {
            return true;
        } else {
            return false;
        }
    }

    public void fertilizeTile() {
        Fertilizer fertilize = new Fertilizer();
        fertilize.useTool(amount, level);
        tile.updateFertilizerStatus(true);
        if (tile.isPlanted()) {
            this.tile.identifyCropinTile().updateFertilizerLimit(fertilizerLimitIncrease);
            this.tile.identifyCropinTile().updateFertilizerCount();
        }
    }

    public void weedOutCrop() {
        Shovel shovel = new Shovel();
        shovel.useTool(amount, level);
        tile.updatePlantedStatus(false);
        tile.updatePlowed(false);
        tile.updateWithered(false);
    }

    public boolean isShovelAllowed() {
        if (this.tile.isWithered() || this.tile.isPlanted()) {
            return true;
        } else {
            return false;
        }
    }

    public void removedRock() {
        Pickaxe pickaxe = new Pickaxe();
        pickaxe.useTool(amount, level);
        tile.updateRockStatus(false);

    }

    public boolean isPickAxeAllowed() {
        if (this.tile.isRockThere()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean buyAllowed() {
        if (this.tile.isPlowed() && this.tile.isPlanted() == false) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSides() {
        if (this.tile.identifyCropinTile().getCropType().equals("Fruit Tree")) {
            if (this.tile.getIndex() % 10 == 0) {
                return false;
            } else if (this.tile.getIndex() % 10 == 9) {
                return false;
            } else if (this.tile.getIndex() >= 0 && this.tile.getIndex() <= 9) {
                return false;

            } else if (this.tile.getIndex() >= 39 && this.tile.getIndex() <= 49) {
                return false;
            } else {
                return true;
            }

        } else {
            return true;
        }
    }

    public boolean checkadjacent() {
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
            if (this.tile.getIndex() % 10 == 0 || this.tile.getIndex() % 10 == 9
                    || this.tile.getIndex() >= 0 && this.tile.getIndex() <= 9
                    || this.tile.getIndex() >= 39 && this.tile.getIndex() <= 49) {
                return true;
            }
            if (this.land.getTile(this.tile.getIndex() - 10).identifyCropinTile() instanceof Mango ||
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

    public boolean buySeeds(Crop crop) {
        // crop

        tile.storeCropinTile(crop);
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

    public boolean harvestAllowed() {
        if (this.tile.identifyCropinTile().reachedWaterMin() == true &&
                this.tile.identifyCropinTile().reachedFertilizerMin() == true &&
                (this.tile.getDayPlanted() +
                        this.tile.identifyCropinTile().getHarvestTime()) == this.day) {
            return true;
        } else {
            return false;
        }
    }

    public void harvestCrop() {
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

    public void updateDay() {
        this.day += 1;
    }

    public int getProductsProduced() {
        return this.productsProduced;
    }

    public double getFinalHarvestPrice() {
        return this.finalHarvestPrice;
    }

    public boolean upgradeFarmerType(String status) {
        /* upgrade to Registered Farmer */
        if (status.equals("Registered") && this.getLevel() >= 5
                && amount.getObjectCoin() >= 200) {
            this.bonusEarning += 1;
            this.costReduction = this.costReduction - 1;
            this.waterLimitIncrease = 0;
            this.fertilizerLimitIncrease = 0;
            this.registrationFee = 200;
            amount.loseObjectCoin(getRegFee());
            // System.out.println("Successfully upgraded to Registered Farmer!");
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
            // System.out.println("Successfully upgraded to Distinguished Farmer!");
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
            // System.out.println("Successfully upgraded to Legendary Farmer!");
            return true;

        } else {
            System.out.println("Upgrade Farmer Type has failed!");
            return false;
        }
    }
}
