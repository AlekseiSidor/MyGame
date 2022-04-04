import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;

public class MyPanel extends JPanel {
    boolean b = false;
    ArrayList<Patron> patrons;
    Timer t1;
    Timer t2;
    Player player;
    Player2 player2;
    Patron patron;
    int x;
    int y,n=0,n1 = 0;
    public MyPanel(){
        patrons = new ArrayList<>();
        player = new Player();
        player2 = new Player2();
        patron = new Patron();
        y = player.getY();
        x =patron.getX();
    }

    public void shoot(){
        patron.shoot();
        repaint();
    }
    public void shoot1(){
        patrons.add(new Patron());
        repaint();
      //  t1 = new Timer(1000, e -> shoot());
       // n1 = 1;
       // while(n == 0){
           //  n++;
         //// t1.start();
       // }
    }

    public void control_player(KeyEvent e) {
        x = patron.getX();
        int code = e.getKeyCode();
        switch (e.getKeyCode()) {
            case 87:
                if (player.getY() > 20) {
                    player.stepUp();
                    if (n1 != 1) {
                       // y -= 50;
                    }
                }
                    break;
            case 83:
                if (player.getY() < 620) {
                    player.stepDown();
                    if (n1 != 1) {
                        //y += 50;
                    }
                    break;
                }
            case 70:
                if (x < 1000) {
                    //shoot1();
                    patrons.add(new Patron());
                  //  b = true;
                  //  break;
                }
            case 38:if(player2.getY() > 20)
                player2.stepUp();
                break;
            case 40:if (player2.getY() < 620)
                player2.stepDown();
                break;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Patron patron : patrons) {
                patron.draw1(g);
            }
        g.fillRect(0,0,1000,20);
        g.fillRect(0,0,20,700);
        g.fillRect(0,680,1000,20);
        g.fillRect(980,0,20,700);
        g.fillRect(490,0,20,700);
        player.draw(g);
        player2.draw(g);
    }
}
