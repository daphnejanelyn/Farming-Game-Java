package Model;

public class Farm {

    private int numberofTilesRow;
    private int numberofTilesCol;
    Farmtile[][] tiles = new Farmtile[10][5];

    public Farm() {
        this.numberofTilesCol = 5;
        this.numberofTilesRow = 10;
    }
}
