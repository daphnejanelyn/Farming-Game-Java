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
    private int costReduction = 0;
    private double registrationFee = 0;
    private int waterLimitIncrease = 0;
    private int fertilizerLimitIncrease = 0;

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
        land.setIndexTiles();
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
        if (this.tile.isPlowed() == false && this.tile.isPlanted() == false) {
            return true;
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
        if (this.tile.isWithered() && this.tile.isPlanted()) {
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

    public boolean buyAllowed() {
        if (this.tile.isPlowed() && this.tile.isPlanted() == false) {
            return true;
        } else {
            return false;
        }
    }

    public void buySeeds(Crop crop) {
        // crop

        tile.storeCropinTile(crop);
        if (this.tile.identifyCropinTile().getSeedCost() <= amount.getObjectCoin()) {
            this.amount.loseObjectCoin((this.tile.identifyCropinTile()).getSeedCost());
            this.level.updateXP(this.tile.identifyCropinTile().getExpGained());
            this.level.determineLevel();
            this.tile.updatePlantedStatus(true);
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
        int productsProduced = tile.identifyCropinTile().generateProduce();
        double finalHarvestPrice = tile.identifyCropinTile().computeSellPrice(basePrice, productsProduced);
        level.updateXP(tile.identifyCropinTile().getExpGained());
        amount.gainObjectCoin((finalHarvestPrice + this.bonusEarning) * productsProduced);

        // intializing variables back to 0 or null
        this.tile.identifyCropinTile().setWaterCount();
        this.tile.identifyCropinTile().setFertilizerCount();
        tile.updatePlowed(false);
        tile.updatePlantedStatus(false);
        tile.updateWithered(false);
        tile.storeCropinTile(null);
    }

    public void updateDay() {
        this.day += 1;
    }
}
