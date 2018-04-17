package MVC;

import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author elyvic
 */
public class Model {
    
    Connection myConn = null;
    PreparedStatement myStmt = null;
    ResultSet myRs = null;
    
    private ObservableList <Data> students = FXCollections.observableArrayList();
    GUI gui = new GUI();
    Data data = new Data();
    
    public void setCurrentStudent(Data currentData){
        data = currentData;
        
        
        Database();
        
    }
    public Data getCurrentStudent(){
        return data;
    }
    
    
    public void Database(){
        try{
        
            String query = "SELECT * From studentdb.sessions;";
            
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/citation", "root", "Sunichi07!");
            myStmt =  myConn.prepareStatement(query);
            myRs = myStmt.executeQuery();
        
        while(myRs.next()){
                students.add(new Data(
                        myRs.getString("id_number"),
                        myRs.getString("first_name"),
                        myRs.getString("last_name"),
                        myRs.getString("email"),
                        myRs.getString("phone_number"),
                        myRs.getString("tutor"),
                        myRs.getString("time")
                        
                        
                ));
               
               myStmt.close(); 
               myRs.close();
            }
            WriteDatabase();
            gui.getTable().setItems(students);
        
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
    
    public void WriteDatabase(){
        try{
            String idNo = data.getIdNo();
            String firstName = data.getFirstName();
            String lastName = data.getLastName();
            String email = data.getEmail();
            String phoneNo = data.getPhoneNo();
            String tutor = data.getTutor();
            String time = data.getTime();
            
            
            String sql = "INSERT INTO studentdb.sessions " + "(id_number, last_name, first_name, email, phone_number, tutor, time)" + "VALUES ('"+idNo+"','"+firstName+"','"+lastName+"','"+email+"','"+phoneNo+"','"+tutor+"','"+time+"')";
            
            myStmt.executeUpdate(sql);
            
            
        }
        catch(Exception e){
            System.err.println(e);
        }
    }

    /**
     * @return the students
     */
    public ObservableList <Data> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ObservableList <Data> students) {
        this.students = students;
    }
}
