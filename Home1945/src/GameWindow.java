import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;
    BufferedImage background;
    Plane PlaneKey, PlaneMouse;

    public GameWindow(){
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
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.initPlane();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
               // if(e.getKeyChar() == )

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    private void initPlane() {
        PlaneKey = new Plane(100,200,3,1);
        PlaneMouse = new Plane(150,50,3,1);

    }

    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }

    public void paint(Graphics g){
        g.drawImage(background,0,0,null);
        PlaneKey.draw(g);
    }
    @Override
    public void run(){
        while(true){
            PlaneKey.update();
            try{
                Thread.sleep(17);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

}
