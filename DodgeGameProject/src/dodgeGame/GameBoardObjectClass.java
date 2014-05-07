package dodgeGame;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * This is an abstract class that contains the common behaviour of both the
 * player and the raindrops Class has abstract method move and provide
 * implementation for position method
 */
public abstract class GameBoardObjectClass {

    private boolean visible;
    private int xaxis;
    private int yaxis;
    private int width;
    protected int height;
    private Image image;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Abstract method move
     */
    public abstract void move();

    
    /**
     * Method is common to both the player and the raindrop class
     */
    public Rectangle position() {
        return new Rectangle(xaxis, yaxis, width, height);
    }

    public boolean isVisible() {
        return visible;
    }

    public int getXaxis() {
        return xaxis;
    }

    public void setXaxis(int xaxis) {
        this.xaxis = xaxis;
    }

    public int getYaxis() {
        return yaxis;
    }

    public void setYaxis(int yaxis) {
        this.yaxis = yaxis;
    }

    public Image getImage() {
        return image;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
