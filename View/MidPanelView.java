package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MidPanelView extends JPanel {
    private ArrayList<TileView> tileList = new ArrayList<>();

    public MidPanelView() {
        this.setLayout(new GridLayout(5, 10, 4, 50));
        this.setPreferredSize(new Dimension(730, 730));
        this.setBackground(new Color(0x5F8D4E));
        this.setBorder(BorderFactory.createEmptyBorder(45, 10, 30, 10));
        this.setVisible(true);

        // add 50 instances of tileview class to midpanel view
        for (int i = 0; i < 50; i++) {
            TileView tile = new TileView();
            tile.setText(String.format("    Tile %d", i));
            tile.setIndex(i);
            this.tileList.add(tile);
            this.add(tile);
        }
    }

    /* This method gets the tile corresponding to the index. */
    public TileView getTile(int index) {
        return (TileView) this.tileList.get(index);
    }

    /* This method returns the entire list of farm tiles. */
    public ArrayList<TileView> getPerTile() {
        return this.tileList;
    }

}