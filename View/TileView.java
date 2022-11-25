package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TileView extends JButton {
    private Point locationTile;

    public TileView(Point temp) {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(75, 75));
        assignView(temp);
        this.setVisible(true);
    }

    public void assignView(Point temp) {
        this.setBackground(new Color(0x7F462C));

    }

    public void setActionListener(ActionListener listener) {
        this.addActionListener(actionListener);
    }

    public void updateView(Point temp) {
        // change color if it is plowed
    }

}
