import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by noivu on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,MouseMotionListener, Runnable{

    //start
    Graphics seconds;
    Image image;
    //end

    BufferedImage background;
    BufferedImage PLANE1, PLANE4, DAN;

    int positionYD ;
    //int derictionDAN = 1 ;

    Plane plane;     // khai báo tham chiếu.. ( địa chỉ )
    Plane plane2;
    Plane plane3;

    Bullet bullet;
    Bullet bullet2;
    int check = 1;

    public GameWindow() throws IOException {

        plane = new Plane();
        plane2 = new Plane();
        plane3 = new Plane();
        bullet = new Bullet();
        bullet2 = new Bullet();

        plane.setPositionX(100);
        plane.setPositionY(150);
        plane.setSpeed(3);
        plane.setDirection(0);

        plane2.setPositionX(150);
        plane2.setPositionY(200);
        plane2.setSpeed(3);
        plane2.setDirection(0);

        bullet.setPositionXD(plane.getPositionX());
        bullet.setPositionYD(plane.getPositionY());
        bullet.setSpeedD(5);

        bullet2.setPositionXD(plane2.getPositionX());
        bullet2.setPositionYD(plane2.getPositionY());
        bullet2.setSpeedD(5);

        this.setTitle("1945");
        this.setSize(400,640);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        try{
            background = ImageIO.read(new File("Resouces/Background.png"));
            plane.setSprite(ImageIO.read(new File("Resouces/PLANE1.png"))) ;
            plane2.setSprite(ImageIO.read(new File("Resouces/PLANE4.png")));
            bullet.setSprite(ImageIO.read(new File("Resouces/DAN.png")));
            bullet2.setSprite(ImageIO.read(new File("Resouces/DAN.png")));

        }catch(IOException e){

        }
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
    }

    // ko can hieu (đỡ giật màn hình ..)
    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    // end

    public void paint(Graphics g){
        g.drawImage(background, 0, 0, null);
        plane.draw(g);
        plane2.draw(g);

        if(check == 0) {
            while(true){
                bullet.draw(g);
                bullet2.draw(g);
                bullet.setPositionYD(bullet.getPositionYD() - bullet.getSpeedD());
                bullet2.setPositionYD(bullet2.getPositionYD() - bullet2.getSpeedD());
                if(bullet.getPositionYD() <= 0 && bullet2.getPositionYD() <= 0) break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(" Nhap phím : "+ e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == ' '){
            check = 0;
            bullet.setPositionXD(plane.getPositionX()+30);
            bullet.setPositionYD(plane.getPositionY()-30);
            bullet2.setPositionXD(plane2.getPositionX()+30);
            bullet2.setPositionYD(plane2.getPositionY()-30);
        }
        if(e.getKeyChar() == 'w'){
            plane.setDirection(1);
        }
        if(e.getKeyChar() == 's'){
            plane.setDirection(2);
        }
        if(e.getKeyChar() == 'a'){
            plane.setDirection(3);
        }
        if(e.getKeyChar() == 'd'){
            plane.setDirection(4);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane.setDirection(0) ;
    }

    @Override
    public void run() {
        while(true){
            plane.update();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        plane2.setPositionX(e.getX());
        plane2.setPositionY(e.getY());
        e.consume();
        BufferedImage cursorImg = new BufferedImage(plane2.getPositionX(), plane2.getPositionY(), BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        setCursor(blankCursor);
    }
}
