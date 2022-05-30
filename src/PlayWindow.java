import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

public class PlayWindow extends JFrame {
    static boolean winnerOrNo;
    static boolean winnerOrNo1;
    boolean b = true;
    static Timer seconds;
    static int second = 0;
    MyPanel panel;
    static String vs;
    static String vs1;
    MyPanel p;
    User user;
    static int id;
    static int id1;
    AutorizationWindow window;
    private final int WIDTH = 1000, HEIGHT = 800;
    int i = 0;

     class keylistener implements KeyListener {

         @Override
         public void keyTyped(KeyEvent e) {

         }

         @Override
         public void keyPressed(KeyEvent e) {
            panel.control_player(e);
         }

         @Override
         public void keyReleased(KeyEvent e) {

         }
     }
     public PlayWindow(){

     }

    public PlayWindow(User user){
        super();
        second = 0;
        p = new MyPanel();
        window = new AutorizationWindow();
        this.user = user;
        panel = new MyPanel();
        setTitle("Игра");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Container c = getContentPane();
        c.add(panel);
        addWidgets();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pack();
        setLocation(100, 0);
        addKeyListener(new keylistener());
        setFocusable(true);
        Timer t = new Timer(1000,e -> timer());
        t.start();
        seconds = new Timer(1000,e -> seconds());
        seconds.start();
    }

     private void seconds(){
      second++;

      System.out.println(second);
      if (!b) {
          seconds.stop();
      }
     }

    public void run(){
        setVisible(true);
    }

    private void timer(){
         i++;
    }


    private void addWidgets() {
         panel.setLayout(null);

         JButton back = new JButton("НАЗАД");
         back.setBounds(450,710,100,30);
         back.addActionListener(e -> backClick(e));
         panel.add(back);
    }

    private void backClick(ActionEvent e){
         b = false;
        Stats stats = validateFields();
        Stats stats1 = validateFields1();
        try {
            DBconnector.addStats(stats);
            DBconnector.addStats(stats1);
            toMainScreen(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Такой пользователь уже существует");
        }
    }

    private Stats validateFields(){
         return new Stats(winnerOrNo,id,PlayWindow.second,vs);
    }

    private Stats validateFields1(){
        return new Stats(winnerOrNo1,id1,PlayWindow.second,vs1);
    }

    private void toMainScreen(ActionEvent e){
        SelectionWindow window = new SelectionWindow();
        window.run();
        setVisible(false);
        dispose();
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
