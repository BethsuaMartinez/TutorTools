/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KennyBoiii
 */
public class TutorDAO {
    
    private Connection con;
    
    public TutorDAO() throws Exception
    {
      
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supervisor", "root", "hello");
            
            System.out.println("DataBase Connection Succesful to: " + "jdbc:mysql://localhost:3306/supervisor");
            
    }
        
            public List<Tutor> getAllTutor() throws Exception{
                List<Tutor> list = new ArrayList<>();
                
                Statement stmt = null;
                ResultSet rs = null;
                
try{
    stmt = con.createStatement();
    rs = stmt.executeQuery("select * from tutor");
    
    while (rs.next()){
       // Tutor tempTutor = convertRowToTutor(rs);
      //  list.add(tempTutor);
    }
    return list;
}
finally{
    close(stmt, rs);
    }
}
            public List<Tutor> searchTutor(String lastName) throws Exception{
                List<Tutor> list = new ArrayList<>();
                
                PreparedStatement stmt = null;
                ResultSet rs = null;
                
                try{
                    lastName+= "%";
                    stmt = con.prepareStatement("select * from tutor where Last Name ?");
                    
                    stmt.setString(1, lastName);
                    rs =stmt.executeQuery();
                    
                    while(rs.next()){
                      //  Tutor tempTutor = convertRowTutor(rs);
                   //     list.add(tempTutor);
                    }
                    
                    return list;
                }
                finally {
                    close(stmt, rs);
                }
            }
            
private Tutor convertRowToTutor(ResultSet rs) throws SQLException{
                int id = rs.getInt("ID Number");
		String lastName = rs.getString("Last Name");
		String firstName = rs.getString("First Name");
		String email = rs.getString("Email");
		int phone = rs.getInt("Phone Number");
		
		Tutor tempTutor = new Tutor(id, lastName, firstName, phone);
		
		return tempTutor;
    
}

private static void close(Connection con, Statement stmt, ResultSet rs)
    throws SQLException {

		if (rs != null) {
			rs.close();
		}

		if (stmt != null) {
			
		}
		
		if (con != null) {
			con.close();
		}
    
}
    
private void close(Statement stmt, ResultSet rs) throws SQLException{
    close(null, stmt, rs);
}

public static void main(String[] args) throws Exception{
    TutorDAO dao = new TutorDAO();
    System.out.println(dao.searchTutor("Kenneth"));
    
}
}
                
                
      
 

