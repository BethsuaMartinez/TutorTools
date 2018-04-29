/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.SQLConnector;
import Student.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author selvera
 */
public class SessionModel {

    SQLConnector myConn = SQLConnector.getDbCon();
    PreparedStatement myStmt = null;
    ResultSet myRs = null;

    public void insertSession(Session currentData) throws SQLException {
        try {

            String firstName = currentData.getFirstName();
            String lastName = currentData.getLastName();
            String tutor = currentData.getTutor();
            String endTime = currentData.getEndTime();
            String startTime = currentData.getStartTime();
            String idNo = currentData.getIdNo();
            String subject = currentData.getSubject();
            String date = currentData.getDate();

            int studentid = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.TutoringSessions "
                    + "(idStudent, fname, lname, tutor, subject, endTime,startTime, date)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setInt(1, studentid);
            myStmt.setString(2, firstName);
            myStmt.setString(3, lastName);
            myStmt.setString(4, tutor);
            myStmt.setString(5, subject);
            myStmt.setString(6, startTime);
            myStmt.setString(7, endTime);
            myStmt.setString(8, date);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

}
