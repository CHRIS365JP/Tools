package work.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenerateDB extends DriverAccessor{

    public void createDB(){

        createUser();
        createIp_history();
        createTweet();

        String userId = "root";
        String userName = "root";
        String password = "root";

        UserDAO userDAO = new UserDAO();
        //rootユーザがいるかチェック(有:1,無:0)
        int flag = userDAO.selectCountByID(userId);

        if(flag == 0){
            userDAO.insertUser(userId, userName, password);
        }else{
            //何もしない(将来的に何か処理があるかもしれないから一応書いておく)
        }

    }

    private void createUser(){


        Connection con = null;
        con = createConnection();

        try {
            String sql = "create table if not exists user("
                    + "id varchar(16) PRIMARY KEY NOT NULL,"
                    + "name varchar(64) NOT NULL,"
                    + "password text NOT NULL)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            stmt.close();
            con = null;
        }catch(SQLException e){


        }finally{

        }
    }

    private void createIp_history(){

        //割愛
    }

    private void createTweet(){

        //割愛
    }
}
