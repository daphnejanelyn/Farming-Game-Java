package View;

import javax.swing.*;
import java.awt.*;

public class AccessoryPanel extends JPanel {
    private JPanel objectCoinsPanel = new JPanel();
    private JPanel farmerXPnLevelPanel = new JPanel();
    private JPanel dayPanel = new JPanel();
    // declare title labels*/
    private JLabel objectCoins = new JLabel("Object Coins: 100");
    private JLabel farmerLevel = new JLabel("Level 0          ");
    private JLabel farmerXP = new JLabel("XP: 0");
    private JLabel day = new JLabel("Day 0");

    public AccessoryPanel() {
        this.setBackground(new Color(0x285430));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000, 100));
        init();
        this.setVisible(true);
    }

    private void init() {

        // declare new subpanels within toolupgradePanel
        objectCoinsPanel.setBackground(new Color(0x285430));

        farmerXPnLevelPanel.setBackground(new Color(0x285430));

        dayPanel.setBackground(new Color(0x285430));

        /* Set design attributes for object coins */
        objectCoins.setForeground(new Color(0XFBFACD));
        objectCoins.setFont(new Font("Google Sans", Font.BOLD, 15));
        objectCoins.setVerticalAlignment(JLabel.CENTER);
        objectCoins.setHorizontalAlignment(JLabel.CENTER);

        /* Set design attributes for farmer level */
        farmerLevel.setForeground(new Color(0XFBFACD));
        farmerLevel.setFont(new Font("Google Sans", Font.BOLD, 15));
        farmerLevel.setVerticalAlignment(JLabel.CENTER);
        farmerLevel.setHorizontalAlignment(JLabel.LEFT);

        /* Set design attributes for farmer xp */
        farmerXP.setForeground(new Color(0XFBFACD));
        farmerXP.setFont(new Font("Google Sans", Font.BOLD, 15));
        farmerXP.setVerticalAlignment(JLabel.CENTER);
        farmerXP.setHorizontalAlignment(JLabel.RIGHT);

        /* Set design attributes for day */
        day.setForeground(new Color(0XFBFACD));
        day.setFont(new Font("Google Sans", Font.BOLD, 15));
        day.setVerticalAlignment(JLabel.CENTER);
        day.setHorizontalAlignment(JLabel.CENTER);

        /* Set dimensions for all subpanels */
        objectCoinsPanel.setPreferredSize(new Dimension(300, 50));
        farmerXPnLevelPanel.setPreferredSize(new Dimension(300, 50));
        dayPanel.setPreferredSize(new Dimension(300, 50));

        objectCoinsPanel.add(objectCoins);
        farmerXPnLevelPanel.add(farmerLevel);
        farmerXPnLevelPanel.add(farmerXP);
        dayPanel.add(day);

        this.add(objectCoinsPanel, BorderLayout.WEST);
        this.add(farmerXPnLevelPanel, BorderLayout.CENTER);
        this.add(dayPanel, BorderLayout.EAST);
    }

    public void updateDay(int day) {
        this.day.setText("Day " + day);
    }

    public void updateObjectCoins(double coins) {
        this.objectCoins.setText("Object Coins: " + coins);
    }

    public void updateXP(double xp) {
        this.farmerXP.setText("XP: " + xp);
    }

    public void updateLevel(int level) {
        this.farmerLevel.setText("Level " + level + "          ");
    }

}
