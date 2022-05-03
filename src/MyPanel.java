import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class MyPanel extends JPanel {
    private boolean b = true;
    int n = 0;
    int i = 0;
    int m = 0;
    int abc;
   // Timer seconds;
    int second = 0;
    Player player;
    Player2 player2;
    Patron patron2;
    Patron patron;
    Timer t;
    Timer t2;
    Timer t1;
    Timer lose;
    int x = 70;
    int x1 = 880;
    int y,y1;int y2=20; int y3;
    public MyPanel(){
        player = new Player();
        player2 = new Player2();
        patron = new Patron();
        patron2 = new Patron();
        y = player.getX();
        t = new Timer(16,e -> shoot());
        t.start();
        t2 = new Timer(16,e-> shoot1());
        t2.start();
        t1 = new Timer(700,e -> patron());
        t1.start();
        lose = new Timer(1,e -> lose());
        lose.start();
        //секундомер
        //seconds = new Timer(1000,e -> seconds());
        //seconds.start();
        //секундомер
    }

    public void shoot(){
        x1 -= 20;
        if (x1 < 0){
            x1 = 880;
        }
        repaint();
    }

    public void shoot1(){
        x += 20;
        if (x > 980){
            x = 70;
        }
    }

    public void patron(){
        i = 0;
    }

    public void lose(){
        if (x - 50 > 880 && y1 >= player2.getY() && y1 <= player2.getY()){
            b = false;
            abc = 1;
        }
        if (x1 < 70 && y3 >= player.getY() && y3 <= player.getY()){
            b = false;
            abc = -1;
        }
    }


    public void control_player(KeyEvent e) {
        int code = e.getKeyCode();
        switch (e.getKeyCode()) {
            case 87:
                if (player.getY() > 20) {
                    player.stepUp();
                    y-=50;
                }
                    break;
            case 83:
                if (player.getY() < 620) {
                    player.stepDown();
                    y += 50;
                }
                    break;
            case 38:if(player2.getY() > 20) {
                player2.stepUp();
                y2 -= 50;
            }
                break;
            case 40:if (player2.getY() < 620) {
                player2.stepDown();
                y2 += 50;
            }
                break;
        }
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (b){
        if (n == 0) {
            if (i < 1) {
                y1 = y;
                y3 = y2;
                i += 1000;
            }
        }
            //patron2.draw(g, x1, y3);//патрон который летит влево
            patron.draw1(g, x, y1);//патрон который летит вправо
            g.fillRect(0, 0, 1000, 20);
            g.fillRect(0, 0, 20, 700);
            g.fillRect(0, 680, 1000, 20);
            g.fillRect(980, 0, 20, 700);
            g.fillRect(490, 0, 20, 700);
            player.draw(g);
            player2.draw(g);
        }else{
            t.stop();
            t1.stop();
            t2.stop();
            lose.stop();
        }
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public int getAbc() {
        return abc;
    }
}
