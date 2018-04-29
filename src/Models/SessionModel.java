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

            int id = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.TutoringSessions "
                    + "(id, fname, lname, tutor, subject, endTime,startTime, date)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setString(1, firstName);
            myStmt.setString(2, lastName);
            myStmt.setString(3, tutor);
            myStmt.setString(4, subject);
            myStmt.setString(5, startTime);
            myStmt.setString(6, endTime);
            myStmt.setString(7, date);
            myStmt.setInt(18, id);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
    public void updateSession(Session currentData) throws SQLException {
        try {

            String fname = currentData.getFirstName();
            String lname = currentData.getLastName();
            String tutor = currentData.getTutor();
            String endTime = currentData.getEndTime();
            String startTime = currentData.getStartTime();
            String idNo = currentData.getIdNo();
            String subject = currentData.getSubject();
            String date = currentData.getDate();

            int id = Integer.parseInt(idNo);

            String sql = "UPDATE TutorTools.TutoringSessions SET fname = ?, lname=?, tutor=?, subject=?, endTime=?, startTime=?, date=? where id =? ";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setString(1, fname);
            myStmt.setString(2, lname);
            myStmt.setString(3, tutor);
            myStmt.setString(4, subject);
            myStmt.setString(5, startTime);
            myStmt.setString(6, endTime);
            myStmt.setString(7, date);
            myStmt.setInt(8, id);

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
