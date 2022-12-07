package Controller;

import View.*;
import Model.*;
import Model.Crops.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

    private MainFrameView gui;
    private Farmer player;
    Sound music = new Sound();

    public GameController(MainFrameView gui, Farmer player) {
        this.gui = gui;
        this.player = player;
        /* assigns a different view depending on rock placement on tiles */
        assignView();
        /* checks if the game has satisfied conditions for termination */
        checkEndGame();
        /* plays music while game is ongoing */
        playMusic();
        /* sets action listeners for every button */
        gui.setActionListener(this);
    }

    /* Sets the music background for the game play */
    public void playMusic() {
        music.setFile(0);
        music.play();
        music.loop();
    }

    /*
     * Method for all action listeners for
     * each button in the program
     */

    @Override
    public void actionPerformed(ActionEvent e) {

        music.setFile(1);
        music.play();

        /* Action performed when a farm tile is clicked */

        if (e.getSource() instanceof TileView) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                int index = gui.getTileIndex((TileView) e.getSource());
                player.assignTile(index);
                gui.hidePrompt();
            }
        }

        /* Action performed when a plow button is clicked */

        else if (e.getActionCommand().equals("Plow")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                int currIndex = player.determineTile();
                if (player.plowedAllow()) {
                    player.plowTile();
                    gui.updateView("plowed", currIndex);
                    gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(), player.getLevel(),
                            player.getDay());

                } else {
                    gui.displayPrompt("Plow Failed");
                }

            }

        }
        /* Action performed when a watering can button is clicked */
        if (e.getActionCommand().equals("Water"))

        {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // Display the prompt indicating a tile has been watered
                if (player.waterAllowed()) {
                    player.waterTile();
                    gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                            player.getLevel(), player.getDay());
                    gui.displayPrompt("Watered");
                } else {
                    gui.displayPrompt("Failed Watered");
                }
            }
        }

        /* Action performed when a fertilizer tool button is clicked */

        if (e.getActionCommand().equals("Fertilizer")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                // Display prompt indicating a tile has been fertilized
                if (player.fertilizerAllowed()) {
                    player.fertilizeTile();
                    gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                            player.getLevel(), player.getDay());
                    gui.displayPrompt("Fertilized");
                } else {
                    gui.displayPrompt("Failed Fertilized");
                }
            }
        }
        /* Action performed when a shovel tool button is clicked */
        if (e.getActionCommand().equals("Shovel")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                // Display prompt indicating a plant has been removed
                int currIndex = player.determineTile();
                if (player.isShovelAllowed()) {
                    gui.updateView("unplowed", currIndex);
                    player.weedOutCrop();
                    gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                            player.getLevel(), player.getDay());
                    gui.displayPrompt("Shovel Success");
                } else {
                    gui.displayPrompt("Shovel Failed");
                }
            }
        }
        /* Action performed when pickaxe tool button is clicked */
        if (e.getActionCommand().equals("PickAxe")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                /* Display prompt indicating a rock has been removed */
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

        /* Action performed when next day button is clicked */

        if (e.getActionCommand().equals("Proceed to Next Day")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                int dayPlanted;
                int currentDay;
                int dayofHarvest;
                gui.hidePrompt();
                player.updateDay();
                // Check status of plants if they are withered or not
                this.checkIfWithered();
                gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(),
                        player.getLevel(), player.getDay());

                /*
                 * Update all tile views according to set conditions
                 * of crops once player proceeds to next day.
                 */
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

        /* Action performed when Turnip seed button is clicked */
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

                        // If seed bought failed, display prompt.
                    } else {
                        gui.displayPrompt("Buy Failed");
                    }

                } else {
                    gui.displayPrompt("Buy Failed");
                }

            }

        }

        /* Action performed when the carrot seedd button is clicked */

        if (e.getActionCommand().equals("Carrot")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {
                // buy and plant carrot seed
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

                    // If seed bought failed, display prompt.
                } else {
                    gui.displayPrompt("Buy Failed");
                }

            }
        }

        /* Action performed when potato seed button is clicked */

        if (e.getActionCommand().equals("Potato")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant potato seed
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

                    // If seed bought failed, display prompt.
                } else {
                    gui.displayPrompt("Buy Failed");
                }
            }
        }
        /* Action performed when rose seed button is clicked */
        if (e.getActionCommand().equals("Rose")) {
            if (checkEndGame()) {
                gui.getEndGameView();

            } else {
                // buy and plant rose seed
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
                    // If seed bought failed, display prompt.
                } else {
                    gui.displayPrompt("Buy Failed");
                }
            }
        }

        /* Action performed when tulip seed button is clicked */

        if (e.getActionCommand().equals("Tulip")) {
            if (checkEndGame()) {
                gui.getEndGameView();

            } else {

                // buy and plant tulip seed
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
                    // If seed bought failed, display prompt.
                } else {
                    gui.displayPrompt("Buy Failed");
                }
            }
        }

        /* Action performed when sunflower seed button is clicked */

        if (e.getActionCommand().equals("Sunflower")) {
            if (checkEndGame()) {
                gui.getEndGameView();
            } else {

                // buy and plant sunflower seed
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
                    // If seed bought failed, display prompt.
                } else {
                    gui.displayPrompt("Buy Failed");
                }
            }

        }

        /* Action performed when mango seed button is clicked */

        if (e.getActionCommand().equals("Mango")) {
            if (checkEndGame()) {
                gui.getEndGameView();

            } else {
                // buy and plant mango seed
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
                    // If seed bought failed, display prompt.
                } else {
                    gui.displayPrompt("Buy Failed");
                }
            }
        }

        /* Action performed when apple seed button is clicked */
        if (e.getActionCommand().equals("Apple")) {
            if (checkEndGame()) {
                gui.getEndGameView();

            } else {
                // buy and plant apple seed
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
                    // If seed bought failed, display prompt.
                } else {
                    gui.displayPrompt("Buy Failed");
                }
            }
        }

        /* Action performed when harvest button is clicked */

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
                    gui.displayPrompt("Harvest Failed");
            }
        }

        /* Upgrade Buttons */

        /* Action Performed when player chooses to upgrade to a registered farmer */
        if (e.getActionCommand().equals("Registered Farmer")) {
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

        /* Action Performed when player chooses to upgrade to a distinguished farmer */
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

        /* Action Performed when player chooses to upgrade to a legendary farmer */
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

    /*
     * This method checks if the planted crop in all tiles
     * in the farm lot is withered.
     */

    private void checkIfWithered() {
        int dayPlanted;
        int currentDay;
        int dayofHarvest;

        /* Iterate through all farm tiles and check status */
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

    /*
     * This method assigns view depending on whether
     * a rock is identified with the tile.
     */

    private void assignView() {
        for (int i = 0; i < 50; i++) {
            if (player.getAllTiles().get(i).isRockThere()) {
                gui.assignView("rocked", i);
            } else {
                gui.assignView("unplowed", i);
            }
        }
    }

    /* This method checks if game should be terminated */

    private boolean checkEndGame() {
        boolean found = false;
        /* Insufficient balance in object coins */
        if (player.getObjectCoin() < 5) {
            return true;

            /* All farm tiles contain withered crops */
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
