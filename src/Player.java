import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player  {
    Image img;
    private int x=20,y=20;
    public Player(){
        try {
            img = ImageIO.read(new File("Images/pistol.jpg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stepUp(){move(0,-50);}
    public void stepDown(){move(0,50);}

    public void move (int x, int y){
        this.x += x;
        this.y += y;
    }
    public void draw(Graphics g){
        g.drawImage(img, x,y,100,50,null);
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
}
