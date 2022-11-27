package Controller;

import View.*;
import Model.*;

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
        // has to first get the ActionCommand of what tile it presses
        // int index = 1;
        // for (int row = 0; row < ROWS; row++) {
        // for (int col = 0; col < COLS; col++) {
        // if buttonGrid[row][col] == e.getSource();
        // // here you have your row and column
        // }
        // }
        if (e.getSource() instanceof TileView) {
            int index = gui.getTileIndex((TileView) e.getSource());
            player.assignTile(index);
        }

        if (e.getActionCommand().equals("Plow")) {
            int currIndex = player.determineTile();
            gui.updateView("plowed", currIndex);
        }

    }

}
