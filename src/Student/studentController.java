/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import Login.loginController;
import Login.loginModel;
import Login.loginView;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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
                
                
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Stage signInStage = new Stage();
                signInStage.initModality(Modality.APPLICATION_MODAL);
                signInStage.initOwner(window);
                
                VBox layout = new VBox();
                layout = gui.addSession();     
                
                Scene newIdScene = new Scene(layout, 210, 110);
                signInStage.setTitle("Sign-In");
                
                signInStage.setScene(newIdScene);
                        
                
                signInStage.show();
                
               
            }
        });
        //Submit to table
        gui.getSubmitSs().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage signInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();

                String idNo = gui.getIdNoTF().getText();
                String tutor = gui.getTutorTF().getText();
                String subject = gui.getSubjectTF().getText();
                String startTime = dateFormat.format(date);
                System.out.println(idNo + tutor + subject + startTime);
                
                int id = Integer.parseInt(idNo);

                Student student;
                try {
                    student = model.getStudent(id);
                    String fname = student.getFname();
                    String lname = student.getLname();


                    Session currentSession = new Session(idNo, lname, fname, tutor, startTime, subject, "", "");
                    gui.updateTable(currentSession);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                signInStage.close();
                gui.ClearFields();
                //((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                
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
                Stage signInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                if ("".equals(gui.getIdNoTF().getText())) {
                    gui.wrongPass();
                }
                String id = gui.getIdNoTF().getText();
                int x = Integer.parseInt(id);
                
                try {
                    if (true == model.verifyUser(x)) {
                        //GridPane newSessionGridpane = gui.newSession();
                        VBox newSessionVbox = gui.newSessionVBox();
                        Scene newSessionScene = new Scene(newSessionVbox, 250, 130);
                        signInStage.setScene(newSessionScene);
                        signInStage.show();
                        
                        
                    } else {
                        VBox newStudentVbox =  gui.newStudentVBox();
                        Scene newStudentScene = new Scene(newStudentVbox, 300, 270);
                        signInStage.setScene(newStudentScene);
                        signInStage.show();
                        
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });

        gui.getBackNew().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage signInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                VBox studentIdVbox = gui.addSession();
                Scene newIdScene = new Scene(studentIdVbox, 210, 110);
                signInStage.setTitle("Sign-In");
                signInStage.setScene(newIdScene);
                signInStage.show();
            }
        });

        gui.getSubmitSt().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                //if ("".equals(gui.getIdNoTF().getText())) {
                 //   gui.wrongPass();
                //}
                String idNo = gui.getIdNoTF().getText();
                String firstName = gui.getFirstNameTF().getText();
                String lastName = gui.getLastNameTF().getText();
                String email = gui.getEmailTF().getText();
                String phone = gui.getPhoneNoTF().getText();
                
                try {
                    Stage signInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    model.insertStudent(idNo, firstName, lastName, email, phone);
                    VBox newSession = gui.newSessionVBox();
                    Scene newSessionScene = new Scene(newSession, 250, 130);
                    signInStage.setScene(newSessionScene);
                    signInStage.show();
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        gui.getSignOut().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginView v = new loginView();
                loginModel m = new loginModel();
                loginController logc = new loginController(v, m);
                Scene scene2 = new Scene(v, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Sign In");
                window.setScene(scene2);
                window.show();
            }
        });
    }
}
