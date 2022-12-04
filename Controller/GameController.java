package Controller;

import View.*;
import Model.*;
import Model.Crops.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private MainFrameView gui;
    private Farmer player;

    public GameController(MainFrameView gui, Farmer player) {
        this.gui = gui;
        this.player = player;
        assignView();
        checkEndGame();
        gui.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof TileView) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                int index = gui.getTileIndex((TileView) e.getSource());
                player.assignTile(index);
                gui.hidePrompt();
            }
        }

        // tools

        else if (e.getActionCommand().equals("Plow")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                if (player.plowedAllow() == true) {
                    int currIndex = player.determineTile();
                    player.plowTile();
                    gui.updateView("plowed", currIndex);
                    gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(), player.getLevel(),
                            player.getDay());
                    gui.displayPrompt("Plowed");
                } else if (player.plowedAllow() == false) {
                    gui.displayPrompt("Failed Plow");
                }

            }

        }

        if (e.getActionCommand().equals("Water"))

        {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

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
        }

        if (e.getActionCommand().equals("Fertilizer")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

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
        }

        if (e.getActionCommand().equals("Shovel")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

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
        }

        if (e.getActionCommand().equals("PickAxe")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                int currIndex = player.determineTile();

                if (player.isPickAxeAllowed()) {
                    gui.updateView("unplowed", currIndex);
                    player.removedRock();
                    gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                            player.getLevel(), player.getDay());
                } else {
                    // display prompt
                    gui.displayPrompt("PickAxe Failed");
                }
            }

        }

        // add button for next day

        if (e.getActionCommand().equals("Proceed to Next Day")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

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
                        if (player.getAllTiles().get(i).isPlanted()
                                && player.getAllTiles().get(i).isWithered() == false) {
                            gui.updateViewtoPlant(player.determineCrop(i), i, dayPlanted, currentDay, dayofHarvest);
                        } else if (player.getAllTiles().get(i).isPlanted()
                                && player.getAllTiles().get(i).isWithered()) {
                            gui.updateView("withered", i);
                        }
                    }
                }
            }
        }

        // seeds
        if (e.getActionCommand().equals("Turnip")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                if (player.buyAllowed()) {
                    // buy and plant turnip seed
                    Turnip tempTurnip = new Turnip("Turnip", "Root Crop");
                    if (player.buySeeds(tempTurnip)) {

                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());

                        gui.updateViewtoPlant("Turnip", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
                    } else {
                        gui.displayPrompt("Buy Failed");
                    }

                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    // gui.hidePrompt();
                }

            }

        }

        if (e.getActionCommand().equals("Carrot")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                // buy and plant turnip seed
                if (player.buyAllowed()) {
                    Carrot temp = new Carrot("Carrot", "Root Crop");
                    if (player.buySeeds(temp)) {
                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());
                        // update view of tile to carrot seed
                        gui.updateViewtoPlant("Carrot", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());

                    } else {
                        gui.displayPrompt("Buy Failed");
                    }
                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    // gui.hidePrompt();
                }

            }
        }

        if (e.getActionCommand().equals("Potato")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant turnip seed
                if (player.buyAllowed()) {
                    Potato temp = new Potato("Potato", "Root Crop");
                    if (player.buySeeds(temp)) {
                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());
                        // update view of tile to potato seed
                        gui.updateViewtoPlant("Potato", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
                    } else {
                        gui.displayPrompt("Buy Failed");
                    }
                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    // gui.hidePrompt();
                }
            }
        }
        if (e.getActionCommand().equals("Rose")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant turnip seed
                if (player.buyAllowed()) {
                    Rose temp = new Rose("Rose", "Flower");
                    if (player.buySeeds(temp)) {
                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());
                        // update view of tile to rose seed
                        gui.updateViewtoPlant("Rose", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());

                    } else {
                        gui.displayPrompt("Buy Failed");
                    }
                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    // gui.hidePrompt();
                }
            }
        }

        if (e.getActionCommand().equals("Tulip")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant turnip seed
                if (player.buyAllowed()) {
                    Tulip temp = new Tulip("Tulip", "Flower");
                    if (player.buySeeds(temp)) {

                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());
                        // update view of tile to tulip seed
                        gui.updateViewtoPlant("Tulip", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
                    } else {
                        gui.displayPrompt("Buy Failed");
                    }

                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    gui.hidePrompt();
                }
            }
        }

        if (e.getActionCommand().equals("Sunflower")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant seed
                if (player.buyAllowed()) {
                    Sunflower temp = new Sunflower("Sunflower", "Flower");
                    if (player.buySeeds(temp)) {

                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());
                        // update view of tile to sunflower seed
                        gui.updateViewtoPlant("Sunflower", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
                    } else {
                        gui.displayPrompt("Buy Failed");
                    }
                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    // gui.hidePrompt();
                }
            }

        }

        if (e.getActionCommand().equals("Mango")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant seed
                if (player.buyAllowed()) {
                    Mango temp = new Mango("Mango", "Fruit Tree");
                    if (player.buySeeds(temp)) {

                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());
                        // update view of tile to mango seed
                        gui.updateViewtoPlant("Mango", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
                    } else {
                        gui.displayPrompt("Buy Failed");
                    }
                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    // gui.hidePrompt();
                }
            }
        }

        if (e.getActionCommand().equals("Apple")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant seed
                if (player.buyAllowed()) {
                    Apple temp = new Apple("Apple", "Fruit Tree");
                    if (player.buySeeds(temp)) {

                        player.getTile().setDayPlanted(player.getDay());
                        gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                                player.getLevel(), player.getDay());
                        // update view of tile to apple seed
                        gui.updateViewtoPlant("Apple", player.determineTile(), player.getTile().getDayPlanted(),
                                player.getDay(),
                                player.getDay() + player.getTile().identifyCropinTile().getHarvestTime());
                    } else {
                        gui.displayPrompt("Buy Failed");
                    }
                } else {
                    // display prompt
                    gui.displayPrompt("Buy Failed");
                    // gui.hidePrompt();
                }
            }
        }

        if (e.getActionCommand().equals("Harvest")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // harvest the crop
                int currIndex = player.determineTile();
                if (player.harvestAllowed()) {
                    gui.updateView("unplowed", currIndex);
                    player.harvestCrop();
                    gui.displayHarvestPrompt(player.getProductsProduced(), player.getFinalHarvestPrice());
                    gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                            player.getLevel(), player.getDay());
                } else
                    // display prompt
                    gui.displayPrompt("Harvest Failed");
                // gui.hidePrompt();
            }
        }

        // upgrade buttons
        if (e.getActionCommand().equals("Registered Farmer"))

        {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                if (player.upgradeFarmerType("Registered")) {
                    gui.displayPrompt("Registered Farmer Success");
                } else {
                    gui.displayPrompt("Registered Farmer Failed");
                }
            }
        }

        if (e.getActionCommand().equals("Distinguished Farmer")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                if (player.upgradeFarmerType("Distinguished")) {
                    gui.displayPrompt("Distinguished Farmer Success");
                } else {
                    gui.displayPrompt("Distinguished Farmer Failed");
                }
            }
        }

        if (e.getActionCommand().equals("Legendary Farmer")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                if (player.upgradeFarmerType("Legendary")) {
                    gui.displayPrompt("Legendary Farmer Success");
                } else {
                    gui.displayPrompt("Legendary Farmer Failed");
                }
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

    private void assignView() {
        for (int i = 0; i < 50; i++) {
            if (player.getAllTiles().get(i).isRockThere()) {
                gui.assignView("rocked", i);
            } else {
                gui.assignView("unplowed", i);
            }
        }
    }

    private boolean checkEndGame() {
        boolean found = false;
        if (player.getObjectCoin() < 5) {
            return true;
        } else if (player.getObjectCoin() >= 5) {
            for (int i = 0; i < 50; i++) {
                if (player.getAllTiles().get(i).isWithered() == false) {
                    found = true;
                }
            }
            if (found) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
