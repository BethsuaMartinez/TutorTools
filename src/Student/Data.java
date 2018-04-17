/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author elyvic
 */
public class Data {
    private SimpleStringProperty idNo;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty email;
    private SimpleStringProperty phoneNo;
    private SimpleStringProperty tutor;
    private SimpleStringProperty time;
    
    
    public Data(){ 
    }
    
    public Data(String idNo, String lastName, String firstName, String email, String phoneNo, String tutor, String time){
        this.idNo = new SimpleStringProperty(idNo);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.email = new SimpleStringProperty(email);
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.tutor = new SimpleStringProperty(tutor);
        this.time = new SimpleStringProperty(time);
        
        
    }
    
    
    /********************
    *setters and getter *
    ********************/
    
    /**
     * @return the idNo
     */
    public String getIdNo() {
        return idNo.get();
    }

    /**
     * @param idNo the idNo to set
     */
    public void setIdNo(String idNo) {
        this.idNo.set(idNo);
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName.get();
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email.set(email);
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo.get();
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo.set(phoneNo);
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time.get();
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time.set(time);
    }

    /**
     * @return the date
     */


    /**
     * @return the tutor
     */
    public String getTutor() {
        return tutor.get();
    }

    /**
     * @param tutor the tutor to set
     */
    public void setTutor(String tutor) {
        this.tutor.set(tutor);
    }
}
