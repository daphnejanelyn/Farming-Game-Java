package View;

import javax.swing.*;
import java.awt.*;

public class ToolUpgradePanel extends JPanel {
    private ToolPanel toolPanel = new ToolPanel();
    private UpgradePanel upgradePanel = new UpgradePanel();

    public ToolUpgradePanel() {
        this.setBackground(new Color(0xA4BE7B));
        this.setLayout(new BorderLayout()); // set layout for subpanel
        this.setPreferredSize(new Dimension(160, 300));
        this.add(toolPanel, BorderLayout.NORTH);
        this.add(upgradePanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public ToolPanel getTool() {
        return toolPanel;
    }

    public UpgradePanel getUpgrade() {
        return upgradePanel;
    }

}
