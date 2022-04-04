import javax.swing.*;
import java.awt.*;

public class RegistrationWindow extends JFrame {
    private int HEIGHT = 700, WIDTH = 600;
    JPanel panel;
    public RegistrationWindow(){
        super();
        setTitle("Вход");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addWidgets();
        getContentPane().add(panel);
        pack();
        setLocation(300, 200);
    }

    private void addWidgets() {
        panel.setLayout(null);

        JLabel registr = new JLabel("Регистрация");
        registr.setBounds(210,10,400,50);
        panel.add(registr);

        JLabel login = new JLabel("Логин");
        login.setBounds(10,50,100,25);
        panel.add(login);

        JLabel password = new JLabel("Пароль");
        password.setBounds(10,150,100,25);
        panel.add(password);

        JLabel newPassword = new JLabel("Повторите пароль");
        newPassword.setBounds(10,250,100,25);
        panel.add(newPassword);

        JLabel name = new JLabel("ФИО");
        name.setBounds(10,350,100,25);
        panel.add(name);

        JLabel age = new JLabel("Возраст");
        age.setBounds(10,450,100,25);
        panel.add(age);


        JTextField loginTF = new JTextField();
        loginTF.setBounds(170,50,300,20);
        panel.add(loginTF);

        JPasswordField passwordTF = new JPasswordField();
        passwordTF.setBounds(170,150,300,20);
        panel.add(passwordTF);

        JPasswordField newPasswordTF = new JPasswordField();
        newPasswordTF.setBounds(170,250,300,20);
        panel.add(newPasswordTF);

        JTextField ageTF = new JTextField();
        ageTF.setBounds(170,350,300,20);
        panel.add(ageTF);

        JTextField nameTF = new JTextField();
        nameTF.setBounds(170,450,300,20);
        panel.add(nameTF);


        JButton back = new JButton("назад");
        back.setBounds(220,600,70,20);
        back.addActionListener(e -> back());
        panel.add(back);
    }
    private void back(){
        AutorizationWindow w = new AutorizationWindow();
        setVisible(false);
        w.run();
    }
    public void run(){
        setVisible(true);
    }
}
