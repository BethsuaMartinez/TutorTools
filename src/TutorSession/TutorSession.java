/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TutorSession;
import java.util.Date;

/**
 *
 * @author selvera
 */
public class TutorSession {

    private Date date;
    
    public TutorSession() {
        this.date = new Date();
    }

    public TutorSession(Date date) {
        this.date = date;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
