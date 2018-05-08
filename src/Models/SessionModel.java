/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.SQLConnector;
import Student.Session;
import Student.studentView;
import Tutor.tutorView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void insertSession(Session currentData, java.sql.Date sqlDate) throws SQLException {
        try {

            String idNo = currentData.getIdNo();
            String firstName = currentData.getFirstName();
            String lastName = currentData.getLastName();
            String tutor = currentData.getTutor();
            String startTime = currentData.getStartTime();
            String subject = currentData.getSubject();

            int id = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.TutoringSessions "
                    + "(idStudent, fname, lname, tutor, subject, startTime,endTime, date, status)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setInt(1, id);
            myStmt.setString(2, firstName);
            myStmt.setString(3, lastName);
            myStmt.setString(4, tutor);
            myStmt.setString(5, subject);
            myStmt.setString(6, startTime);
            myStmt.setString(7, "");
            myStmt.setDate(8, sqlDate);
            myStmt.setInt(9, 0);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
    

    public void endSession(Session currentData) throws SQLException, ParseException {
        try {
            String tutor = currentData.getTutor();
            String startTime = currentData.getStartTime();
            String idNo = currentData.getIdNo();
            String subject = currentData.getSubject();

            DateFormat format1 = new SimpleDateFormat("HH:mm");
            Date et = new Date();
            String endTime = format1.format(et);
            Date dt = new Date();
            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            String date = format2.format(dt);
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            int id = Integer.parseInt(idNo);
            
            String sql = "UPDATE TutorTools.TutoringSessions SET status = ?, endTime=?, date=? where idStudent =? AND tutor=? AND subject=? AND startTime=? ";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setInt(1, 1);
            myStmt.setString(2, endTime);
            myStmt.setDate(3, sqlDate);
            myStmt.setInt(4, id);
            myStmt.setString(5, tutor);
            myStmt.setString(6, subject);
            myStmt.setString(7, startTime);

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

            String sql = "UPDATE TutorTools.TutoringSessions SET fname = ?, lname=?, tutor=?, subject=? where startTime =? and endTime =? and date=? ";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setString(1, fname);
            myStmt.setString(2, lname);
            myStmt.setString(3, tutor);
            myStmt.setString(4, subject);
            myStmt.setString(5, startTime);
            myStmt.setString(6, endTime);
            myStmt.setString(7, date);
            //myStmt.setInt(8, id);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

    public ObservableList<studentView.RowData> populateCurrentTable() throws SQLException {
        try {
            ObservableList<studentView.RowData> sessiontableData = FXCollections.observableArrayList();

            String sql = "Select * from TutorTools.TutoringSessions where status=0";
            ResultSet myRs = myConn.query(sql);
            int id;
            String idNo, lastName, firstName, tutor, startTime, subject;
            String endTime = "";
            String date = "";

            while (myRs.next()) {
                id = myRs.getInt("idStudent");
                firstName = myRs.getString("fname");
                lastName = myRs.getString("lname");
                tutor = myRs.getString("tutor");
                startTime = myRs.getString("startTime");
                subject = myRs.getString("subject");

                idNo = String.valueOf(id);

                Session currentSession = new Session(idNo, firstName, lastName, tutor, startTime, subject, endTime, date);
                studentView.RowData RowData = new studentView.RowData(firstName, lastName, subject, startTime, idNo, tutor);
                sessiontableData.add(RowData);
            }
            return sessiontableData;
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

    public ObservableList<tutorView.RowData> populateSessionTable() throws SQLException {
        try {
            ObservableList<tutorView.RowData> sessiontableData = FXCollections.observableArrayList();

            String sql = "Select * from TutorTools.TutoringSessions where status=1";
            ResultSet myRs = myConn.query(sql);
            int id;
            String idNo, lastName, firstName, tutor, startTime, subject, endTime, date;

            while (myRs.next()) {
                id = myRs.getInt("idStudent");
                firstName = myRs.getString("fname");
                lastName = myRs.getString("lname");
                tutor = myRs.getString("tutor");
                startTime = myRs.getString("startTime");
                subject = myRs.getString("subject");
                endTime = myRs.getString("endTime");
                date = myRs.getString("date");

                idNo = String.valueOf(id);

                Session currentSession = new Session(idNo, firstName, lastName, tutor, startTime, subject, endTime, date);
                tutorView.RowData RowData = new tutorView.RowData(idNo, firstName, lastName, subject,tutor, startTime, endTime, date);

                sessiontableData.add(RowData);
            }
            return sessiontableData;
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
    public void deleteSession(Session currentSession) throws SQLException {
        try {
            String idNo = currentSession.getIdNo();
            String firstName = currentSession.getFirstName();
            String lastName = currentSession.getLastName();
            String tutor = currentSession.getTutor();
            String startTime = currentSession.getStartTime();
            String subject = currentSession.getSubject();
            String date = currentSession.getDate();
            String endTime = currentSession.getEndTime();
                
            int id = Integer.parseInt(idNo);

            String sql = "DELETE FROM TutorTools.tutoringsessions where idStudent =? and tutor =? and subject =? and startTime =? and endTime=? and date =?";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            
            myStmt.setInt(1, id);
            myStmt.setString(2, tutor);
            myStmt.setString(3, subject);
            myStmt.setString(4, startTime);
            myStmt.setString(5, endTime);
            myStmt.setString(6, date);
            
            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
    public ObservableList<tutorView.RowData> searchSession(String idNo, String fname, String lname, String subject) throws SQLException{
        try {
            
            int id;
            
            ObservableList<tutorView.RowData> sessiontableData = FXCollections.observableArrayList();
            String sql="Select * from TutorTools.tutoringsessions where idStudent =? OR fname =? OR lname=? OR subject=? AND status=1";
            
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            boolean isNumeric = idNo.chars().allMatch( Character::isDigit );
            if(isNumeric){
                id = Integer.parseInt(idNo);
                myStmt.setInt(1, id);}
            else
                myStmt.setInt(1,0);
            
            myStmt.setString(2, fname);
            myStmt.setString(3, lname);
            myStmt.setString(4, subject);
            
            String date, startTime, endTime, tutor;
            
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
                id = myRs.getInt("idStudent");
                fname = myRs.getString("fname");
                lname = myRs.getString("lname");
                subject = myRs.getString("subject");
                tutor = myRs.getString("tutor");
                startTime = myRs.getString("startTime");
                endTime = myRs.getString("endTime");
                date = myRs.getString("date");
                
                idNo=String.valueOf(id);
                
                tutorView.RowData RowData = new tutorView.RowData(idNo, fname, lname, subject,tutor, startTime, endTime, date);

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
