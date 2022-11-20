package View;

import javax.swing.*;
import java.awt.*;

public class TileView extends JButton {
    private Point locationTile;

    public TileView(Point temp) {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(75, 75));
        assignView(temp);
        this.setVisible(true);
    }

    private void assignView(Point temp) {
        this.setBackground(new Color(0x7F462C));

    }

}
