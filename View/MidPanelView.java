package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MidPanelView extends JPanel {
    private Point locationTile = new Point();
    private ArrayList<TileView> tileList = new ArrayList<>();

    public MidPanelView() {
        this.setLayout(new GridLayout(5, 10, 4, 50));
        this.setPreferredSize(new Dimension(730, 730));
        this.setBackground(new Color(0x5F8D4E));
        this.setBorder(BorderFactory.createEmptyBorder(45, 10, 30, 10));
        this.setVisible(true);

        for (int i = 0; i < 50; i++) {
            TileView tile = new TileView();
            tile.setText(String.format("    Tile %d", i));
            tile.setIndex(i);
            this.tileList.add(tile);
            this.add(tile);
        }
    }

    // public Point determineLocation(int index) {
    // return this.tileList.get(index).getLocation();
    // }

    public TileView getTile(int index) {
        return (TileView) this.tileList.get(index);
    }

    public ArrayList<TileView> getPerTile() {
        return this.tileList;
    }

}