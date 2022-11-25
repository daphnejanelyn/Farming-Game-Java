package View;

import javax.swing.*;
import java.awt.*;

public class MidPanelView extends JPanel {
    private Point locationTile = new Point();

    public MidPanelView() {
        this.setLayout(new GridLayout(5, 10, 4, 50));
        this.setPreferredSize(new Dimension(730, 730));
        this.setBackground(new Color(0x5F8D4E));
        this.setBorder(BorderFactory.createEmptyBorder(45, 10, 30, 10));
        this.setVisible(true);

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                locationTile.setLocation(row, col);
                TileView tile = new TileView(locationTile);
                this.add(tile);
            }
        }
    }

}