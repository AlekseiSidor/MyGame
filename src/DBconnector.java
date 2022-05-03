import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;

public class DBconnector{

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void conn() throws ClassNotFoundException,SQLException{
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:db/users.db");
        statmt = conn.createStatement();
    }

    public static void createTables()throws ClassNotFoundException,SQLException{
        createUserTable();
        createStatsTable();
    }

    private static void createUserTable() throws ClassNotFoundException,SQLException{
        statmt.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                "    id       INTEGER      PRIMARY KEY\n" +
                "                          UNIQUE\n" +
                "                          NOT NULL,\n" +
                "    login    VARCHAR (25) NOT NULL\n" +
                "                          UNIQUE,\n" +
                "    password VARCHAR (40) NOT NULL,\n" +
                "    name     VARCHAR (30) NOT NULL,\n" +
                "    age      INTEGER\n" +
                ");");

        System.out.println("yes");
    }

    private static void createStatsTable() throws ClassNotFoundException,SQLException{
        statmt.execute("CREATE TABLE IF NOT EXISTS stats (\n" +
                "    id                   INTEGER PRIMARY KEY\n" +
                "                                 UNIQUE\n" +
                "                                 NOT NULL,\n" +
                "    WinnerOrNo           BOOLEAN NOT NULL,\n" +
                "    user_id              INTEGER NOT NULL\n" +
                "                                 REFERENCES users (id),\n" +
                "    timeBattleForSeconds INTEGER NOT NULL,\n" +
                "VS                   VARCHAR (25) NOT NULL\n" +
                ");");
    }
    public static void addUser(User user)throws SQLException {
        statmt.execute(user.getInsertQuery());
    }
    public static void addStats(Stats stats)throws SQLException {
        statmt.execute(stats.getInsertQuery());
    }


    public static User autorization(String login, String password) throws SQLException {
        String query = "SELECT * FROM users " +
                "WHERE login = '" + login + "' AND " +
                "password = '" + password + "';";
        System.out.println(query);
        resSet = statmt.executeQuery(query);
        User user = new User(resSet);
        System.out.println(user.getName());
        return user;
    }

    public static ArrayList<Stats> getStats(User user)throws SQLException{
        String query = "SELECT * FROM stats\n" +
                "WHERE user_id = " + user.getId();
        resSet = statmt.executeQuery(query);
        ArrayList<Stats> list = new ArrayList<>();
        while(resSet.next())
            list.add(new Stats(resSet));
        return list;
    }

    //public static ArrayList<News> getNews(User user) throws SQLException {
      //  String query = "SELECT * FROM news\n" +
       //         "WHERE private = 0 OR user_id = " + user.getId();
      //  System.out.println(query);
      //  resSet = statmt.executeQuery(query);
     //   ArrayList<News> list = new ArrayList<>();
    //    while(resSet.next())
     //       list.add(new News(resSet));
     //   return list;
   // }
}
