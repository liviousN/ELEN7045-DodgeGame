package dodgeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * GameBoard is the main controller of the game
 */
public class GameBoard extends JPanel implements ActionListener {

    protected static Timer timer;
    private final int numberOfDrops = 20;
    private List<GameBoardObjectClass> playerList;
    private List<GameBoardObjectClass> drops;
    private int[][] dropsArray;
    protected static boolean isGameActive;
   
    /*Constructor method  */
    public GameBoard() {

        addKeyListener(new Adapter());
        setFocusable(true);
        setBackground(Color.GRAY);
        setDoubleBuffered(true);

        isGameActive = true;
        generateRaindrops(numberOfDrops);

        playerList = new ArrayList();
        playerList.add(new Player((GameManager.getFrameWidth() / 2), (GameManager.getFrameHeight() - 100)));
        timer = new Timer(30, this);
        timer.start();

    }

    /*Paints all the objects in their postion in the Field */
    public void paint(Graphics g) {
        super.paint(g);
        if (isGameActive) {
            //Paints objects of Player
            for (int p = 0; p < playerList.size(); p++) {
                GameBoardObjectClass player = playerList.get(p);
                if (player.isVisible()) {
                    g.drawImage(player.getImage(), player.getXaxis(), player.getYaxis(), this);
                }
            }
            /*Paints objects of Raindrops  */
            for (int i = 0; i < drops.size(); i++) {
                GameBoardObjectClass rd = drops.get(i);
                if (rd.isVisible()) {
                    g.drawImage(rd.getImage(), rd.getXaxis(), rd.getYaxis(), this);
                }
            }

            /* the game is ended */
        } else {
            Font small = new Font("Arial", Font.BOLD, 28);
            g.setColor(Color.BLUE);
            g.setFont(small);
            generateRaindrops(numberOfDrops);
            g.drawString("GAME OVER", (GameManager.getFrameWidth() / 2 -80), (GameManager.getFrameHeight() / 2));
            
            Font mes = new Font("Arial", Font.ITALIC, 16);
            g.setColor(Color.YELLOW);
            g.setFont(mes);
            g.drawString("Press Enter to Resume", (GameManager.getFrameWidth() / 2 -80), ((GameManager.getFrameHeight() / 2) + 50));
        }
    }

    /*generate a bidirectional array with initial positions of the raindrops */
    public void generateRaindrops(int numberOfDrops) {
        Random randNum = new Random();
        dropsArray = new int[numberOfDrops][2];

        for (int i = 0; i < numberOfDrops; i++) {
            for (int y = 0; y < 2; y++) {
                if (y == 1) {
                    dropsArray[i][y] = randNum.nextInt(GameManager.getFrameWidth() / 6);
                } else {
                    dropsArray[i][y] = randNum.nextInt(GameManager.getFrameWidth());
                }
            }
        }
        dropsFactory();

    }

    /* generate instances of raindrop  */
    private void dropsFactory() {
        drops = new ArrayList();

        for (int i = 0; i < dropsArray.length; i++) {
            drops.add(new Raindrop(dropsArray[i][0], dropsArray[i][1]));
        }
    }

    /* this method loops through the objects and execute the move method of each object */
    public void actionPerformed(ActionEvent e) {

        /* this method loops through the raindrop objects and execute the move method of each object */
        for (int i = 0; i < drops.size(); i++) {
            GameBoardObjectClass rd = drops.get(i);
            if (rd.isVisible()) {
                rd.move();
            }
        }

        /* this method loops through the player objects and execute the move method of the player */
        for (int i = 0; i < playerList.size(); i++) {
            GameBoardObjectClass player = playerList.get(i);
            if (player.isVisible()) {
                player.move();
            }
        }
        /* checks for rules of the game */
        RulesEngine.checkGameRules(drops, playerList);
        repaint();


    }

    private class Adapter extends KeyAdapter {

        KeyControlInterface key = new KeyBoardController();

        public void keyReleased(KeyEvent e) {

            key.keyReleased(e, playerList);
        }

        public void keyPressed(KeyEvent e) {
            key.keyPressed(e, playerList);
        }
    }
}
