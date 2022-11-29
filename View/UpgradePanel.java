package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;

public class UpgradePanel extends JPanel {

    private JButton regFarmer = new JButton();
    private JButton disFarmer = new JButton();
    private JButton legFarmer = new JButton();

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

    private void init() {
        JLabel upgrade = new JLabel("Farmer Upgrade");
        upgrade.setForeground(Color.WHITE);
        upgrade.setFont(new Font("Google Sans", Font.BOLD, 15));
        upgrade.setVerticalAlignment(JLabel.CENTER);
        upgrade.setHorizontalAlignment(JLabel.CENTER);
        this.add(upgrade);
    }

    private void addButtons() {

        try {

            regImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/15.png"));
            disImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/16.png"));
            legImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/17.png"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Registered Farmer */
        regFarmer.setIcon(new ImageIcon(regImage));
        regFarmer.setBorder(BorderFactory.createEmptyBorder());
        regFarmer.setContentAreaFilled(false);
        regFarmer.setFocusable(false);
        regFarmer.setSize(150, 50);
        regFarmer.setHorizontalAlignment(JButton.CENTER);
        regFarmer.setFont(new Font("Google Sans", Font.BOLD, 11));

        /* Distinguished Farmer */
        disFarmer.setIcon(new ImageIcon(disImage));
        disFarmer.setBorder(BorderFactory.createEmptyBorder());
        disFarmer.setContentAreaFilled(false);
        disFarmer.setFocusable(false);
        disFarmer.setSize(150, 50);
        disFarmer.setHorizontalAlignment(JButton.CENTER);
        disFarmer.setFont(new Font("Google Sans", Font.BOLD, 9));

        /* Legendary Farmer */
        legFarmer.setIcon(new ImageIcon(legImage));
        legFarmer.setBorder(BorderFactory.createEmptyBorder());
        legFarmer.setContentAreaFilled(false);
        legFarmer.setFocusable(false);
        legFarmer.setSize(150, 50);
        legFarmer.setHorizontalAlignment(JButton.CENTER);
        legFarmer.setFont(new Font("Google Sans", Font.BOLD, 11));

        this.add(regFarmer);
        this.add(disFarmer);
        this.add(legFarmer);
    }

    public JButton getReg() {
        return regFarmer;
    }

    public JButton getDis() {
        return disFarmer;
    }

    public JButton getLeg() {
        return legFarmer;
    }

    public void setActionListener(ActionListener listener) {
        regFarmer.addActionListener(listener);
        disFarmer.addActionListener(listener);
        legFarmer.addActionListener(listener);
    }

    public void setRegEnabled(boolean enabled) {
        regFarmer.setEnabled(enabled);
    }

    public void setDisEnabled(boolean enabled) {
        disFarmer.setEnabled(enabled);
    }

    public void setLegEnabled(boolean enabled) {
        legFarmer.setEnabled(enabled);
    }

}
