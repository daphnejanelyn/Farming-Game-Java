package Controller;

import View.*;
import Model.*;
import Model.Crops.*;
import Model.Tools.Shovel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private MainFrameView gui;
    private Farmer player;

    public GameController(MainFrameView gui, Farmer player) {
        this.gui = gui;
        this.player = player;

        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof TileView) {
            int index = gui.getTileIndex((TileView) e.getSource());
            player.assignTile(index);
            gui.hidePrompt();
        }

        // tools

        else if (e.getActionCommand().equals("Plow")) {
            int currIndex = player.determineTile();
            player.plowTile();
            gui.updateView("plowed", currIndex);
            gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(), player.getLevel(), player.getDay());
        }

        if (e.getActionCommand().equals("Water")) {
            int currIndex = player.determineTile();
            // display prompt that plant has been watered [gui]
            if (player.waterAllowed()) {
                player.waterTile();
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // display prompt
                gui.displayPrompt("Watered");
                // gui.hidePrompt();
            } else {
                // display prompt
                gui.displayPrompt("Failed Watered");
                // .hidePrompt();
            }
        }

        if (e.getActionCommand().equals("Fertilizer")) {
            int currIndex = player.determineTile();
            // display prompt that plant has been watered [gui]
            if (player.fertilizerAllowed()) {
                player.fertilizeTile();
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                gui.displayPrompt("Fertilized");
                // gui.hidePrompt();
            } else {
                // display prompt
                gui.displayPrompt("Failed Fertilized");
                // gui.hidePrompt();
            }
        }

        if (e.getActionCommand().equals("Shovel")) {
            int currIndex = player.determineTile();

            if (player.isShovelAllowed()) {
                gui.updateView("unplowed", currIndex);
                player.weedOutCrop();
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                gui.displayPrompt("Shovel Success");
            } else {
                // display prompt
                gui.displayPrompt("Shovel Failed");
            }
        }

        // add button for next day

        if (e.getActionCommand().equals("Proceed to Next Day")) {
            int dayPlanted;
            int currentDay;
            int dayofHarvest;
            gui.hidePrompt();
            player.updateDay();
            this.checkIfWithered();
            gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                    player.getLevel(), player.getDay());

            for (int i = 0; i < 50; i++) {
                dayPlanted = player.getAllTiles().get(i).getDayPlanted();
                currentDay = player.getDay();
                if (player.getAllTiles().get(i).identifyCropinTile() != null) {
                    dayofHarvest = dayPlanted + player.getAllTiles().get(i).identifyCropinTile().getHarvestTime();
                    if (player.getAllTiles().get(i).isPlanted() && player.getAllTiles().get(i).isWithered() == false) {
                        gui.updateViewtoPlant(player.determineCrop(i), i, dayPlanted, currentDay, dayofHarvest);
                    } else {
                        gui.updateView("withered", i);
                    }
                }
            }
        }

        // seeds
        if (e.getActionCommand().equals("Turnip")) {
            if (player.buyAllowed()) {
                // buy and plant turnip seed
                Turnip tempTurnip = new Turnip("Turnip", "Root Crop");
                player.buySeeds(tempTurnip);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());

                gui.updateViewtoPlant("Turnip", player.determineTile(), player.getTile().getDayPlanted(),
                        player.getDay(), player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());

            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                // gui.hidePrompt();
            }

        }

        if (e.getActionCommand().equals("Carrot")) {
            // buy and plant turnip seed
            if (player.buyAllowed()) {
                Carrot temp = new Carrot("Carrot", "Root Crop");
                player.buySeeds(temp);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // update view of tile to carrot seed
                gui.updateViewtoPlant("Carrot", player.determineTile(), player.getTile().getDayPlanted(),
                        player.getDay(), player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                // gui.hidePrompt();
            }
        }

        if (e.getActionCommand().equals("Potato")) {
            // buy and plant turnip seed
            if (player.buyAllowed()) {
                Potato temp = new Potato("Potato", "Root Crop");
                player.buySeeds(temp);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // update view of tile to potato seed
                gui.updateViewtoPlant("Potato", player.determineTile(), player.getTile().getDayPlanted(),
                        player.getDay(), player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                // gui.hidePrompt();
            }
        }
        if (e.getActionCommand().equals("Rose")) {
            // buy and plant turnip seed
            if (player.buyAllowed()) {
                Rose temp = new Rose("Rose", "Flower");
                player.buySeeds(temp);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // update view of tile to rose seed
                gui.updateViewtoPlant("Rose", player.determineTile(), player.getTile().getDayPlanted(), player.getDay(),
                        player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                // gui.hidePrompt();
            }
        }

        if (e.getActionCommand().equals("Tulip")) {
            // buy and plant turnip seed
            if (player.buyAllowed()) {
                Tulip temp = new Tulip("Tulip", "Flower");
                player.buySeeds(temp);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // update view of tile to tulip seed
                gui.updateViewtoPlant("Tulip", player.determineTile(), player.getTile().getDayPlanted(),
                        player.getDay(), player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());

            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                gui.hidePrompt();
            }
        }

        if (e.getActionCommand().equals("Sunflower")) {
            // buy and plant seed
            if (player.buyAllowed()) {
                Sunflower temp = new Sunflower("Sunflower", "Flower");
                player.buySeeds(temp);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // update view of tile to sunflower seed
                gui.updateViewtoPlant("Sunflower", player.determineTile(), player.getTile().getDayPlanted(),
                        player.getDay(), player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                // gui.hidePrompt();
            }

        }

        if (e.getActionCommand().equals("Mango")) {
            // buy and plant seed
            if (player.buyAllowed()) {
                Mango temp = new Mango("Mango", "Fruit Tree");
                player.buySeeds(temp);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // update view of tile to mango seed
                gui.updateViewtoPlant("Mango", player.determineTile(), player.getTile().getDayPlanted(),
                        player.getDay(), player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                // gui.hidePrompt();
            }
        }

        if (e.getActionCommand().equals("Apple")) {
            // buy and plant seed
            if (player.buyAllowed()) {
                Apple temp = new Apple("Apple", "Fruit Tree");
                player.buySeeds(temp);
                player.getTile().setDayPlanted(player.getDay());
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
                // update view of tile to apple seed
                gui.updateViewtoPlant("Apple", player.determineTile(), player.getTile().getDayPlanted(),
                        player.getDay(), player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
            } else {
                // display prompt
                gui.displayPrompt("Buy Failed");
                // gui.hidePrompt();
            }
        }

        if (e.getActionCommand().equals("Harvest")) {
            // harvest the crop
            int currIndex = player.determineTile();
            if (player.harvestAllowed()) {
                gui.updateView("unplowed", currIndex);
                player.harvestCrop();
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());
            } else {
                // display prompt
                gui.displayPrompt("Harvest Failed");
                // gui.hidePrompt();
            }
        }

    }

    private void checkIfWithered() {
        int dayPlanted;
        int currentDay;
        int dayofHarvest;
        for (int i = 0; i < 50; i++) {
            dayPlanted = player.getAllTiles().get(i).getDayPlanted();
            currentDay = player.getDay();
            if (player.getAllTiles().get(i).identifyCropinTile() != null) {

                dayofHarvest = player.getAllTiles().get(i).identifyCropinTile().getHarvestTime();
                if (player.getAllTiles().get(i).identifyCropinTile().reachedWaterMin() == false ||
                        player.getAllTiles().get(i).identifyCropinTile().reachedFertilizerMin() == false) {
                    if ((dayPlanted + dayofHarvest) <= currentDay) {

                        player.getAllTiles().get(i).updateWithered(true);
                    }

                } else if (player.getAllTiles().get(i).identifyCropinTile().reachedWaterMin() == true &&
                        player.getAllTiles().get(i).identifyCropinTile().reachedFertilizerMin() == true &&
                        ((dayPlanted + dayofHarvest) < currentDay)) {

                    player.getAllTiles().get(i).updateWithered(true);
                }
            }
        }
    }

}
