/** <b> This program, MyFarm, is a farming simulation game. </b>
 * <p>
 * There is 1 player, the Farmer, who carries out various farming tasks.
 * The Farmer <b> possesses money </b> to utilize throughout the simulation.
 * The Farmer also <b> gains income and experience from accomplishing farming tasks </b>.
 * <p>
 * Date Last Modified: 12/10/2022
 * @author Daphne Go and Patricia Arao
 */
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