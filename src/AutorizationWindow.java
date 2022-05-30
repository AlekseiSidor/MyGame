import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Locale;

public class AutorizationWindow extends JFrame {
    static String login;
    private int HEIGHT = 500, WIDTH = 600;
    JPanel panel;
    public JTextField loginTF;
    JPasswordField passwordTF;
    User user;
    String login1;
    String user_id_stats;
    int i;
    public AutorizationWindow(){
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
        user_id_stats = loginTF.getText();
    }

    private void addWidgets() {
        panel.setLayout(null);

        JLabel autorization = new JLabel("Вход 1 игрока");
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
        registration.addActionListener(e -> regClick(e));
        panel.add(registration);
    }


    private void regClick(ActionEvent e) {
        RegistrationWindow window = new RegistrationWindow();
        window.run();
        setVisible(false);
        dispose();
    }

    private void enterClick(ActionEvent e) {
        if (! validateFields()){
            JOptionPane.showMessageDialog(null, "Не все поля заполнены");
            return;
        }
        try {
            login = loginTF.getText().toLowerCase();
            System.out.println(user_id_stats);
            String password = String.valueOf(passwordTF.getPassword());
            user = DBconnector.autorization(login, password);
            PlayWindow.id = user.getId();
            //System.out.println("id = "+user.getId());
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
            AutorizationWindow2 window = new AutorizationWindow2();
            window.run();
            setVisible(false);
            dispose();
    }

    public void run(){
        setVisible(true);
    }

    public static String getUser_id_stats(){
        return PlayWindow.vs;
    }

}
