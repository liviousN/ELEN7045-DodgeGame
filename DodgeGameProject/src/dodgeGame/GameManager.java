package dodgeGame;

import javax.swing.JFrame;

/*
 * This is the class that runs the application using the main method.
  */
public class GameManager extends JFrame {
   
    public static final int frameWidth = 1400;  /* sets the width of the frame */
    public static  final int frameHeight = 700; /* sets the height of the frame */

    public static int getFrameHeight() {
        return frameHeight;
    }

    public static int getFrameWidth() {
        return frameWidth;
    }
   
    /*constructor method of the class adds a  new object of the GameBoard to 
     * the frame and set the properties of the frame window */
    public GameManager() {
        add(new GameBoard());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(frameWidth, frameHeight);     
        setTitle("The Dodge Game");
        setResizable(false);
        setVisible(true);       
    }

    /* main method to start the application */
    public static void main(String[] args) {
        new GameManager();       
    }
}