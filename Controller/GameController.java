package Controller;

import View.*;
import Model.*;
import Model.Crops.*;

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
        }

        if (e.getActionCommand().equals("Plow")) {
            int currIndex = player.determineTile();
            player.plowTile();
            gui.updateView("plowed", currIndex);
            gui.updateAccessoryStatus(player.getObjectCoin(), player.getXP(), player.getLevel(), player.getDay());
        }
        if (e.getActionCommand().equals("Turnip")) {
            // buy and plant turnip seed
            Turnip tempTurnip = new Turnip("Turnip", "Root Crop");
            player.buySeeds(tempTurnip);
            // update view of tile to turnip seed
        }

        if (e.getActionCommand().equals("Carrot")) {
            // buy and plant turnip seed
            Carrot temp = new Carrot("Carrot", "Root Crop");
            player.buySeeds(temp);
            // update view of tile to carrot seed
        }

        if (e.getActionCommand().equals("Potato")) {
            // buy and plant turnip seed
            Potato temp = new Potato("Potato", "Root Crop");
            player.buySeeds(temp);
            // update view of tile to potato seed
        }
        if (e.getActionCommand().equals("Rose")) {
            // buy and plant turnip seed
            Rose temp = new Rose("Rose", "Flower");
            player.buySeeds(temp);
            // update view of tile to rose seed
        }

        if (e.getActionCommand().equals("Tulip")) {
            // buy and plant turnip seed
            Tulip temp = new Tulip("Tulip", "Flower");
            player.buySeeds(temp);
            // update view of tile to tulip seed
        }

        if (e.getActionCommand().equals("Sunflower")) {
            // buy and plant turnip seed
            Sunflower temp = new Sunflower("Sunflower", "Flower");
            player.buySeeds(temp);
            // update view of tile to sunflower seed
        }

        if (e.getActionCommand().equals("Mango")) {
            // buy and plant turnip seed
            Mango temp = new Mango("Mango", "Fruit Tree");
            player.buySeeds(temp);
            // update view of tile to mango seed
        }

        if (e.getActionCommand().equals("Apple")) {
            // buy and plant turnip seed
            Apple temp = new Apple("Apple", "Fruit Tree");
            player.buySeeds(temp);
            // update view of tile to apple seed
        }

        if (e.getActionCommand().equals("Harvest")) {
            // harvest the crop
        }

    }

}
