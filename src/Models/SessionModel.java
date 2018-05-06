/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.SQLConnector;
import Student.Session;
import Student.studentView;
import Supervisor.Tutor;
import Supervisor.infoView;
import Tutor.tutorView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public ObservableList<studentView.RowData> populateCurrentTable() throws SQLException{
        try {
            ObservableList<studentView.RowData> sessiontableData = FXCollections.observableArrayList();
            
            String sql="Select * from TutorTools.TutoringSessions where status=0";
            ResultSet myRs = myConn.query(sql);
            int id;
            String idNo, lastName, firstName, tutor, startTime, subject;
            String endTime="";
            String date="";

            while (myRs.next()) {
                id = myRs.getInt("idStudent");
                firstName = myRs.getString("fname");
                lastName = myRs.getString("lname");
                tutor = myRs.getString("tutor");
                startTime= myRs.getString("startTime");
                subject = myRs.getString("subject");
                        
                idNo=String.valueOf(id);
                
                Session currentSession= new Session(idNo, firstName, lastName, tutor, startTime, subject, endTime, date);
                studentView.RowData RowData = new studentView.RowData (firstName, lastName, subject, startTime, idNo, tutor);
                sessiontableData.add(RowData);
            }
            return sessiontableData;
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

    public ObservableList<tutorView.RowData> populateSessionTable() throws SQLException{
        try {
            ObservableList<tutorView.RowData> sessiontableData = FXCollections.observableArrayList();
            
            String sql="Select * from TutorTools.TutoringSessions where status=1";
            ResultSet myRs = myConn.query(sql);
            int id;
            String idNo, lastName, firstName, tutor, startTime, subject, endTime, date;

            while (myRs.next()) {
                id = myRs.getInt("idStudent");
                firstName = myRs.getString("fname");
                lastName = myRs.getString("lname");
                tutor = myRs.getString("tutor");
                startTime= myRs.getString("startTime");
                subject = myRs.getString("subject");
                endTime= myRs.getString("endTime");
                date= myRs.getString("date");
                        
                idNo=String.valueOf(id);
                
                Session currentSession= new Session(idNo, firstName, lastName, tutor, startTime, subject, endTime, date);
                tutorView.RowData RowData = new tutorView.RowData (idNo, firstName, lastName, subject,tutor, startTime, startTime, date);
                sessiontableData.add(RowData);
            }
            return sessiontableData;
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
}
