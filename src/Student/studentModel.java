package Student;

import Database.MysqlConnect;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author elyvic
 */
public class studentModel {

    MysqlConnect myConn = MysqlConnect.getDbCon();
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

    public void WriteDatabase(Data currentData) throws SQLException {
        try {

            String firstName = currentData.getFirstName();
            String lastName = currentData.getLastName();
            String tutor = currentData.getTutor();
            String endTime = currentData.getTime();
            String startTime = currentData.getStartTime();
            String idNo = currentData.getIdNo();
            String subject = currentData.getSubject();

            int id = Integer.parseInt(idNo);

            String sql = "INSERT INTO TutorTools.TutoringSessions "
                    + "(studentid, fname, lname, tutorlname, subject, startTime, endTime)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement myStmt = myConn.preparedStatement(sql);

            myStmt.setInt(1, id);
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
