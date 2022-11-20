package View;

import javax.swing.*;
import java.awt.*;

public class AccessoryPanel extends JPanel {

    public AccessoryPanel() {
        this.setBackground(new Color(0xF5DF99));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000, 100));
        init();
        this.setVisible(true);
    }

    private void init() {
        // declare new subpanels within toolupgradePanel
        JPanel objectCoinsPanel = new JPanel();
        objectCoinsPanel.setBackground(new Color(0xF5DF99));
        JPanel farmerXPnLevelPanel = new JPanel();
        farmerXPnLevelPanel.setBackground(new Color(0xF5DF99));
        JPanel dayPanel = new JPanel();
        dayPanel.setBackground(new Color(0xF5DF99));

        // declare title labels*/
        JLabel objectCoins = new JLabel("Object Coins");
        JLabel farmerLevel = new JLabel("Level");
        JLabel farmerXP = new JLabel("XP");
        JLabel day = new JLabel("Day");

        /* Set design attributes for object coins */
        objectCoins.setForeground(new Color(0X425F57));
        objectCoins.setFont(new Font("Google Sans", Font.BOLD, 15));
        objectCoins.setVerticalAlignment(JLabel.CENTER);
        objectCoins.setHorizontalAlignment(JLabel.CENTER);

        /* Set design attributes for farmer level */
        farmerLevel.setForeground(new Color(0X425F57));
        farmerLevel.setFont(new Font("Google Sans", Font.BOLD, 15));
        farmerLevel.setVerticalAlignment(JLabel.CENTER);
        farmerLevel.setHorizontalAlignment(JLabel.LEFT);

        /* Set design attributes for farmer xp */
        farmerXP.setForeground(new Color(0X425F57));
        farmerXP.setFont(new Font("Google Sans", Font.BOLD, 15));
        farmerXP.setVerticalAlignment(JLabel.CENTER);
        farmerXP.setHorizontalAlignment(JLabel.RIGHT);

        /* Set design attributes for day */
        day.setForeground(new Color(0X425F57));
        day.setFont(new Font("Google Sans", Font.BOLD, 15));
        day.setVerticalAlignment(JLabel.CENTER);
        day.setHorizontalAlignment(JLabel.CENTER);

        /* Set dimensions for all subpanels */
        objectCoinsPanel.setPreferredSize(new Dimension(550, 50));
        farmerXPnLevelPanel.setPreferredSize(new Dimension(550, 50));
        dayPanel.setPreferredSize(new Dimension(550, 50));

        objectCoinsPanel.add(objectCoins);
        farmerXPnLevelPanel.add(farmerLevel);
        farmerXPnLevelPanel.add(farmerXP);
        dayPanel.add(day);

        this.add(objectCoinsPanel, BorderLayout.WEST);
        this.add(farmerXPnLevelPanel, BorderLayout.CENTER);
        this.add(dayPanel, BorderLayout.EAST);
    }

}
