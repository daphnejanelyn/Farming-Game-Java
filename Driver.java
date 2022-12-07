import View.*;
import Model.*;
import Controller.GameController;

public class Driver {
    public static void main(String[] args) {
        // creates an instance of the Graphical User Interface
        MainFrameView game = new MainFrameView();
        // creates an instance of the model
        Farmer player = new Farmer("Player 1");
        // creates an instance of the program controller
        GameController controller = new GameController(game, player);
    }

}