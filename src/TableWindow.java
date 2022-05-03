import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableWindow extends JFrame {
    private int HEIGHT = 800, WIDTH = 800;
    private User currentUser;
    String[] columns;
    JTable table;
    DefaultTableModel model;
    JPanel panel;
    public TableWindow(User user){
        super();
        this.currentUser = user;
        setTitle("Таблица");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(100,200);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        getContentPane().add(panel);
        pack();
        addWidgets();
        System.out.println(currentUser.getName());
    }
    public void run(){
        setVisible(true);
    }

    private String[][] convertStatsToStrings(ArrayList<Stats> mas){
        int n = mas.size();
        String ans[][] = new String[n][4];
        for (int i = 0; i < n; i++){
            //ans[i][0] = mas.get(i).getId() + "";
            ans[i][0] = mas.get(i).getId() + "";
            ans[i][1] = (mas.get(i).isWinnerOrNo() ? "Да" : "Нет");
            ans[i][2] = mas.get(i).getTimeBattleForSeconds() + "";
            ans[i][3] = mas.get(i).getVs();
        }
        return ans;
    }

    private void addWidgets() {
        setLayout(null);

        String data[][] = new String[0][];
        try {
            data = convertStatsToStrings(DBconnector.getStats(currentUser));
            columns = new String[]{"id", "Победил", "Время битвы", "Играл против"};
            model = new DefaultTableModel(data, columns);
            //model.addTableModelListener(this);
            table = new JTable(model);
            JScrollPane tableWithScroll = new JScrollPane(table);
            tableWithScroll.setBounds(5, 80, 790, 515);
            panel.add(tableWithScroll);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        JLabel nameLBL = new JLabel(currentUser.getName());
        nameLBL.setBounds(15, 25, 150, 25);
        panel.add(nameLBL);
    }
}
