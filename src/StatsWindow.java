import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class StatsWindow extends JFrame {
    JPanel panel;
    JTextField loginTF;
    JPasswordField passwordTF;
    private int HEIGHT = 600, WIDTH = 500;
    public StatsWindow(){
        setTitle("Выбор пользователя");
        setDefaultCloseOperation(3);
        panel = new JPanel();
        getContentPane().add(panel);
        setResizable(false);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addWidgets();
        pack();
        setLocation(300,200);
    }

    public void run(){
        setVisible(true);
    }

    private void addWidgets() {
        panel.setLayout(null);

        JLabel headLBL = new JLabel("ЧЬЮ СТАТИСТИКУ ВЫ ХОТИТЕ ПОСМОТРЕТЬ?");
        headLBL.setBounds(10,40,480,30);
        panel.add(headLBL);

        JLabel loginLBL = new JLabel("ЛОГИН");
        loginLBL.setBounds(10,100,80,20);
        panel.add(loginLBL);

        JLabel passwordLBL = new JLabel("ПАРОЛЬ");
        passwordLBL.setBounds(10,300,80,20);
        panel.add(passwordLBL);

        loginTF = new JTextField();
        loginTF.setBounds(130,100,366,20);
        panel.add(loginTF);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(130,300,366,20);
        panel.add(passwordTF);

        JButton table = new JButton("ПОСМОТРЕТЬ ТАБЛИЦУ");
        table.setBounds(200,400,200,30);
        table.addActionListener(e -> enterClick(e));
        panel.add(table);

        JButton back = new JButton("НАЗАД");
        back.setBounds(250,470,100,20);
        back.addActionListener(e -> backClick(e));
        panel.add(back);
    }

    private void enterClick(ActionEvent e) {
        if (! validateFields()){
            JOptionPane.showMessageDialog(null, "Не все поля заполнены");
            return;
        }
        try {
            String login = loginTF.getText().toLowerCase();
            String password = String.valueOf(passwordTF.getPassword());
            User user = DBconnector.autorization(login, password);
            toMainScreen(user);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Неправильный логин или пароль");
        }
    }

    private boolean validateFields(){
        String login = loginTF.getText();
        String password = String.valueOf(passwordTF.getPassword());
        return  ! (login.trim().isEmpty() || password.trim().isEmpty());
    }

    private void toMainScreen(User user){
        TableWindow w = new TableWindow(user);
        w.run();
        setVisible(false);
        dispose();
    }

    private void backClick(ActionEvent e){
        SelectionWindow window = new SelectionWindow();
        window.run();
        setVisible(false);
        dispose();
    }
}
