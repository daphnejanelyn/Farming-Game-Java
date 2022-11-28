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
    private Farm land = new Farm();

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
    }

    /* Tile the farmer is navigating */
    public void assignTile(int tileClicked) {
        this.tileIndex = tileClicked;
        // need to get Tile itself from Farm
        this.tile = land.getTile(tileClicked);
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

    public void addCrop(Crop crop) {
        this.plantList.add(crop);
    }

    public ArrayList<Crop> getCrop() {
        return this.plantList;
    }

    // for tools
    public void plowTile() {
        Plow plow = new Plow();
        plow.useTool(this.tile, amount, level);
        tile.updatePlowed(true);
    }

    public void waterTile() {
        WateringCan water = new WateringCan();
        water.useTool(this.tile, amount, level);
        tile.updateWaterStatus(true);

    }

    public void fertilizeTile() {
        Fertilizer fertilize = new Fertilizer();
        fertilize.useTool(this.tile, amount, level);
        tile.updateFertilizerStatus(true);
    }

    public void removeRock() {
        Shovel shovel = new Shovel();
        shovel.useTool(this.tile, amount, level);
        tile.updateRockStatus(false);
    }

    public void weedOutCrop() {
        Pickaxe pickaxe = new Pickaxe();
        pickaxe.useTool(this.tile, amount, level);
        tile.updatePlantedStatus(false);
        tile.updatePlowed(false);

    }

    public void buySeeds(Crop crop, Farmtile tile) {
        // crop

        tile.storeCropinTile(crop);
        this.amount.loseObjectCoin((tile.identifyCropinTile()).getSeedCost());
        this.level.updateXP(tile.identifyCropinTile().getExpGained());
        this.level.determineLevel();

    }

    // public harvestCrop(Farmtile tile){
    // tile.identifycropintile();

    // }

    public void updateDay() {
        this.day += 1;
    }
}
