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
        JButton tempButton = (JButton) e.getSource();
        if (e.getActionCommand().equals("Plow")) {

        }

    }

}
