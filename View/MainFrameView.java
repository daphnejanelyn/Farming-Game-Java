package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrameView extends JFrame {
    private TitlePanel titlePanel = new TitlePanel();
    private MidPanelView midPanelView = new MidPanelView();
    private SeedPanel seedPanel = new SeedPanel();
    private ToolUpgradePanel toolUpgradePanel = new ToolUpgradePanel();
    private AccessoryPanel accessoryPanel = new AccessoryPanel();

    public MainFrameView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /* Initalize all subpanels to one main panel */
    private void init() {
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(midPanelView, BorderLayout.CENTER);
        this.add(seedPanel, BorderLayout.EAST);
        this.add(toolUpgradePanel, BorderLayout.WEST);
        this.add(accessoryPanel, BorderLayout.SOUTH);

    }

    /* This method shows message dialog when game terminates */
    public void getEndGameView() {
        JOptionPane.showMessageDialog(this, "Game Over!");
    }

    /* This method gets the specific index of a farm tile */
    public int getTileIndex(TileView tile) {
        return tile.getIndex();
    }

    /*
     * This method assigns a view to the tile
     * corresponding to the index depending on the
     * rock status of the tile.
     */
    public void assignView(String status, int i) {
        midPanelView.getTile(i).updateView(status);
    }

    /*
     * This method assigns a view to the tile
     * corresponding to the index depending on
     * the overall status of the tile.
     */
    public void updateView(String status, int i) {
        midPanelView.getTile(i).updateView(status);
    }

    /*
     * This method assigns a view to the tile
     * corrsponding to the index when a crop
     * is planted.
     */
    public void updateViewtoPlant(String crop, int i, int start, int current, int end) {
        midPanelView.getTile(i).updateViewtoPlant(crop, start, current, end);
    }

    /*
     * This method updates the amount, level,
     * XP amount and current day count in the accessory panel.
     */
    public void updateAccessoryStatus(double coins, double points, int level, int day) {
        accessoryPanel.updateDay(day);
        accessoryPanel.updateLevel(level);
        accessoryPanel.updateObjectCoins(coins);
        accessoryPanel.updateXP(points);
    }

    /*
     * This method displays a prompt according
     * to the players' prompt.
     */
    public void displayPrompt(String status) {
        titlePanel.displayPrompt(status);
    }

    /*
     * This method displays a harvest prompt.
     */
    public void displayHarvestPrompt(int productsProduced, double harvestTime) {
        titlePanel.harvestPrompt(productsProduced, harvestTime);
    }

    /* This method hides the visible prompt. */
    public void hidePrompt() {
        titlePanel.hidePrompt();
    }

    /*
     * This method sets action listeners for all
     * buttons initialized.
     */
    public void setActionListener(ActionListener listener) {
        // seeds initialization
        seedPanel.getTurnip().addActionListener(listener);
        seedPanel.getCarrot().addActionListener(listener);
        seedPanel.getPotato().addActionListener(listener);
        seedPanel.getRose().addActionListener(listener);
        seedPanel.getSunflower().addActionListener(listener);
        seedPanel.getTulips().addActionListener(listener);
        seedPanel.getMango().addActionListener(listener);
        seedPanel.getApple().addActionListener(listener);

        // tools initialization
        toolUpgradePanel.getTool().getPlow().addActionListener(listener);
        toolUpgradePanel.getTool().getWater().addActionListener(listener);
        toolUpgradePanel.getTool().getFertilizer().addActionListener(listener);
        toolUpgradePanel.getTool().getShovel().addActionListener(listener);
        toolUpgradePanel.getTool().getPickAxe().addActionListener(listener);
        toolUpgradePanel.getTool().getHarvest().addActionListener(listener);

        // upgrades initialization
        toolUpgradePanel.getUpgrade().getReg().addActionListener(listener);
        toolUpgradePanel.getUpgrade().getDis().addActionListener(listener);
        toolUpgradePanel.getUpgrade().getLeg().addActionListener(listener);

        // next day initialization
        toolUpgradePanel.getNextDay().getNextDayButton().addActionListener(listener);

        // main panel initialization
        for (int i = 0; i < midPanelView.getPerTile().size(); i++) {
            midPanelView.getPerTile().get(i).addActionListener(listener);
        }

    }

}
