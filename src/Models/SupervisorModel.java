/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.SQLConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author selvera
 */
public class SupervisorModel {

    SQLConnector conn = SQLConnector.getDbCon();
    ResultSet myRs = null;
    ResultSet myRs2 = null;

    public void insertSupervisor(String idNo, String fname, String lname, String email, String phone, String password) throws SQLException {
        try {

            int supervisorid = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.Supervisor "
                    + "(idSupervisor, fname, lname, email, phone, password)"
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = conn.preparedStatement(sql);

            myStmt.setInt(1, supervisorid);
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

    public void updateSupervisor(String idNo, String fname, String lname, String email, String phone, String password) throws SQLException {
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
    
        public void deleteSupervisor(String idNo) throws SQLException {
        try {

            int studentid = Integer.parseInt(idNo);

            String sql = "DELETE FROM TutorTools.Supervisor where idSupervisor =?";
            PreparedStatement myStmt = conn.preparedStatement(sql);

            myStmt.setInt(1, studentid);

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
