package dodgeGame;

import java.awt.event.KeyEvent;
import java.util.List;

/**
 *Interface provides behaviour of device used to control the player.
  */
public interface KeyControlInterface {

    //Method provides the behaviour of the player when the specified key is pressed
    public void keyPressed(KeyEvent e, List<GameBoardObjectClass> playerList);

    
     //Method provides the behaviour of the player when the specified key is released
    public void keyReleased(KeyEvent e, List<GameBoardObjectClass> playerList);
}
