package dodgeGame;

import java.awt.Rectangle;
import java.util.List;

/**
 * This class manages a set of game rules
 */
public class RulesEngine {

    /*method to manages the rules of the game */
    public static void checkGameRules(List<GameBoardObjectClass> drop, List<GameBoardObjectClass> playerList) {
        checkCollision(drop, playerList);
    }

    /*method to detect collision between the player and the raindrop object */
    private static void checkCollision(List<GameBoardObjectClass> drop, List<GameBoardObjectClass> playerList) {

        Rectangle dropPos = new Rectangle();
        Rectangle playerPos = new Rectangle();

        /*loops thrugh the raindrop list and check the position of each rain drop */
        for (int i = 0; i < drop.size(); i++) {
            GameBoardObjectClass rd = drop.get(i);
            if (rd.isVisible()) {
                dropPos = rd.position();
            }
            /*loops thrugh the player list and check the position of each player */
            for (int p = 0; p < playerList.size(); p++) {
                Player player = (Player) playerList.get(p);
                if (player.isVisible()) {
                    playerPos = player.position();
                }
                /*checks for any intersection between the player and the raindrop */
                if (dropPos.intersects(playerPos)) {
                    GameBoard.isGameActive = false;
                }
            }
        }
    }
}
