package dodgeGame;

import java.awt.event.KeyEvent;
import java.util.List;

/*
 * This class implements the KeyControlInterface and provides the implementation
 * of the keypressed and keyRelease behaviour
 */
public class KeyBoardController implements KeyControlInterface {

    private int playerSpeed = 5;
    private int initspeed = 0;

    /*provides the behaviour of the player when the key is released */
    public void keyPressed(KeyEvent e, List<GameBoardObjectClass> playerList) {

        int key = e.getKeyCode();

        /*gets a player object  */
        for (int p = 0; p < playerList.size(); p++) {
            Player player = (Player) playerList.get(p);

            /* moves the player to the left when left key is pressed */
            if (key == KeyEvent.VK_LEFT) {
                player.setxDisplacement(-playerSpeed);
            }

            /* moves the player to the right when right key is pressed */
            if (key == KeyEvent.VK_RIGHT) {
                player.setxDisplacement(playerSpeed);
            }

            /*starts the game when the enter key is pressed */
            if (key == KeyEvent.VK_ENTER) {
                GameBoard.isGameActive = true;               
            }
        }
    }

    /*provides the behaviour of the player when the key is released */
    public void keyReleased(KeyEvent e, List<GameBoardObjectClass> playerList) {

        int key = e.getKeyCode();

        /*gets a player object  */
        for (int p = 0; p < playerList.size(); p++) {
            Player player = (Player) playerList.get(p);

            /*moves the player to the left when left key is pressed */
            if (key == KeyEvent.VK_LEFT) {
                player.setxDisplacement(initspeed);
            }

            /*moves the player to the right when right key is pressed */
            if (key == KeyEvent.VK_RIGHT) {
                player.setxDisplacement(initspeed);
            }
        }
    }
}
