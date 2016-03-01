import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by noivu on 2/28/2016.
 */
public class Plane {
    public Plane(){
        this.positionX = 300;
        this.positionY = 300;
        this.speed = 4;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shot(){
        Bullet bul = new Bullet(this.positionX +30, this.positionY,10);

    }

    private int positionX = 100;
    private int positionY = 200;
    private int damage;
    private int speed = 3;
    private int heatth;
    private int planeType;
    private int direction;
    private BufferedImage sprite;

    void move(){
//        if(directionDAN == 0){
//            this.positionY -= speed3;
//        }
        if(direction == 1){
            this.positionY -= this.speed;
        }else if(direction == 2){
            this.positionY += this.speed;
        }else if(direction == 3){
            this.positionX -= this.speed;
        }else if(direction == 4){
            this.positionX += this.speed;
        }
    }

    void update(){
        move();
    }
    void draw(Graphics g){
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
/*
bt : ẩn con chuột hidden cursor
      sửa class plane sao cho 1 con chạy bằng chuột, 1 con chay bang phim
    xem lại các thuộc tính, phương thức --> tạo access mdifier cho nó
làm bắn đạn.
*/