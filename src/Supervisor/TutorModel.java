/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Database.MysqlConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KennyBoiii
 */
public class TutorModel {

    MysqlConnect con = MysqlConnect.getDbCon();

    public List<Tutor> getAllTutor() throws Exception {
        List<Tutor> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            
            rs = con.query("select * from tutor");

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
            stmt = con.preparedStatement("select * from tutor where lname ?");

            stmt.setString(1, lastName);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //  Tutor tempTutor = convertRowTutor(rs);
                //     list.add(tempTutor);
            }

            return list;
        } finally {
           if (rs != null) 
                rs.close();
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
}
