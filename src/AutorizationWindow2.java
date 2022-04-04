import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AutorizationWindow2 extends JFrame {
    private int HEIGHT = 500, WIDTH = 600;
    JPanel panel;
    public AutorizationWindow2(){
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

        JLabel autorization = new JLabel("Вход 2 игрока");
        autorization.setBounds(200,20,100,50);
        panel.add(autorization);

        JLabel loginLabel = new JLabel("Логин");
        loginLabel.setBounds(50,150,100,20);
        panel.add(loginLabel);

        JLabel passwordLabel = new JLabel("Пароль");
        passwordLabel.setBounds(50,250,100,20);
        panel.add(passwordLabel);

        JTextField login = new JTextField();
        login.setBounds(200,150,400,20);
        panel.add(login);

        JPasswordField password = new JPasswordField();
        password.setBounds(200,250,400,20);
        panel.add(password);

        JButton button = new JButton("Войти");
        button.setBounds(260,400,100,30);
        button.addActionListener(e -> buttonClick(e));
        panel.add(button);

        JButton registration = new JButton("Регистрация");
        registration.setBounds(250,450,120,19);
        registration.addActionListener(e -> registrationClick());
        panel.add(registration);
    }

    private void registrationClick(){
        RegistrationWindow w = new RegistrationWindow();
        setVisible(false);
        w.run();
    }

    private void buttonClick(ActionEvent e){
        SelectionWindow window = new SelectionWindow();
        window.run();
        setVisible(false);
    }

    public void run(){
        setVisible(true);
    }
}
