package Model;

import java.util.ArrayList;

public class Farm {

    private int numberofTilesRow;
    private int numberofTilesCol;
    ArrayList<Farmtile> tiles = new ArrayList<Farmtile>();

    public Farm() {
        this.numberofTilesCol = 5;
        this.numberofTilesRow = 10;
    }

    // public void setIndexTiles() {
    // for (int i = 0; i < this.numberofTilesRow; i++) {
    // for (int j = 0; j < this.numberofTilesCol; j++) {
    // tiles[i][j].setIndexperTile(i + j + 1);
    // }
    // }

    // }

    public void setIndexTiles() {
        for (int i = 0; i < 50; i++) {
            Farmtile tile = new Farmtile();
            this.tiles.add(tile);
        }
    }

    public Farmtile getTile(int index) {
        return this.tiles.get(index);
    }

}
