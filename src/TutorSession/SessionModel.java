/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TutorSession;

import Database.MysqlConnect;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author selvera
 */
/*public class SessionModel {
    private TutorSession currentSession = new TutorSession();
    MysqlConnect conn = MysqlConnect.getDbCon();
    ResultSet myRs=null;
        
    public void editSession(int i) throws SQLException{
         try {
                myRs= conn.query("SELECT * FROM TutoringSessions;");
                
                String sql="UPDATE `TutoringSessions` (`studentid`, `fname`, "
                            + "`lname`, 'tutorlname', 'startTime', 'endTime',"
                            + "'date', 'subject') VALUES (?,?,?,?,?,?,?,?);";
                PreparedStatement myStmt= conn.preparedStatement(sql);
                myStmt.setInt(1,);
                myStmt.setString(2,);
                myStmt.setString(3,);
                myStmt.setString(4,);
                myStmt.setString(5,);
                myStmt. setString(6,);
                myStmt.setString(7,);
                myStmt.setString(8,);
                
                myStmt.executeUpdate();
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
*/