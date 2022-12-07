package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

public class UpgradePanel extends JPanel {

    private JButton regFarmer = new JButton("Registered Farmer");
    private JButton disFarmer = new JButton("Distinguished Farmer");
    private JButton legFarmer = new JButton("Legendary Farmer");

    BufferedImage regImage;
    BufferedImage disImage;
    BufferedImage legImage;

    public UpgradePanel() {
        this.setLayout(new GridLayout(4, 1));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(0xA4BE7B));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(160, 250));
        init();
        addButtons();
        this.setVisible(true);

    }

    /* This method initializes all attributes needed for upgrade panel. */
    private void init() {
        JLabel upgrade = new JLabel("Farmer Upgrade");
        upgrade.setForeground(Color.WHITE);
        upgrade.setFont(new Font("Google Sans", Font.BOLD, 15));
        upgrade.setVerticalAlignment(JLabel.CENTER);
        upgrade.setHorizontalAlignment(JLabel.CENTER);
        this.add(upgrade);
    }

    private void addButtons() {
        /* Retrieves file path of upgrade button assets */
        try {

            regImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/registered.png"));
            disImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/distinguished.png"));
            legImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/legendary.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Assets for Registered Farmer */
        regFarmer.setIcon(new ImageIcon(regImage));
        regFarmer.setBorder(BorderFactory.createEmptyBorder());
        regFarmer.setContentAreaFilled(false);
        regFarmer.setFocusable(false);
        regFarmer.setSize(150, 50);
        regFarmer.setHorizontalAlignment(JButton.CENTER);
        regFarmer.setFont(new Font("Google Sans", Font.BOLD, 1));
        regFarmer.setForeground(new Color(0xA4BE7B));

        /* Assets for Distinguished Farmer */
        disFarmer.setIcon(new ImageIcon(disImage));
        disFarmer.setBorder(BorderFactory.createEmptyBorder());
        disFarmer.setContentAreaFilled(false);
        disFarmer.setFocusable(false);
        disFarmer.setSize(150, 50);
        disFarmer.setHorizontalAlignment(JButton.CENTER);
        disFarmer.setFont(new Font("Google Sans", Font.BOLD, 1));
        disFarmer.setForeground(new Color(0xA4BE7B));

        /* Assets for Legendary Farmer */
        legFarmer.setIcon(new ImageIcon(legImage));
        legFarmer.setBorder(BorderFactory.createEmptyBorder());
        legFarmer.setContentAreaFilled(false);
        legFarmer.setFocusable(false);
        legFarmer.setSize(150, 50);
        legFarmer.setHorizontalAlignment(JButton.CENTER);
        legFarmer.setFont(new Font("Google Sans", Font.BOLD, 1));
        legFarmer.setForeground(new Color(0xA4BE7B));

        this.add(regFarmer);
        this.add(disFarmer);
        this.add(legFarmer);
    }

    /*
     * This method returns the initialized
     * registered farmer button.
     */
    public JButton getReg() {
        return regFarmer;
    }

    /*
     * This method returns the initialized
     * distinguished farmer button.
     */
    public JButton getDis() {
        return disFarmer;
    }

    /*
     * This method returns the initialized
     * legendary farmer button.
     */
    public JButton getLeg() {
        return legFarmer;
    }

    /*
     * This method enables the initialized
     * registered farmer button.
     */
    public void setRegEnabled(boolean enabled) {
        regFarmer.setEnabled(enabled);
    }

    /*
     * This method enables the initialized
     * distinguished farmer button.
     */
    public void setDisEnabled(boolean enabled) {
        disFarmer.setEnabled(enabled);
    }

    /*
     * This method enables the initialized
     * legendary farmer button.
     */
    public void setLegEnabled(boolean enabled) {
        legFarmer.setEnabled(enabled);
    }

}
