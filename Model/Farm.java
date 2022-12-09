package Model;

import java.io.*;
import java.util.ArrayList;

/**
 * This class initializes the status of the farm lot according to player's actions.
 */
public class Farm {

    ArrayList<Farmtile> tiles = new ArrayList<Farmtile>();

    /**
     * This constructor initializes the index of each tile and
     * maps the rocks according to the text file.
     */

    public Farm() {
        setIndexTiles();
        loadMap();
    }

    /**
     * This method creates and adds a tile, then
     * sets the index of each tile in a 10 x 5
     * lot from 0 to 49.
     */

    public void setIndexTiles() {

        for (int i = 0; i < 50; i++) {
            Farmtile tile = new Farmtile();
            this.tiles.add(tile);
            this.tiles.get(i).setIndexperTile(i);
        }
    }

    /**
     * This method maps the rocks according to the text file,
     * and places the rock depending on the randomized index
     * stated in the text file.
     */

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/resources/maps/rock-placements.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int index = 0;
            while (index < 50) {
                String line = br.readLine();

                /*
                 * If text file equals 1 or True for rock placement
                 * update rock status of the corresponding tile to true.
                 */
                if (line.equals("1")) {
                    this.tiles.get(index).updateRockStatus(true);
                } else {
                    this.tiles.get(index).updateRockStatus(false);
                }
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method gets the tile associated for a specific index.
     * 
     * @param index tile index that the the program wants to access
     * @return tile associated to given index
     */

    public Farmtile getTile(int index) {
        return this.tiles.get(index);
    }

    /**
     * This method returns the whole list of tiles added to the farm lot.
     * 
     * @return arraylist of farm tiles that the farm lot has
     */

    public ArrayList<Farmtile> getTileList() {
        return this.tiles;
    }

}
