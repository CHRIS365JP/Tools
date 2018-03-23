package work.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DriverAccessor{


    public void insertUser(String userId, String userName, String password){

        Connection con = null;
        con = createConnection();
        try{
            String sql="insert into user values (?,?,?);";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,userId);
            stmt.setString(2, userName);
            stmt.setString(3, password);

            stmt.executeUpdate();

            stmt.close();
            con = null;

        }catch(SQLException e){

        }finally{

        }
    }
    
    public int selectCountByID(String userId) {
        Connection con = null;
        con = createConnection();
        String sql="select * from user where userid = ? ;";
        PreparedStatement stmt;
        int i = 0;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,userId);
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i > 0) {
            i = 1;
        }
        return 0;
    }
}
