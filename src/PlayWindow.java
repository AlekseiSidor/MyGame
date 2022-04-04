import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayWindow extends JFrame {
    MyPanel panel;
    private final int WIDTH = 1000, HEIGHT = 700;

     class keylistener implements KeyListener {

         @Override
         public void keyTyped(KeyEvent e) {

         }

         @Override
         public void keyPressed(KeyEvent e) {
            panel.control_player(e);
            //panel.control_player1(e);
         }

         @Override
         public void keyReleased(KeyEvent e) {

         }
     }

    public PlayWindow(){
        super();
        panel = new MyPanel();
        setTitle("Игра");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Container c = getContentPane();
        c.add(panel);
        addWidgets();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pack();
        setLocation(100, 100);
        addKeyListener(new keylistener());
        setFocusable(true);
    }
    public void run(){
        setVisible(true);
    }

    private void addWidgets() {

    }
}
