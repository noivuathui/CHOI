import java.awt.*;

/**
 * Created by noivu on 3/5/2016.
 */
public class Plane extends PlaneAbstract {

    public Plane() {

    }
    public Plane(int positionX, int positionY,int speed, int planeType){
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        this.planeType = planeType;
    }

    public void move(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    private int direction = 0;

    public void move(){
        if(direction == 0){

        }
        if(direction == 1){
            this.positionX -= this.speed;
        }
        if(direction == 2){
            this.positionX += this.speed;
        }
        if(direction == 3){
            this.positionY -= this.speed;
        }
        if(direction == 4){
            this.positionY += this.speed;
        }
    }

    public void update(){
        this.move();
    }


}
