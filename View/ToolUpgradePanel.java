package View;

import javax.swing.*;
import java.awt.*;

public class ToolUpgradePanel extends JPanel {
    public ToolUpgradePanel() {
        this.setBackground(new Color(0xA4BE7B));
        this.setLayout(new BorderLayout()); // set layout for subpanel
        this.setPreferredSize(new Dimension(160, 300));
        this.add(new ToolPanel(), BorderLayout.NORTH);
        this.add(new UpgradePanel(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

}
