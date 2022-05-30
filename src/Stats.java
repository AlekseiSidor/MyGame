import java.sql.ResultSet;
import java.sql.SQLException;

public class Stats {
    private int id;
    private boolean WinnerOrNo;
    private int user_id;
    private int timeBattleForSeconds;
    private String vs;

    public Stats(ResultSet rs)throws SQLException {
        this.id = rs.getInt("id");
        this.WinnerOrNo = rs.getBoolean("WinnerOrNo");
        this.user_id = rs.getInt("user_id");
        this.timeBattleForSeconds = rs.getInt("timeBattleForSeconds");
        this.vs = rs.getString("VS");
    }

    public Stats(boolean winnerOrNo,int user_id,int timeBattleForSeconds,String VS){
        this.id = -1;
        this.WinnerOrNo = winnerOrNo;
        this.user_id = user_id;
        this.timeBattleForSeconds = timeBattleForSeconds;
        this.vs = VS;
    }

    public String getInsertQuery() {
        String query = "INSERT INTO 'stats' ('WinnerOrNo', 'user_id', 'timeBattleForSeconds', 'VS') " +
                "VALUES ('" + (this.WinnerOrNo ? "1":"0") + "', '" + this.user_id + "', '"
                + this.timeBattleForSeconds + "', '" + this.vs +
                "');";
        System.out.println(query);
        return query;
    }

    public String getVs() {
        return vs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWinnerOrNo() {
        return WinnerOrNo;
    }

    public void setWinnerOrNo(boolean winnerOrNo) {
        WinnerOrNo = winnerOrNo;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTimeBattleForSeconds() {
        return timeBattleForSeconds;
    }

    public void setTimeBattleForSeconds(int timeBattleForSeconds) {
        this.timeBattleForSeconds = timeBattleForSeconds;
    }
}
