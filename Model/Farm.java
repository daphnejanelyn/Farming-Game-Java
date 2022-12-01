package Model;

import java.io.*;
import java.util.ArrayList;

public class Farm {

    private int numberofTilesRow;
    private int numberofTilesCol;
    ArrayList<Farmtile> tiles = new ArrayList<Farmtile>();

    public Farm() {
        this.numberofTilesCol = 5;
        this.numberofTilesRow = 10;

        setIndexTiles();
        loadMap();
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
            // this.tiles.get(i).setIndexperTile(i);
        }
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/resources/maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int index = 0;
            // System.out.println(br.readLine());
            while (index < 50) {
                String line = br.readLine();
                // String s[] = line.split("\n");
                // System.out.println(line);
                // int num = Integer.parseInt(line);

                // System.out.println((line.equals("1")));

                if (line.equals("1")) {
                    this.tiles.get(index).updateRockStatus(true);
                } else {
                    this.tiles.get(index).updateRockStatus(false);
                }

                // System.out.println(String.format("%s: %d",
                // this.tiles.get(index).isRockThere(), index));

                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Farmtile getTile(int index) {
        return this.tiles.get(index);
    }

    public ArrayList<Farmtile> getTileList() {
        return this.tiles;
    }

}
