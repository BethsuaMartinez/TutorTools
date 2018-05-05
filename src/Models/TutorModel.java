/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.SQLConnector;
import Supervisor.Tutor;
import Supervisor.infoView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author KennyBoiii
 */
public class TutorModel {

    SQLConnector conn = SQLConnector.getDbCon();
    ResultSet myRs = null;
    ResultSet myRs2 = null;

    public List<Tutor> getAllTutor() throws Exception {
        List<Tutor> list = new ArrayList<>();
        ResultSet rs = null;

        try {

            rs = conn.query("select * from tutor");

            while (rs.next()) {
                // Tutor tempTutor = convertRowToTutor(rs);
                //  list.add(tempTutor);
            }
            return list;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    public List<Tutor> searchTutor(String lastName) throws Exception {
        List<Tutor> list = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            lastName += "%";
            stmt = conn.preparedStatement("select * from tutor where lname ?");

            stmt.setString(1, lastName);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //  Tutor tempTutor = convertRowTutor(rs);
                //     list.add(tempTutor);
            }

            return list;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    private Tutor convertRowToTutor(ResultSet rs) throws SQLException {
        int id = rs.getInt("idTutors");
        String lastName = rs.getString("lname");
        String firstName = rs.getString("fname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String subject = rs.getString("subject");
        
        Tutor tempTutor = new Tutor(id, lastName, firstName, email, phone, subject);

        return tempTutor;

    }

    public void insertTutor(String idNo, String fname, String lname, 
            String email, String phone, String password, String subject) throws SQLException {
        try {

            int tutorid = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.Tutors "
                    + "(idTutor, fname, lname, email, phone, password, subject )"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = conn.preparedStatement(sql);

            myStmt.setInt(1, tutorid);
            myStmt.setString(2, fname);
            myStmt.setString(3, lname);
            myStmt.setString(4, email);
            myStmt.setString(5, phone);
            myStmt.setString(6, password);
            myStmt.setString(7, subject);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

    public ObservableList<infoView.tutorRowData> populateTable() throws SQLException{
        try {
            ObservableList<infoView.tutorRowData> tutortableData = FXCollections.observableArrayList();
            String sql="Select * from TutorTools.Tutors";
            ResultSet myRs = conn.query(sql);
            int id;
            String fname,  lname,  email,  phone,  password,  subject;

            while (myRs.next()) {
                id = myRs.getInt("idTutor");
                fname = myRs.getString("fname");
                lname = myRs.getString("lname");
                email = myRs.getString("email");
                phone = myRs.getString("phone");
                subject = myRs.getString("subject");
                
                String idNo=String.valueOf(id);
                
                Tutor currentTutor= new Tutor(id, fname, lname, email, phone, subject);
                infoView.tutorRowData tutorRowData = new infoView.tutorRowData(idNo, fname, lname,email, subject, phone);
                tutortableData.add(tutorRowData);
            }
            return tutortableData;
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
    public void updateTutor(String idNo, String fname, String lname, String email, String phone, String password, String subject) throws SQLException {
        try {

            int tutorid = Integer.parseInt(idNo);

            String sql = "UPDATE Tutors SET fname = ?, lname=?, email=?, phone=?, password=? where idTutor =? ";
            PreparedStatement myStmt = conn.preparedStatement(sql);

            myStmt.setString(1, fname);
            myStmt.setString(2, lname);
            myStmt.setString(3, email);
            myStmt.setString(4, phone);
            myStmt.setString(5, password);
            myStmt.setInt(6, tutorid);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
     public void deleteTutor(String idNo) throws SQLException {
        try {

            int tutorid = Integer.parseInt(idNo);

            String sql = "DELETE FROM TutorTools.Tutors where idTutor =?";
            PreparedStatement myStmt = conn.preparedStatement(sql);

            myStmt.setInt(1, tutorid);

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
