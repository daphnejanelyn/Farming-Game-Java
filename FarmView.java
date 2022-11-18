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
        upgradePanel.setLayout(new GridLayout(10, 1));
        JLabel upgrade = new JLabel("Farmer Upgrade");

        // LABEL ALIGNMENTS
        tool.setForeground(Color.WHITE);
        tool.setFont(new Font("Google Sans", Font.BOLD, 15));
        tool.setVerticalAlignment(JLabel.CENTER);
        tool.setHorizontalAlignment(JLabel.CENTER);

        upgrade.setForeground(Color.WHITE);
        upgrade.setFont(new Font("Google Sans", Font.BOLD, 15));
        upgrade.setVerticalAlignment(JLabel.CENTER);
        upgrade.setHorizontalAlignment(JLabel.CENTER);

        toolPanel.setBackground(new Color(0x4B8673));
        toolPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        upgradePanel.setBackground(new Color(0x4B8673));
        upgradePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        toolPanel.setPreferredSize(new Dimension(300, 275));
        upgradePanel.setPreferredSize(new Dimension(300, 275));

        toolPanel.add(tool);
        upgradePanel.add(upgrade);

        // add buttons for tools
        JButton plow = new JButton("Plow");
        plow.setFocusable(false); // remove a border around the text
        plow.setSize(150, 50);
        plow.setHorizontalAlignment(JButton.CENTER);
        plow.setFont(new Font("Google Sans", Font.BOLD, 11));

        JButton water = new JButton("Water");
        water.setFocusable(false); // remove a border around the text
        water.setSize(150, 50);
        water.setHorizontalAlignment(JButton.CENTER);
        water.setFont(new Font("Google Sans", Font.BOLD, 11));

        JButton fertilizer = new JButton("Fertilizer");
        fertilizer.setFocusable(false); // remove a border around the text
        fertilizer.setSize(150, 50);
        fertilizer.setHorizontalAlignment(JButton.CENTER);
        fertilizer.setFont(new Font("Google Sans", Font.BOLD, 11));

        JButton shovel = new JButton("Shovel");
        shovel.setFocusable(false); // remove a border around the text
        shovel.setSize(150, 50);
        shovel.setHorizontalAlignment(JButton.CENTER);
        shovel.setFont(new Font("Google Sans", Font.BOLD, 11));

        JButton pickaxe = new JButton("Pickaxe");
        pickaxe.setFocusable(false); // remove a border around the text
        pickaxe.setSize(150, 50);
        pickaxe.setHorizontalAlignment(JButton.CENTER);
        pickaxe.setFont(new Font("Google Sans", Font.BOLD, 11));

        // add buttons to Tool Panel
        toolPanel.add(plow);
        toolPanel.add(water);
        toolPanel.add(fertilizer);
        toolPanel.add(shovel);
        toolPanel.add(pickaxe);

        JButton regFarmer = new JButton("Registered");
        regFarmer.setFocusable(false);
        regFarmer.setSize(150, 50);
        regFarmer.setHorizontalAlignment(JButton.CENTER);
        regFarmer.setFont(new Font("Google Sans", Font.BOLD, 11));

        JButton disFarmer = new JButton("Distinguished");
        disFarmer.setFocusable(false);
        disFarmer.setSize(150, 50);
        disFarmer.setHorizontalAlignment(JButton.CENTER);
        disFarmer.setFont(new Font("Google Sans", Font.BOLD, 9));

        JButton legFarmer = new JButton("Legendary");
        legFarmer.setFocusable(false);
        legFarmer.setSize(150, 50);
        legFarmer.setHorizontalAlignment(JButton.CENTER);
        legFarmer.setFont(new Font("Google Sans", Font.BOLD, 11));

        upgradePanel.add(regFarmer);
        upgradePanel.add(disFarmer);
        upgradePanel.add(legFarmer);

        toolupgradePanel.add(toolPanel, BorderLayout.NORTH);
        toolupgradePanel.add(upgradePanel, BorderLayout.SOUTH);

        /* ----- seed panel and label ----- */
        seedPanel.setLayout(new GridLayout(10, 1));
        JLabel seeds = new JLabel("Seeds");

        seedPanel.add(seeds);
        seeds.setForeground(Color.WHITE);
        seeds.setFont(new Font("Google Sans", Font.BOLD, 15));
        seeds.setVerticalAlignment(JLabel.CENTER);
        seeds.setHorizontalAlignment(JLabel.CENTER);

        JButton turnip = new JButton();
        turnip.setIcon(new ImageIcon("turnip.png"));
        turnip.setFocusable(false);
        turnip.setSize(150, 50);
        turnip.setHorizontalAlignment(JButton.CENTER);

        JButton carrot = new JButton("Carrot");
        carrot.setFocusable(false);
        carrot.setSize(150, 50);
        carrot.setHorizontalAlignment(JButton.CENTER);

        JButton potato = new JButton("Potato");
        potato.setFocusable(false);
        potato.setSize(150, 50);
        potato.setHorizontalAlignment(JButton.CENTER);

        JButton rose = new JButton("Rose");
        rose.setFocusable(false);
        rose.setSize(150, 50);
        rose.setHorizontalAlignment(JButton.CENTER);

        JButton sunflower = new JButton("Sunflower");
        sunflower.setFocusable(false);
        sunflower.setSize(150, 50);
        sunflower.setHorizontalAlignment(JButton.CENTER);

        JButton tulips = new JButton("Tulips");
        tulips.setFocusable(false);
        tulips.setSize(150, 50);
        tulips.setHorizontalAlignment(JButton.CENTER);

        JButton mango = new JButton("Mango");
        mango.setFocusable(false);
        mango.setSize(150, 50);
        mango.setHorizontalAlignment(JButton.CENTER);

        JButton apple = new JButton("Apple");
        apple.setFocusable(false);
        apple.setSize(150, 50);
        apple.setHorizontalAlignment(JButton.CENTER);

        seedPanel.add(turnip);
        seedPanel.add(carrot);
        seedPanel.add(potato);
        seedPanel.add(rose);
        seedPanel.add(sunflower);
        seedPanel.add(tulips);
        seedPanel.add(mango);
        seedPanel.add(apple);

        /* ----- subpanels for main panel ----- */
        mainPanel.setLayout(new GridBagLayout());

        // adding border to tiles
        mainPanel.setBackground(new Color(0X9BC73C));
        for (int i = 0; i < (5 * 10); i++) {
            JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            mainPanel.add(label);
        }

        /* ----- accessory panel ----- */

        accessoryPanel.setLayout(new BorderLayout());

        // declare new subpanels within toolupgradePanel
        JPanel objectCoinsPanel = new JPanel();
        objectCoinsPanel.setBackground(new Color(0xF5DF99));
        JPanel farmerXPnLevelPanel = new JPanel();
        farmerXPnLevelPanel.setBackground(new Color(0xF5DF99));
        JPanel dayPanel = new JPanel();
        dayPanel.setBackground(new Color(0xF5DF99));

        JLabel objectCoins = new JLabel("Object Coins");
        JLabel farmerLevel = new JLabel("Level");
        JLabel farmerXP = new JLabel("XP");
        JLabel day = new JLabel("Day");

        objectCoins.setForeground(new Color(0X425F57));
        objectCoins.setFont(new Font("Google Sans", Font.BOLD, 15));
        objectCoins.setVerticalAlignment(JLabel.CENTER);
        objectCoins.setHorizontalAlignment(JLabel.CENTER);

        farmerLevel.setForeground(new Color(0X425F57));
        farmerLevel.setFont(new Font("Google Sans", Font.BOLD, 15));
        farmerLevel.setVerticalAlignment(JLabel.CENTER);
        farmerLevel.setHorizontalAlignment(JLabel.LEFT);

        farmerXP.setForeground(new Color(0X425F57));
        farmerXP.setFont(new Font("Google Sans", Font.BOLD, 15));
        farmerXP.setVerticalAlignment(JLabel.CENTER);
        farmerXP.setHorizontalAlignment(JLabel.RIGHT);

        day.setForeground(new Color(0X425F57));
        day.setFont(new Font("Google Sans", Font.BOLD, 15));
        day.setVerticalAlignment(JLabel.CENTER);
        day.setHorizontalAlignment(JLabel.CENTER);

        objectCoinsPanel.setPreferredSize(new Dimension(550, 50));
        farmerXPnLevelPanel.setPreferredSize(new Dimension(550, 50));
        dayPanel.setPreferredSize(new Dimension(550, 50));

        objectCoinsPanel.add(objectCoins);
        farmerXPnLevelPanel.add(farmerLevel);
        farmerXPnLevelPanel.add(farmerXP);
        dayPanel.add(day);

        accessoryPanel.add(objectCoinsPanel, BorderLayout.WEST);
        accessoryPanel.add(farmerXPnLevelPanel, BorderLayout.CENTER);
        accessoryPanel.add(dayPanel, BorderLayout.EAST);

        // set dimension for each panel
        titlePanel.setPreferredSize(new Dimension(1650, 50));
        accessoryPanel.setPreferredSize(new Dimension(1650, 100));
        toolupgradePanel.setPreferredSize(new Dimension(250, 300));
        seedPanel.setPreferredSize(new Dimension(250, 300));
        mainPanel.setPreferredSize(new Dimension(1000, 1000));

        // set placement for each panel
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(seedPanel, BorderLayout.EAST);
        this.add(toolupgradePanel, BorderLayout.WEST);
        this.add(accessoryPanel, BorderLayout.SOUTH);

    }

}
