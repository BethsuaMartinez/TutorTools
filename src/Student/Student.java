/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author selvera
 */
public class Student {
    private int idStudent;
    private String fname;
    private String lname;
    private String email;
    private String phone;

    public Student() {
    }

    public Student(int idStudent, String fname, String lname, String email, String phone) {
        this.idStudent = idStudent;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }
    
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
