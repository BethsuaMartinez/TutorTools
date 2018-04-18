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
    public Boolean login(String un, String psswd) throws SQLException {
        try {
            PreparedStatement myStmt;
            String sql = "SELECT * FROM TutorTools.Tutors where email = ?;";

            myStmt = conn.preparedStatement(sql);
            myStmt.setString(1, un);

            myRs = myStmt.executeQuery();

            String chkpsswd = null;
            if (myRs.next()) {
                chkpsswd = myRs.getString("password");
                if (chkpsswd.equals(psswd)) {
                    return true;
                } else {
                    return false;
                }
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
