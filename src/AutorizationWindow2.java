import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AutorizationWindow2 extends JFrame {
    static String login;
    AutorizationWindow window;
    private JTextField loginTF;
    private JPasswordField passwordTF;
    private int HEIGHT = 500, WIDTH = 600;
    JPanel panel;
    public AutorizationWindow2(){
        super();
        window = new AutorizationWindow();
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

        loginTF = new JTextField();
        loginTF.setBounds(200,150,400,20);
        panel.add(loginTF);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(200,250,400,20);
        panel.add(passwordTF);

        JButton button = new JButton("Войти");
        button.setBounds(260,400,100,30);
        button.addActionListener(e -> enterClick(e));
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
        dispose();
    }

    private void enterClick(ActionEvent e) {
        if (! validateFields()){
            JOptionPane.showMessageDialog(null, "Не все поля заполнены");
            return;
        }
            try {
                login = loginTF.getText().toLowerCase();
                String password = String.valueOf(passwordTF.getPassword());
                User user = DBconnector.autorization(login, password);
                PlayWindow.vs1 = AutorizationWindow.login;
                PlayWindow.vs = AutorizationWindow2.login;
                PlayWindow.id1 = user.getId();
                System.out.println("vs1= " + PlayWindow.vs1);
                toMainScreen(user);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка авторизации");
            }
    }

    private boolean validateFields(){
        String login = loginTF.getText();
        String password = String.valueOf(passwordTF.getPassword());
        return  ! (login.trim().isEmpty() || password.trim().isEmpty());
    }

    private void toMainScreen(User user){
        SelectionWindow window = new SelectionWindow();
        window.run();
        setVisible(false);
        dispose();
    }

    public void run(){
        setVisible(true);
    }
}
