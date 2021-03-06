import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;

public class Patron {
    Player player;
    Timer timer;
    Image img;
    Image img2;
    private int x=70,y=20;
    int x1 = 880;

    public Patron(){
        player = new Player();
        try {
            img = ImageIO.read(new File("Images/patron.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            img2 = ImageIO.read(new File("Images/patron2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //timer = new Timer(1,e ->shoot());
    }

    public void draw(Graphics g,int x,int y){
        g.drawImage(img, x, y, 50,25,null);
    }
    public void draw1(Graphics g,int x,int y){
        g.drawImage(img2, x, y, 50,25,null);
    }


    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg2() {
        return img2;
    }

    public void setImg2(Image img2) {
        this.img2 = img2;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
