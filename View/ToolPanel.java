package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

public class ToolPanel extends JPanel {

    private JButton plow = new JButton("Plow");
    private JButton water = new JButton("Water");
    private JButton fertilizer = new JButton("Fertilizer");
    private JButton shovel = new JButton("Shovel");
    private JButton pickaxe = new JButton("PickAxe");
    private JButton harvest = new JButton("Harvest");

    BufferedImage plowImage;
    BufferedImage waterImage;
    BufferedImage fertilizerImage;
    BufferedImage shovelImage;
    BufferedImage pickaxeImage;
    BufferedImage harvestImage;

    public ToolPanel() {
        this.setLayout(new GridLayout(3, 1));
        this.setBackground(new Color(0xA4BE7B));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(160, 250));
        addButtons();
        this.setVisible(true);

    }

    /*
     * This method adds all initalized buttons for all tools
     * in the subpanel.
     */

    private void addButtons() {

        /* Gets the file path of tool image assets */
        try {

            plowImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/plow-tool.png"));
            waterImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/wateringCan-tool.png"));
            fertilizerImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/fertilizer-tool.png"));
            pickaxeImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/pickaxe-tool.png"));
            shovelImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/shovel-tool.png"));
            harvestImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/harvest.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Plowing Alignment */
        plow.setIcon(new ImageIcon(plowImage));
        plow.setBorder(BorderFactory.createEmptyBorder());
        plow.setContentAreaFilled(false);
        plow.setFocusable(false); // remove a border around the text
        plow.setSize(150, 50);
        plow.setHorizontalAlignment(JButton.CENTER);
        plow.setFont(new Font("Google Sans", Font.BOLD, 1));
        plow.setForeground(new Color(0xA4BE7B));

        /* Water Alignment */
        water.setIcon(new ImageIcon(waterImage));
        water.setBorder(BorderFactory.createEmptyBorder());
        water.setContentAreaFilled(false);
        water.setFocusable(false); // remove a border around the text
        water.setSize(150, 50);
        water.setHorizontalAlignment(JButton.CENTER);
        water.setFont(new Font("Google Sans", Font.BOLD, 1));
        water.setForeground(new Color(0xA4BE7B));

        /* Fertilizer Alignment */
        fertilizer.setIcon(new ImageIcon(fertilizerImage));
        fertilizer.setBorder(BorderFactory.createEmptyBorder());
        fertilizer.setContentAreaFilled(false);
        fertilizer.setFocusable(false); // remove a border around the text
        fertilizer.setSize(150, 50);
        fertilizer.setHorizontalAlignment(JButton.CENTER);
        fertilizer.setFont(new Font("Google Sans", Font.BOLD, 1));
        fertilizer.setForeground(new Color(0xA4BE7B));

        /* Shovel Alignment */
        shovel.setIcon(new ImageIcon(shovelImage));
        shovel.setBorder(BorderFactory.createEmptyBorder());
        shovel.setContentAreaFilled(false);
        shovel.setFocusable(false); // remove a border around the text
        shovel.setSize(150, 50);
        shovel.setHorizontalAlignment(JButton.CENTER);
        shovel.setFont(new Font("Google Sans", Font.BOLD, 1));
        shovel.setForeground(new Color(0xA4BE7B));

        /* PickAxe Alignment */
        pickaxe.setIcon(new ImageIcon(pickaxeImage));
        pickaxe.setBorder(BorderFactory.createEmptyBorder());
        pickaxe.setContentAreaFilled(false);
        pickaxe.setFocusable(false); // remove a border around the text
        pickaxe.setSize(150, 50);
        pickaxe.setHorizontalAlignment(JButton.CENTER);
        pickaxe.setFont(new Font("Google Sans", Font.BOLD, 1));
        pickaxe.setForeground(new Color(0xA4BE7B));

        harvest.setIcon(new ImageIcon(harvestImage));
        harvest.setBorder(BorderFactory.createEmptyBorder());
        harvest.setContentAreaFilled(false);
        harvest.setFocusable(false); // remove a border around the text
        harvest.setSize(150, 50);
        harvest.setHorizontalAlignment(JButton.CENTER);
        harvest.setFont(new Font("Google Sans", Font.BOLD, 1));
        harvest.setForeground(new Color(0xA4BE7B));

        // add buttons to Tool Panel
        this.add(plow);
        this.add(water);
        this.add(fertilizer);
        this.add(shovel);
        this.add(pickaxe);
        this.add(harvest);

    }

    /*
     * This method returns the initailized
     * plowing tool button.
     */
    public JButton getPlow() {
        return plow;
    }

    /*
     * This method returns the initialized
     * watering can button.
     */
    public JButton getWater() {
        return water;
    }

    /*
     * This method returns the initialized
     * fertilizer tool button.
     */
    public JButton getFertilizer() {
        return fertilizer;
    }

    /*
     * This method returns the initialized
     * shovel tool button.
     */
    public JButton getShovel() {
        return shovel;
    }

    /*
     * This method returns the initialized
     * pickaxe tool button.
     */
    public JButton getPickAxe() {
        return pickaxe;
    }

    /*
     * This method returns the initialized
     * harvest tool button.
     */
    public JButton getHarvest() {
        return harvest;
    }

    /*
     * This method enables the initialized
     * plowing tool button.
     */
    public void setPlowEnabled(boolean enabled) {
        plow.setEnabled(enabled);
    }

    /*
     * This method enables the initialized
     * watering can button.
     */
    public void setWaterEnabled(boolean enabled) {
        water.setEnabled(enabled);
    }

    /*
     * This method enables the initialized
     * shovel tool button.
     */
    public void setShovelEnabled(boolean enabled) {
        shovel.setEnabled(enabled);
    }

    /*
     * This method enables the initialized
     * fertilizer tool button.
     */
    public void setFertilizerEnabled(boolean enabled) {
        fertilizer.setEnabled(enabled);
    }

    /*
     * This method enables the initialized
     * pickaxe tool button.
     */
    public void setPickAxeEnabled(boolean enabled) {
        pickaxe.setEnabled(enabled);
    }

}