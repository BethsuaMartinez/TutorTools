/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.SQLConnector;
import Supervisor.Tutor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        int phone = rs.getInt("phone");

        Tutor tempTutor = new Tutor(id, lastName, firstName, phone);

        return tempTutor;

    }

    public void insertTutor(String idNo, String fname, String lname, String email, String phone, String password, String subject) throws SQLException {
        try {

            int tutorid = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.Students "
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

    public void updateTutor(String idNo, String fname, String lname, String email, String phone, String password, String subject) throws SQLException {
        try {

            int tutorid = Integer.parseInt(idNo);

            String sql = "UPDATE Students SET fname = ?, lname=?, email=?, phone=?, password=? where id =? ";
            PreparedStatement myStmt = conn.preparedStatement(sql);

            myStmt.setInt(1, tutorid);
            myStmt.setString(2, fname);
            myStmt.setString(3, lname);
            myStmt.setString(4, email);
            myStmt.setString(5, phone);
            myStmt.setString(6, password);

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