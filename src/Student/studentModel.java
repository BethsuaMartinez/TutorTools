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
    studentView gui = new studentView();
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
                
                WriteDatabase();
                gui.getTable().setItems(students);
            }
                catch (SQLException exc) {
        }
        finally {
                if (myRs != null) {
                        myRs.close();
                    }
            }
    }

    public void WriteDatabase() {
        try {
            String idNo = data.getIdNo();
            String firstName = data.getFirstName();
            String lastName = data.getLastName();
            String email = data.getEmail();
            String phoneNo = data.getPhoneNo();
            String tutor = data.getTutor();
            String time = data.getTime();

            String sql = "INSERT INTO TutorTools.TutoringSessions " + "(studentid, fname, lname, tutorlname, time, email, phone)" + "VALUES ('" + idNo + "','" + firstName + "','" + lastName + "','" + tutor + "','" + time + "','" + email + "','" + phoneNo + "')";

            myStmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e);
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
