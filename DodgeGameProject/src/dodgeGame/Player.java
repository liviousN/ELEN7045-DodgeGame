package dodgeGame;

import javax.swing.ImageIcon;

/**
 * Player class represents the player and its behaviour  
 */
public class Player extends GameBoardObjectClass {

    private int xDisplacement;   /*varable represent the displacement of the player when key is pressed */
    private String playerImage = "/Image/player.jpg";  

    
     /* constructor method sets the player image, visibility and the position  */    
    public Player(int x, int y) {
        ImageIcon im = new ImageIcon(this.getClass().getResource(playerImage));
        setImage(im.getImage());

        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));

        setVisible(true);
        setXaxis(x);
        setYaxis(y);
    }

    public int getxDisplacement() {
        return xDisplacement;
    }

    public void setxDisplacement(int xDisplacement) {
        this.xDisplacement = xDisplacement;
    }

   
     /* Method to move the player along the x axis of the game's frame */     
    public void move() {

        setXaxis(getXaxis() + xDisplacement);

        if (getXaxis() >= GameManager.getFrameWidth()) {
            setXaxis(0);
        }

    }
}
