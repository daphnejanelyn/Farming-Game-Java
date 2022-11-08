import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class View {
    public static void main(String[] args) {
        // setting frame for entire window
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1650, 1080);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // set up 5 panels
        JPanel titlePanel = new JPanel(); // TITLE and PROGRESS BAR
        JPanel mainPanel = new JPanel(); // FARM TILES
        JPanel seedPanel = new JPanel(); // SEED OPTIONS
        JPanel toolupgradePanel = new JPanel(); // TOOL and UPGRADE OPTIONS
        JPanel accessoryPanel = new JPanel(); // OBJECT COINS, DAY #, LEVEL and XP

        titlePanel.setBackground(new Color(0xF6FBF4));
        mainPanel.setBackground(new Color(0x5FD068));
        seedPanel.setBackground(new Color(0x4B8673));
        toolupgradePanel.setBackground(new Color(0x4B8673));
        accessoryPanel.setBackground(new Color(0xF5DF99));

        /* ----- subpanels for tool upgrade panel ----- */
        toolupgradePanel.setLayout(new BorderLayout());

        // declare new subpanels within toolupgradePanel
        JPanel toolPanel = new JPanel();
        JPanel upgradePanel = new JPanel();
        toolPanel.setLayout(new GridLayout(6, 1));
        JLabel tool = new JLabel("Tools");
        JLabel upgrade = new JLabel("Farmer Upgrade");

        // LABEL ALIGNMENTS
        tool.setForeground(Color.WHITE);
        tool.setVerticalAlignment(JLabel.CENTER);
        tool.setHorizontalAlignment(JLabel.CENTER);

        upgrade.setVerticalAlignment(JLabel.CENTER);
        upgrade.setHorizontalAlignment(JLabel.CENTER);

        toolPanel.setBackground(new Color(0x4B8673));
        toolPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        upgradePanel.setBackground(new Color(0x4B8673));
        upgradePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        toolPanel.setPreferredSize(new Dimension(150, 350));
        upgradePanel.setPreferredSize(new Dimension(150, 350));

        toolPanel.add(tool);
        upgradePanel.add(upgrade);

        // add buttons for tools
        JButton plow = new JButton("Plow");
        plow.setFocusable(false); // remove a border around the text
        plow.setSize(150, 50);
        plow.setHorizontalAlignment(JButton.CENTER);

        JButton water = new JButton("Water");
        water.setFocusable(false); // remove a border around the text
        water.setSize(150, 50);
        water.setHorizontalAlignment(JButton.CENTER);

        JButton fertilizer = new JButton("Fertilizer");
        fertilizer.setFocusable(false); // remove a border around the text
        fertilizer.setSize(150, 50);
        fertilizer.setHorizontalAlignment(JButton.CENTER);

        JButton shovel = new JButton("Shovel");
        shovel.setFocusable(false); // remove a border around the text
        shovel.setSize(150, 50);
        shovel.setHorizontalAlignment(JButton.CENTER);

        JButton pickaxe = new JButton("Pickaxe");
        pickaxe.setFocusable(false); // remove a border around the text
        pickaxe.setSize(150, 50);
        pickaxe.setHorizontalAlignment(JButton.CENTER);

        // add buttons to Tool Panel
        toolPanel.add(plow);
        toolPanel.add(water);
        toolPanel.add(fertilizer);
        toolPanel.add(shovel);
        toolPanel.add(pickaxe);

        toolupgradePanel.add(toolPanel, BorderLayout.NORTH);
        toolupgradePanel.add(upgradePanel, BorderLayout.SOUTH);

        /* ----- subpanels for main panel ----- */
        mainPanel.setLayout(new GridLayout(5, 10));

        // adding border to tiles

        for (int i = 0; i < (5 * 10); i++) {
            JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            mainPanel.add(label);
        }

        // set dimension for each panel
        titlePanel.setPreferredSize(new Dimension(1650, 50));
        accessoryPanel.setPreferredSize(new Dimension(1650, 100));
        toolupgradePanel.setPreferredSize(new Dimension(100, 300));
        seedPanel.setPreferredSize(new Dimension(150, 300));
        mainPanel.setPreferredSize(new Dimension(1450, 930));

        // set placement for each panel
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(seedPanel, BorderLayout.EAST);
        frame.add(toolupgradePanel, BorderLayout.WEST);
        frame.add(accessoryPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}