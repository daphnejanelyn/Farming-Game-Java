package View;

import javax.swing.*;
import java.awt.*;

public class MidPanelView extends JPanel {
    private Point locationTile = new Point();

    public MidPanelView() {
        this.setLayout(new GridLayout(10, 5, 4, 4));
        this.setPreferredSize(new Dimension(730, 730));
        this.setBackground(new Color(0xFFFFE0));
        this.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.setVisible(true);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 5; col++) {
                locationTile.setLocation(row, col);
                TileView tile = new TileView(locationTile);
                this.add(tile);
            }
        }
    }

}