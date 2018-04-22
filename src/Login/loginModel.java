/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Database.MysqlConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author beths
 */
public class loginModel {

    MysqlConnect conn = MysqlConnect.getDbCon();
    ResultSet myRs = null;

    /**
     *
     * @param un
     * @param psswd
     * @return
     * @throws SQLException
     */
    public Boolean loginDB(String un, String psswd) throws SQLException {
        try {
            PreparedStatement myStmt;
            String sql = "SELECT * FROM TutorTools.Tutors where email = ?;";
            String sql1 = "SELECT * FROM TutorTools.Supervisor where email = ?;";

            myStmt = conn.preparedStatement(sql);
            myStmt.setString(1, un);
            
            myRs = myStmt.executeQuery();
            
            myStmt = conn.preparedStatement(sql1);
            myStmt.setString(1, un);
            
            ResultSet myRs2 =null;
            myRs2 = myStmt.executeQuery();

            String chkpsswd = null;
            if (myRs.next()||myRs2.next()) {
                chkpsswd = myRs.getString("password");
                return chkpsswd.equals(psswd);
            }
        } catch (SQLException exc) {
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
        return false;
    }
}
