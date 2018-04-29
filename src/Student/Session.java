/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author elyvic
 */
public class Session {

    private SimpleStringProperty idNo;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty tutor;
    private SimpleStringProperty endTime;
    private SimpleStringProperty subject;
    private SimpleStringProperty startTime;
    private SimpleStringProperty date;

    public Session() {
    }

    public Session(String idNo, String lastName, String firstName, String tutor, String startTime, String subject, String endTime, String date) {
        this.idNo = new SimpleStringProperty(idNo);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.tutor = new SimpleStringProperty(tutor);
        this.endTime = new SimpleStringProperty(endTime);
        this.subject = new SimpleStringProperty(subject);
        this.startTime = new SimpleStringProperty(startTime);
        this.date = new SimpleStringProperty(date);
    }

    /**
     * ******************
     * setters and getter *
    *******************
     */
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
     * @return the endTime
     */
    public String getEndTime() {
        return endTime.get();
    }

    /**
     * @param time the endTime to set
     */
    public void setEndTime(String time) {
        this.endTime.set(time);
    }

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

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject.get();
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime.get();
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime.set(startTime);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
