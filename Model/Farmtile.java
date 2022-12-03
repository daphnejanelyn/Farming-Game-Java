package Model;

import Model.Crops.*;

public class Farmtile {

    private int index;
    private Crop cropInTile;
    private boolean plowed = false;
    private boolean planted = false;
    private boolean watered = false;
    private boolean fertilized = false;
    private boolean harvested = false;
    private boolean withered = false;
    private boolean cleaned;
    private int day = 0;

    public Farmtile() {

    }

    public void setIndexperTile(int init) {
        this.index = init;
    }

    public int getIndex() {
        return this.index;
    }

    // add a method that identifies which crop is planted

    /**
     * This method updates the status of tile to plowed.
     * 
     * @param plowUsed indicator if plowing tool is used
     */

    public void updatePlowed(boolean plowUsed) {
        if (plowUsed) {
            plowed = true;
        } else {
            plowed = false;
        }
    }

    /**
     * This method updates the status of tile to watered.
     * 
     * @param wateringCanUsed indicator if watering can is used
     */

    public void updateWaterStatus(boolean wateringCanUsed) {
        if (wateringCanUsed == true) {
            watered = true;
        } else {
            watered = false;
        }
    }

    /**
     * This method updates whether or not the rock in the tile is removed.
     * 
     * @param removedRock indicator if pickaxe is used
     */

    public void updateRockStatus(boolean removedRock) {
        if (removedRock == true) {
            this.cleaned = true;
        } else {
            this.cleaned = false;
        }
    }

    /**
     * This method updates the status of tile to fertilized.
     * 
     * @param fertilizerUsed indicator if fertilizer is used
     */

    public void updateFertilizerStatus(boolean fertilizerUsed) {
        if (fertilizerUsed == true) {
            fertilized = true;
        } else {
            fertilized = false;
        }
    }

    /**
     * This method updates the status of tile to planted
     * 
     * @param plantedDone indicator if seed planting has succeeded
     */

    public void updatePlantedStatus(boolean plantedDone) {
        if (plantedDone == true) {
            this.planted = true;
        } else {
            this.planted = false;
        }
    }

    /**
     * This method updates the status of tile to harvested.
     * 
     * @param harvestDone indicator if seed harvesting has succeeded
     */

    public void updateHarvested(boolean harvestDone) {
        if (harvestDone == true) {
            harvestDone = true;
        }
    }

    /**
     * This method updates the status of tile to withered
     * 
     * @param witheredPlant indicator if crop has withered
     */
    public void updateWithered(boolean witheredPlant) {
        if (witheredPlant == true) {
            this.withered = true;
        }
    }

    /**
     * This method identifies if tile has been plowed
     * 
     * @return true if plowed
     *         false if not plowed
     */
    public boolean isPlowed() {
        if (plowed == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method identifies if seed has been planted into the tile.
     * 
     * @return true if planted
     *         false if not planted
     */

    public boolean isPlanted() {
        if (planted == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * This method identifies if seed or tile has been watered
     * 
     * @return true if watered
     *         false if not watered
     */

    public boolean isWatered() {
        if (watered == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method identifies if seed ot tile has been fertilized
     * 
     * @return true if fertilized
     *         false if not fertilized
     */

    public boolean isFertilized() {
        if (fertilized == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method identifies if crop has been harvested
     * 
     * @return true if harvested
     *         false if not harvested
     */

    public boolean isHarvested() {
        if (harvested == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * This method identifies if crop has withered
     * 
     * @return true if withered
     *         false if not withered
     */

    public boolean isWithered() {
        if (this.withered == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRockThere() {
        /* insert method for rocks */
        return this.cleaned;
    }

    public void storeCropinTile(Crop crop) {
        if (crop instanceof Turnip) {
            this.cropInTile = new Turnip("Turnip", "Root Crop");
        } else if (crop instanceof Carrot) {
            this.cropInTile = new Carrot("Carrot", "Root Crop");
        } else if (crop instanceof Potato) {
            this.cropInTile = new Potato("Potato", "Root Crop");
        } else if (crop instanceof Rose) {
            this.cropInTile = new Rose("Rose", "Flower");
        } else if (crop instanceof Sunflower) {
            this.cropInTile = new Sunflower("Sunflower", "Flower");
        } else if (crop instanceof Tulip) {
            this.cropInTile = new Tulip("Tulip", "Flower");
        } else if (crop instanceof Mango) {
            this.cropInTile = new Mango("Mango", "Fruit Tree");
        } else if (crop instanceof Apple) {
            this.cropInTile = new Apple("Apple", "Fruit Tree");
        } else {
            this.cropInTile = null;
        }
    }

    /*
     * method: storeCropinTile
     * 1. method = identifyCropinTile (update view: kung anong klaseng plant yung
     * ilalagay nya sa tile)
     * 2. crop: class = cropName
     * 3. identifyCropinTile (Crop crop)
     * 4. if (crop instance of Turnip
     */

    public Crop identifyCropinTile() {
        return this.cropInTile;
    }

    public void setDayPlanted(int initialday) {
        this.day = initialday;
    }

    public int getDayPlanted() {
        return this.day;
    }

}
