import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class RegistrationWindow extends JFrame {
    private int HEIGHT = 700, WIDTH = 600;
    String login;
    JTextField loginTF;
    JPasswordField passwordTF;
    JPasswordField newPasswordTF;
    JTextField ageTF;
    JTextField nameTF;
    JPanel panel;
    public RegistrationWindow(){
        super();
        setTitle("Регистрация");
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
        newPassword.setBounds(10,250,150,25);
        panel.add(newPassword);

        JLabel name = new JLabel("Имя");
        name.setBounds(10,450,100,25);
        panel.add(name);

        JLabel age = new JLabel("Возраст");
        age.setBounds(10,350,100,25);
        panel.add(age);


        loginTF = new JTextField();
        loginTF.setBounds(170,50,300,20);
        panel.add(loginTF);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(170,150,300,20);
        panel.add(passwordTF);

        newPasswordTF = new JPasswordField();
        newPasswordTF.setBounds(170,250,300,20);
        panel.add(newPasswordTF);

        ageTF = new JTextField();
        ageTF.setBounds(170,350,300,20);
        panel.add(ageTF);

        nameTF = new JTextField();
        nameTF.setBounds(170,450,300,20);
        panel.add(nameTF);


        JButton back = new JButton("назад");
        back.setBounds(220,600,70,20);
        back.addActionListener(e -> backCL(e));
        panel.add(back);

        JButton regBTN = new JButton("Регистрация");
        regBTN.setBounds(190, 550, 145, 25);
        regBTN.addActionListener(e -> regClick(e));
        panel.add(regBTN);
    }


    private void regClick(ActionEvent e) {
        User user = validateFields();
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Ошибка заполнения полей");
            return;
        }
        try{
            DBconnector.addUser(user);
            backCL(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Такой пользователь уже существует");
        }
    }

    private User validateFields(){
        login = loginTF.getText();
        System.out.println(login);
        String password = String.valueOf(passwordTF.getPassword());;
        String name = nameTF.getText();
        String age_text = ageTF.getText();
        if ((login.trim().isEmpty() || name.trim().isEmpty()
                || age_text.trim().isEmpty()) )
            return null;
        int age = 0;
        try {
            age = Integer.parseInt(age_text);
        }catch (Exception e){
            return null;
        }
        if (!(password.equals(password) && password.length() > 5))
            return null;
        return new User(login, password,name, age);
    }



    private void backCL(ActionEvent e){
        AutorizationWindow w = new AutorizationWindow();
        setVisible(false);
        w.run();
        dispose();
    }
    public void run(){
        setVisible(true);
    }
}
