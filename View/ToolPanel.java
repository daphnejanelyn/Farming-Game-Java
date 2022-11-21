package View;

import javax.swing.*;
import java.awt.*;

public class ToolPanel extends JPanel {

    private JButton plow = new JButton("Plow");
    private JButton water = new JButton("Water");
    private JButton fertilizer = new JButton("Fertilizer");
    private JButton shovel = new JButton("Shovel");
    private JButton pickaxe = new JButton("Pickaxe");

    public ToolPanel() {
        this.setLayout(new GridLayout(6, 1));
        this.setBackground(new Color(0xA4BE7B));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(160, 300));
        init();
        addButtons();
        this.setVisible(true);

    }

    private void init() {
        JLabel tool = new JLabel("Tools");
        // LABEL ALIGNMENTS
        tool.setForeground(Color.WHITE);
        tool.setFont(new Font("Google Sans", Font.BOLD, 15));
        tool.setVerticalAlignment(JLabel.CENTER);
        tool.setHorizontalAlignment(JLabel.CENTER);
        this.add(tool);
    }

    private void addButtons() {
        /* Plowing Alignment */
        plow.setFocusable(false); // remove a border around the text
        plow.setSize(150, 50);
        plow.setHorizontalAlignment(JButton.CENTER);
        plow.setFont(new Font("Google Sans", Font.BOLD, 11));

        /* Water Alignment */
        water.setFocusable(false); // remove a border around the text
        water.setSize(150, 50);
        water.setHorizontalAlignment(JButton.CENTER);
        water.setFont(new Font("Google Sans", Font.BOLD, 11));

        /* Fertilizer Alignment */
        fertilizer.setFocusable(false); // remove a border around the text
        fertilizer.setSize(150, 50);
        fertilizer.setHorizontalAlignment(JButton.CENTER);
        fertilizer.setFont(new Font("Google Sans", Font.BOLD, 11));

        /* Shovel Alignment */
        shovel.setFocusable(false); // remove a border around the text
        shovel.setSize(150, 50);
        shovel.setHorizontalAlignment(JButton.CENTER);
        shovel.setFont(new Font("Google Sans", Font.BOLD, 11));

        /* PickAxe Alignment */
        pickaxe.setFocusable(false); // remove a border around the text
        pickaxe.setSize(150, 50);
        pickaxe.setHorizontalAlignment(JButton.CENTER);
        pickaxe.setFont(new Font("Google Sans", Font.BOLD, 11));

        // add buttons to Tool Panel
        this.add(plow);
        this.add(water);
        this.add(fertilizer);
        this.add(shovel);
        this.add(pickaxe);

    }

}
