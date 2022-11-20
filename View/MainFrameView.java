package View;

import javax.swing.*;
import java.awt.*;

public class MainFrameView extends JFrame {

    public MainFrameView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        init();
        this.setVisible(true);
    }

    private void init() {
        this.add(new TitlePanel(), BorderLayout.NORTH);
        this.add(new MidPanelView(), BorderLayout.CENTER);
        this.add(new SeedPanel(), BorderLayout.EAST);
        this.add(new ToolUpgradePanel(), BorderLayout.WEST);
        this.add(new AccessoryPanel(), BorderLayout.SOUTH);

    }

}
