package Student;

import Database.SQLConnector;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author elyvic
 */
public class studentModel {   
    
    SQLConnector myConn = SQLConnector.getDbCon();
    PreparedStatement myStmt = null;
    ResultSet myRs = null;

    private ObservableList<Session> students = FXCollections.observableArrayList();
    Session data = new Session();

    public void setCurrentStudent(Session currentData) throws SQLException {
        data = currentData;
        Database();
    }

    public Session getCurrentStudent() {
        return data;
    }

    public void Database() throws SQLException {
        try {

            String query = "SELECT * From TutorTools.TutoringSessions;";

            myStmt = myConn.preparedStatement(query);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                students.add(new Session(
                        myRs.getString("studentid"),
                        myRs.getString("fname"),
                        myRs.getString("lname"),
                        myRs.getString("tutorlname"),
                        myRs.getString("time"),
                        myRs.getString("email"),
                        myRs.getString("phone")
                ));
            }

            //WriteDatabase();
        } catch (SQLException exc) {
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
    }
    
    public Boolean verifyUser(int id) throws SQLException{
         try {
            PreparedStatement myStmt;
            String sql = "SELECT * FROM TutorTools.Students where idStudents = ?;";

            myStmt = myConn.preparedStatement(sql);
            myStmt.setInt(1, id);
            
            myRs = myStmt.executeQuery();
            int chkid = 0;
            if (myRs.next()) {
                chkid = myRs.getInt("idStudents");
                return chkid==(id);
              
            }

        } catch (SQLException exc) {
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
        return false;
    }
    
    public int sizeDB() throws SQLException {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM TutoringSessions";
            myRs = myConn.query(sql);
            while (myRs.next()) {
                count = myRs.getInt("COUNT(*)");
            }
            return count;
        } catch (SQLException exc) {
        } finally {
            if (myRs != null) {
                myRs.close();
            }
        }
        return count;
    }

    public void WriteDatabase(Session currentData) throws SQLException {
        try {

            String firstName = currentData.getFirstName();
            String lastName = currentData.getLastName();
            String tutor = currentData.getTutor();
            String endTime = currentData.getTime();
            String startTime = currentData.getStartTime();
            String idNo = currentData.getIdNo();
            String subject = currentData.getSubject();

            int studentid = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.TutoringSessions "
                    + "(studentid, fname, lname, tutorlname, subject, endTime,startTime)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = myConn.preparedStatement(sql);
            
            myStmt.setInt(1, studentid);
            myStmt.setString(2, firstName);
            myStmt.setString(3, lastName);
            myStmt.setString(4, tutor);
            myStmt.setString(5, subject);
            myStmt.setString(6, startTime);
            myStmt.setString(7, endTime);

            myStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
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
                    + "(idStudents, fname, lname, email, phone)"
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

    /**
     * @return the students
     */
    public ObservableList<Session> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ObservableList<Session> students) {
        this.students = students;
    }
}
