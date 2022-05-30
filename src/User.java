import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private int age;

    public User(){

    }

    public User(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.login = rs.getString("login");
        this.password = rs.getString("password");
        this.name = rs.getString("name");
        this.age = rs.getInt("age");
    }

    public User(String login, String password, String name, int age) {
        this.login = login.toLowerCase();
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public String getInsertQuery() {
        String query = "INSERT INTO 'users' ('login', 'password', 'name', 'age') " +
                "VALUES ('" + this.login + "', '" + this.password + "', '" + this.name +
                "', '" + this.age + "');";
        //System.out.println(query);
        return query;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}