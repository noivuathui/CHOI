import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by noivu on 3/1/2016.
 */
public class Bullet implements KeyListener{
    private int positionXD ;
    private int positionYD ;
    private int speedD ;
    private BufferedImage sprite;

    public Bullet() {
        this.positionYD = 0;
        this.positionXD = 0;
    }

    public Bullet(int positionXD, int positionYD, int speedD) {
        this.positionXD = positionXD;
        this.positionYD = positionYD;
        this.speedD = speedD;
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void move(){
        this.positionYD -= this.speedD;
    }

    void draw(Graphics g){
        g.drawImage(this.sprite,this.positionXD, this.positionYD,null);
    }

    public void setPositionXD(int positionXD) {
        this.positionXD = positionXD;
    }

    public int getPositionXD() {
        return positionXD;
    }

    public void setPositionYD(int positionYD) {
        this.positionYD = positionYD;
    }

    public int getPositionYD() {
        return positionYD;
    }

    public void setSpeedD(int speedD) {
        this.speedD = speedD;
    }

    public int getSpeedD() {
        return speedD;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

//    public void setDirectionDAN(int directionDAN) {
//        this.directionDAN = directionDAN;
//    }
//
//    public int getDirectionDAN() {
//        return directionDAN;
//    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == ' '){
//            directionDAN = 0;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
