import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class MyPanel extends JPanel {
    private boolean b = true;
    int n = 0;
    int i = 0;
    int i1 = 0;
    static int abc;
    boolean b1 = true;
    boolean b2 = true;
    PlayWindow w;
    Player player;
    Player2 player2;
    Patron patron2;
    Patron patron;
    Timer t;
    Timer t2;
    Timer lose;
    int x = 70;
    int x1 = 880;
    int y,y1;int y2=20; int y3;
    public MyPanel(){
        w = new PlayWindow();
        player = new Player();
        player2 = new Player2();
        patron = new Patron();
        patron2 = new Patron();
        y = player.getX();
        t = new Timer(16,e -> shoot());
        t2 = new Timer(16,e-> shoot1());
        lose = new Timer(1,e -> lose());
        lose.start();
    }

    public void shoot(){
        x1 -= 30;
        repaint();
    }

    public void shoot1(){
        x += 30;
        repaint();
    }

    public void lose(){
        if (x - 50 > 880 && y1 >= player2.getY() && y1 <= player2.getY()){
            b = false;
            PlayWindow.seconds.stop();
            PlayWindow.winnerOrNo = true;
            PlayWindow.winnerOrNo1 = false;
        }
        if (x1 < 70 && y3 >= player.getY() && y3 <= player.getY()){
            b = false;
            PlayWindow.seconds.stop();
            PlayWindow.winnerOrNo = false;
            PlayWindow.winnerOrNo1 = true;
        }
    }


    public void control_player(KeyEvent e) {
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
            case 37: if(b1){
                x1 = 880;
                i = 0;
                b1 = false;
                t.start();
            }
            break;
            case 68: if(b2){
                x = 70;
                i1 = 0;
                b2 = false;
                t2.start();
            }
            break;
        }
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (b){
            if (i1 < 1){
                y1 = y;
                i1+=1000;
            }
            if (i < 1) {
                y3 = y2;
                i += 1000;
            }
        if(!b1) {
            patron2.draw(g, x1, y3);//патрон который летит влево
            if(x1 < -50){
                b1 = true;
                x1 = 2000;
                t.stop();
                i = 0;
                i1 = 0;
                patron2.draw(g, x1, y3);//патрон который летит влево
            }
        }
            if(!b2) {
                patron.draw1(g, x, y1);//патрон который летит вправо
                if (x > 950){
                b2 = true;
                x = -2000;
                t2.stop();
                i1 = 0;
                patron.draw1(g, x, y1);//патрон который летит вправо
                }
            }
            g.fillRect(0, 0, 1000, 20);
            g.fillRect(0, 0, 20, 700);
            g.fillRect(0, 680, 1000, 20);
            g.fillRect(980, 0, 20, 700);
            g.fillRect(490, 0, 20, 700);
            player.draw(g);
            player2.draw(g);
        }else{
            t.stop();
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


}
