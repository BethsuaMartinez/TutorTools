/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Database.MysqlConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author selvera
 */
public class loginModel {
    MysqlConnect conn = MysqlConnect.getDbCon();
    ResultSet myRs=null;
    
    public void login(String un, String psswd) throws SQLException{
        try {
            int citationNo;
            PreparedStatement myStmt;
            citationNo= Integer.parseInt(un);
            
            String sql = "SELECT * FROM TutorTools.Tutors where idTutors = ?;";
            
            myStmt = conn.preparedStatement(sql);
            myStmt.setInt(1, citationNo);
            myRs =myStmt.executeQuery();
            
            String chkpsswd = null;
            if (myRs.next()) {
                chkpsswd = myRs.getString("password");
                    if(chkpsswd.equals(psswd))
                        System.out.println("yes");
            }
        }
        catch (SQLException exc) {
        }
        finally {
                if (myRs != null) {
                        myRs.close();
                    }
            }
    }
}
