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
        //Submit to table
        gui.getSubmitSs().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();

                String idNo = gui.getIdNoTF().getText();
                String tutor = gui.getTutorTF().getText();
                String subject = gui.getSubjectTF().getText();
                String startTime = dateFormat.format(date);

                int id = Integer.parseInt(idNo);

                Student student;
                try {
                    student = model.getStudent(id);
                    String fname = student.getFname();
                    String lname = student.getLname();
                    String email = student.getEmail();
                    String phone = student.getPhone();

                    Session currentSession = new Session(idNo, lname, fname, tutor, startTime, subject, "", "");
                    gui.updateTable(currentSession);
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            }
        });

        gui.getTutor().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                tutorView tv = new tutorView();
                tutorController tc = new tutorController(tv);
                Scene scene3 = new Scene(tv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Tutor Information");
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
                window.setTitle("Supervisor");
                window.setScene(scene2);
                window.show();

            }
        });

        gui.getSubmitId().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                if ("".equals(gui.getIdNoTF().getText())) {
                    gui.wrongPass();
                }
                String id = gui.getIdNoTF().getText();
                int x = Integer.parseInt(id);
                try {
                    if (true == model.verifyUser(x)) {
                        gui.newSession();
                    } else {
                        gui.newStudent();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        gui.getBackNew().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gui.addSession();
            }
        });
        
        gui.getSubmitSt().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                if ("".equals(gui.getNewStudentIdNoTF().getText())) {
                    gui.wrongPass();
                }
                
                String idNo = gui.getNewStudentIdNoTF().getText();
                String firstName = gui.getFirstNameTF().getText();
                String lastName = gui.getLastNameTF().getText();
                String email = gui.getEmailTF().getText();
                String phone = gui.getPhoneNoTF().getText();

                try {
                    model.insertStudent(idNo, firstName, lastName, email, phone);
                    gui.newSession();
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
}
