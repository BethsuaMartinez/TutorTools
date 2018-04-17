/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutors;

/**
 *
 * @author selvera
 */
public class Tutor {

    private String fname;
    private String lname;
    private int tutorid;
    private String email;
    private String phone;
    private String subject;

    public Tutor() {
        this.fname = "";
        this.lname = "";
        this.tutorid = 0;
        this.email = "";
        this.phone = "";
        this.subject = "";
        
    }

    public Tutor(String fname, String lname, int tutorid, String email, String phone, String subject) {
        this.fname = fname;
        this.lname = lname;
        this.tutorid = tutorid;
        this.email = email;
        this.phone = phone;
        this.subject = subject;
    }
    
    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the tutorid
     */
    public int getTutorid() {
        return tutorid;
    }

    /**
     * @param tutorid the tutorid to set
     */
    public void setTutorid(int tutorid) {
        this.tutorid = tutorid;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

}
