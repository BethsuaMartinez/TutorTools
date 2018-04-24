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

    private ObservableList<Data> students = FXCollections.observableArrayList();
    Data data = new Data();

    public void setCurrentStudent(Data currentData) throws SQLException {
        data = currentData;
        Database();
    }

    public Data getCurrentStudent() {
        return data;
    }

    public void Database() throws SQLException {
        try {

            String query = "SELECT * From TutorTools.TutoringSessions;";

            myStmt = myConn.preparedStatement(query);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                students.add(new Data(
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

    public void WriteDatabase(Data currentData) throws SQLException {
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
                    + "(id, studentid, fname, lname, tutorlname, subject, endTime,startTime)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setInt(1, (sizeDB() + 1));
            myStmt.setInt(2, studentid);
            myStmt.setString(3, firstName);
            myStmt.setString(4, lastName);
            myStmt.setString(5, tutor);
            myStmt.setString(6, subject);
            myStmt.setString(7, startTime);
            myStmt.setString(8, endTime);

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
    public ObservableList<Data> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ObservableList<Data> students) {
        this.students = students;
    }
}
