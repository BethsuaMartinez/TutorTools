/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Database.SQLConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author beths
 */
public class loginModel {

    SQLConnector conn = SQLConnector.getDbCon();
    ResultSet myRs = null;
    ResultSet myRs2 =null;

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
            PreparedStatement myStmt2;
            String sql = "SELECT * FROM TutorTools.Tutors where email = ?;";
            String sql1 = "SELECT * FROM TutorTools.Supervisor where email = ?;";

            myStmt = conn.preparedStatement(sql);
            myStmt.setString(1, un);
            
            myRs = myStmt.executeQuery();
            
            myStmt2 = conn.preparedStatement(sql1);
            myStmt2.setString(1, un);
            
            
            myRs2 = myStmt2.executeQuery();

            String chkpsswd = null;
            if (myRs.next()) {
                chkpsswd = myRs.getString("password");
                return chkpsswd.equals(psswd);
              
            }
            else if(myRs2.next()){
               chkpsswd = myRs2.getString("password");
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
