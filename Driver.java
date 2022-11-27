import View.*;
import Model.*;
import Controller.GameController;

public class Driver {
    public static void main(String[] args) {
        MainFrameView game = new MainFrameView();
        Farmer player = new Farmer("Player 1");
        GameController controller = new GameController(game, player);
    }

}