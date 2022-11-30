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
        this.setVisible(true);
    }

    private void init() {
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(midPanelView, BorderLayout.CENTER);
        this.add(seedPanel, BorderLayout.EAST);
        this.add(toolUpgradePanel, BorderLayout.WEST);
        this.add(accessoryPanel, BorderLayout.SOUTH);

    }

    public int getTileIndex(TileView tile) {
        return tile.getIndex();

    }

    public void updateView(String status, int i) {
        midPanelView.getTile(i).updateView(status);
    }

    public void updateViewtoPlant(String crop, int i, int start, int current, int end) {
        midPanelView.getTile(i).updateViewtoPlant(crop, start, current, end);
    }

    public void updateAccessoryStatus(double coins, double points, int level, int day) {
        accessoryPanel.updateDay(day);
        accessoryPanel.updateLevel(level);
        accessoryPanel.updateObjectCoins(coins);
        accessoryPanel.updateXP(points);
    }

    public void displayPrompt(String status) {
        titlePanel.displayPrompt(status);
    }

    public void hidePrompt() {
        titlePanel.hidePrompt();
    }

    public void setActionListener(ActionListener listener) {
        // seeds init
        seedPanel.getTurnip().addActionListener(listener);
        seedPanel.getCarrot().addActionListener(listener);
        seedPanel.getPotato().addActionListener(listener);
        seedPanel.getRose().addActionListener(listener);
        seedPanel.getSunflower().addActionListener(listener);
        seedPanel.getTulips().addActionListener(listener);
        seedPanel.getMango().addActionListener(listener);
        seedPanel.getApple().addActionListener(listener);

        // tools init
        toolUpgradePanel.getTool().getPlow().addActionListener(listener);
        toolUpgradePanel.getTool().getWater().addActionListener(listener);
        toolUpgradePanel.getTool().getFertilizer().addActionListener(listener);
        toolUpgradePanel.getTool().getShovel().addActionListener(listener);
        toolUpgradePanel.getTool().getPickAxe().addActionListener(listener);
        toolUpgradePanel.getTool().getHarvest().addActionListener(listener);

        // upgrades init
        toolUpgradePanel.getUpgrade().getReg().addActionListener(listener);
        toolUpgradePanel.getUpgrade().getDis().addActionListener(listener);
        toolUpgradePanel.getUpgrade().getLeg().addActionListener(listener);

        // next day init
        toolUpgradePanel.getNextDay().getNextDayButton().addActionListener(listener);

        // main panel init
        for (int i = 0; i < midPanelView.getPerTile().size(); i++) {
            midPanelView.getPerTile().get(i).addActionListener(listener);
        }

    }

}
