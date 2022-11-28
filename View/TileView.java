package View;

import javax.swing.*;
import java.awt.*;

public class TileView extends JButton {
    private int index;

    public TileView() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(75, 75));
        assignView();
        this.setVisible(true);
    }

    public void assignView() {
        this.setBackground(new Color(0x7F462C));

    }

    public void setIndex(int init) {
        this.index = init;
    }

    public int getIndex() {
        return this.index;
    }

    /*
     * public void setActionListener(ActionListener listener) {
     * this.addActionListener(actionListener);
     * }
     */

    // public void setLocation() {
    // this.locationTile = point;
    // }

    public void updateView(String status) {
        // change color if it is plowed
        if (status.equals("plowed")) {
            this.setBackground(new Color(0x3a4c40));
        } else if (status.equals("unplowed")) {
            this.setBackground(new Color(0x7F462C));
        }
    }

}
