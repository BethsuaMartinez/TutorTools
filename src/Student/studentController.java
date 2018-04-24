/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import Supervisor.TutorInformationView;
import Supervisor.supervisorController;
import Tutor.tutorController;
import Tutor.tutorView;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author elyvic
 */
public class studentController {
    
    studentModel model = new studentModel();
    studentView gui = new studentView();
    
    public studentController(studentView gui, studentModel model) {
        this.model = model;
        this.gui = gui;
        
        AttachHandler();
    }
    
    public void AttachHandler() {
        gui.getAddBtn().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              gui.addSession();
            }
        });
        
        gui.getSubmitBtn().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date date = new Date();
                
                String idNo = gui.getIdNoTF().getText();
                String firstName = gui.getFirstNameTF().getText();
                String lastName = gui.getLastNameTF().getText();
                String tutor = gui.getTutorTF().getText();
                String subject = gui.getSubjectTF().getText();
                String time = dateFormat.format(date);
                
                
                Data currentSession = new Data(idNo, lastName, firstName, tutor, time, subject, "");
                gui.updateTable(currentSession);
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            }
        });
        
        gui.getTutor().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                tutorView tv = new tutorView();
                tutorController tc = new tutorController(tv);
                Scene scene3 = new Scene(tv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();
                
            }
        });
        
        gui.getSupervisor().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                TutorInformationView tiv = new TutorInformationView();
                supervisorController sc = new supervisorController(tiv);
                Scene scene2 = new Scene(tiv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene2);
                window.show();
                
            }
        });
        
        gui.getIdNoSubmitBtn().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               String id = gui.getIdNoTF().getText();
               int x = Integer.parseInt(id);
                try {
                if(true==model.verifyUser(x))
                    gui.newSession();
                else
                    gui.newStudent();
                
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
    }
}
