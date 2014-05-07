package dodgeGame;

import javax.swing.ImageIcon;

/*
 *Raindrop class represents the raindrop state and behaviour 
 */
public class Raindrop extends GameBoardObjectClass {

    private int raindropSpeed = 5;
    private String raindropImage = "/Image/raindrop.jpg";

    
    /*Constructor method sets image, visibility and position of object */     
    public Raindrop(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(raindropImage));
        setImage(ii.getImage());

        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));

        setVisible(true);

        setXaxis(x);
        setYaxis(y);
    }

    /*move method provides movement behaviour of the raindrop */
    public void move() {
        setYaxis(getYaxis() + raindropSpeed);

        if (getYaxis() >= GameManager.getFrameHeight()) {
            setYaxis(0);
        }
    }

    public int getRaindropSpeed() {
        return raindropSpeed;
    }

    public void setRaindropSpeed(int raindropSpeed) {
        this.raindropSpeed = raindropSpeed;
    }
}
