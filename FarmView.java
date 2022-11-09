import java.awt.*;
import javax.swing.*;

public class FarmView extends JFrame {

    public FarmView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1650, 1080);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        init();
        this.setVisible(true);
    }

    private void init() {
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
        toolPanel.setLayout(new GridLayout(10, 1));
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
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(seedPanel, BorderLayout.EAST);
        this.add(toolupgradePanel, BorderLayout.WEST);
        this.add(accessoryPanel, BorderLayout.SOUTH);

    }

}
