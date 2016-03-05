import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by noivu on 3/5/2016.
 */
public abstract class GameObject {
    protected int positionX;
    protected int positionY;
    public BufferedImage sprite;

    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
