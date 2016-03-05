import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by noivu on 3/5/2016.
 */
public class PlaneAbstract extends GameObject {
    protected int speed;
    protected int planeType;

    public PlaneAbstract() {

    }
     public PlaneAbstract(int positionX, int positionY, int speed, int planeType){
         this.positionX = positionX;
         this.positionY = positionY;
         this.speed = speed;
         switch(planeType){
             case 1:
                 try {
                     this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 break;
             case 2:
                 try {
                     this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 break;
             case 3:
                 try {
                     this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 break;
             case 4:
                 try {
                     this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 break;
         }
     }

    public void move(){

    }
    public void update(){
        this.move();
    }
}
