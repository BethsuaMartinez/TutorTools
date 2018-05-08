package Models;

import Database.SQLConnector;
import Student.Student;
import Supervisor.infoView;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author elyvic
 */
public class StudentModel {

    SQLConnector myConn = SQLConnector.getDbCon();
    PreparedStatement myStmt = null;
    ResultSet myRs = null;

    public Boolean verifyUser(int id) throws SQLException {
        try {
            PreparedStatement myStmt;
            String sql = "SELECT * FROM TutorTools.Students where idStudent = ?;";

            myStmt = myConn.preparedStatement(sql);
            myStmt.setInt(1, id);

            myRs = myStmt.executeQuery();
            int chkid = 0;
            if (myRs.next()) {
                chkid = myRs.getInt("idStudent");
                return chkid == (id);

            }

        } catch (SQLException exc) {
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
        return false;
    }

    public Student getStudent(int id) throws SQLException {
        Student student = new Student();
        try {
            PreparedStatement myStmt;
            String sql = "SELECT * FROM TutorTools.Students where idStudent = ?;";

            String fname = null;
            String lname = null;
            String email = null;
            String phone = null;

            myStmt = myConn.preparedStatement(sql);
            myStmt.setInt(1, id);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                fname = myRs.getString("fname");
                lname = myRs.getString("lname");
                email = myRs.getString("email");
                phone = myRs.getString("phone");
            }

            student.setIdStudent(id);
            student.setFname(fname);
            student.setLname(lname);
            student.setEmail(email);
            student.setPhone(phone);

            return student;

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
        return student;
    }
    
    public ObservableList<infoView.studentRowData> searchStudent(String idNo, String fname, String lname) throws SQLException{
        try {
            
            int id;
            
            ObservableList<infoView.studentRowData> studenttableData = FXCollections.observableArrayList();
            String sql="Select * from TutorTools.Students where idStudent =? OR fname =? OR lname=?";
            
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            boolean isNumeric = idNo.chars().allMatch( Character::isDigit );
            if(isNumeric){
                id = Integer.parseInt(idNo);
                myStmt.setInt(1, id);}
            else
                myStmt.setInt(1,0);
            
            myStmt.setString(2, fname);
            myStmt.setString(3, lname);
            
            String email, phone;
            
            myRs = myStmt.executeQuery();
            
            while (myRs.next()) {
                id = myRs.getInt("idStudent");
                fname = myRs.getString("fname");
                lname = myRs.getString("lname");
                email = myRs.getString("email");
                phone = myRs.getString("phone");
                
                idNo=String.valueOf(id);
                
                Student Student= new Student(id, fname, lname, email, phone);
                infoView.studentRowData studentRowData = new infoView.studentRowData(idNo, fname, lname,email, phone);
                studenttableData.add(studentRowData);
            }
            return studenttableData;
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
    public ObservableList<infoView.studentRowData> populateTable() throws SQLException{
        try {
            ObservableList<infoView.studentRowData> studenttableData = FXCollections.observableArrayList();
            String sql="Select * from TutorTools.Students";
            ResultSet myRs = myConn.query(sql);
            int id;
            String fname,  lname,  email,  phone,  password,  subject;

            while (myRs.next()) {
                id = myRs.getInt("idStudent");
                fname = myRs.getString("fname");
                lname = myRs.getString("lname");
                email = myRs.getString("email");
                phone = myRs.getString("phone");
                
                String idNo=String.valueOf(id);
                
                Student currentStudent= new Student(id, fname, lname, email, phone);
                infoView.studentRowData studentRowData = new infoView.studentRowData(idNo, fname, lname,email, phone);
                studenttableData.add(studentRowData);
            }
            return studenttableData;
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

    public void insertStudent(String idNo, String fname, String lname, String email, String phone) throws SQLException {
        try {

            int studentid = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.Students "
                    + "(idStudent, fname, lname, email, phone)"
                    + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setInt(1, studentid);
            myStmt.setString(2, fname);
            myStmt.setString(3, lname);
            myStmt.setString(4, email);
            myStmt.setString(5, phone);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

    public void updateStudent(String idNo, String fname, String lname, String email, String phone) throws SQLException {
        try {

            int tutorid = Integer.parseInt(idNo);

            String sql = "UPDATE Students SET fname = ?, lname=?, email=?, phone=? where idStudent =? ";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setString(1, fname);
            myStmt.setString(2, lname);
            myStmt.setString(3, email);
            myStmt.setString(4, phone);
            myStmt.setInt(5, tutorid);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }

    public void deleteStudent(String idNo) throws SQLException {
        try {

            int tutorid = Integer.parseInt(idNo);

            String sql = "DELETE FROM TutorTools.Students where idStudent =?";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

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