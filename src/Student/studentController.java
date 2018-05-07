/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import Login.loginController;
import Login.loginView;
import Models.LoginModel;
import Models.SessionModel;
import Models.StudentModel;
import Supervisor.infoView;

import Supervisor.infoController;

import Tutor.tutorController;
import Tutor.tutorView;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

import javafx.scene.image.Image;

import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author elyvic
 */
public class studentController {

    StudentModel model = new StudentModel();
    studentView gui;
    SessionModel ssm = new SessionModel();

    public studentController(studentView gui, StudentModel model, SessionModel ssm) {
        this.model = model;
        this.gui = gui;
        this.ssm = ssm;
        AttachHandler();
    }

    public void AttachHandler() {

        gui.getAddBtn().setOnAction((ActionEvent event) -> {
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

            gui.ClearFields();

            signInStage.setTitle("Sign-In");
            signInStage.getIcons().add(new Image("/resources/Logo.png"));
            signInStage.setScene(newIdScene);
            signInStage.show();

        });

        gui.getSubmitSs().setOnAction((ActionEvent event) -> {
            Stage signInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            String idNo = gui.getIdNoTF().getText();
            String tutor = gui.getTutors();
            String subject = gui.getSubjects();

            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            String startTime = dateFormat.format(date);

            int id = Integer.parseInt(idNo);

            Student student;
            try {
                Date dt = new Date();
                DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                String sdate = format2.format(dt);
                Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                
                student = model.getStudent(id);
                String fname = student.getFname();
                String lname = student.getLname();

                Session currentSession = new Session(idNo, lname, fname, tutor, startTime, subject, "", "");

                gui.updateTable(currentSession);
                ssm.insertSession(currentSession, sqlDate);

                signInStage.close();
                gui.ClearFields();

            } catch (SQLException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            signInStage.close();
            gui.ClearFields();

            //((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        });

        gui.getTutor().setOnAction((ActionEvent event) -> {
            tutorView tv;
            try {
                tv = new tutorView();
                tutorController tc = new tutorController(tv);
                Scene scene3 = new Scene(tv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Tutor Information");
                window.getIcons().add(new Image("/resources/Logo.png"));
                window.setScene(scene3);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        gui.getSupervisor().setOnAction((ActionEvent event) -> {
            infoView tiv;
            try {
                tiv = new infoView();

                Scene scene2 = new Scene(tiv, 1000, 500);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Supervisor");
                window.setScene(scene2);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        gui.getTutor().setOnAction((ActionEvent event) -> {
            tutorView tv;
            try {
                tv = new tutorView();
                tutorController tc = new tutorController(tv);
                Scene scene3 = new Scene(tv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.getIcons().add(new Image("/resources/Logo.png"));
                window.setTitle("Tutor Information");
                window.setScene(scene3);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        gui.getSupervisor().setOnAction((ActionEvent event) -> {
            infoView tiv = null;

            try {
                tiv = new infoView();
            } catch (SQLException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            infoController sc = new infoController(tiv);

            Scene scene2 = new Scene(tiv, 1000, 500);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.getIcons().add(new Image("/resources/Logo.png"));
            window.setTitle("Supervisor");
            window.setScene(scene2);
            window.show();
        });

        gui.getSubmitId().setOnAction((ActionEvent event) -> {
            Stage signInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if (validateID()) {
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
                        signInStage.getIcons().add(new Image("/resources/Logo.png"));
                        signInStage.show();

                    } else {
                        VBox newStudentVbox = gui.newStudentVBox();
                        Scene newStudentScene = new Scene(newStudentVbox, 300, 270);
                        signInStage.getIcons().add(new Image("/resources/Logo.png"));
                        signInStage.setScene(newStudentScene);
                        signInStage.show();

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        });

        gui.getBackNew().setOnAction((ActionEvent event) -> {
            Stage signInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            VBox studentIdVbox = gui.addSession();
            Scene newIdScene = new Scene(studentIdVbox, 210, 110);
            signInStage.setTitle("Sign-In");

            signInStage.getIcons().add(new Image("/resources/Logo.png"));
            signInStage.setScene(newIdScene);
            signInStage.show();
        });

        gui.getSubmitSt().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                //if ("".equals(gui.getIdNoTF().getText())) {
                //   gui.wrongPass();
                //}
                if (validateNewStudentFields() == true) {

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
                        signInStage.getIcons().add(new Image("/resources/Logo.png"));
                        signInStage.setScene(newSessionScene);
                        signInStage.show();
                    } catch (SQLException ex) {
                        Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

        // gui.getSe
        gui.getSignOut().setOnAction((ActionEvent event) -> {

            /*loginView v = new loginView();
            LoginModel m = new LoginModel();
            loginController logc = new loginController(v, m);
            Scene scene2 = new Scene(v, 1300, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Sign In");
            window.setScene(scene2);
            window.show(); */

 /*Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage signInStage = new Stage();
            
            signInStage.initModality(Modality.APPLICATION_MODAL);
            signInStage.initOwner(window);

            VBox signOut = gui.signOut();
            
            Scene newSessionScene = new Scene(signOut, 215, 95);
            signInStage.setTitle("Sign Out");
            signInStage.setScene(newSessionScene);
            signInStage.show();*/
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Password");
            dialog.setHeaderText("Confirm Password Before Logout");
            dialog.setContentText("Please enter your password:");
            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));

            Session session = new Session();

            Optional<String> result = dialog.showAndWait();
            String pass = "";
            if (result.isPresent()) {
                pass = result.get();

                loginView v = new loginView();
                LoginModel m = new LoginModel();
                loginController logc = new loginController(v, m);
                Scene scene2 = new Scene(v, 1300, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Sign In");
                window.getIcons().add(new Image("/resources/Logo.png"));
                window.setScene(scene2);
                window.show();

            }

        });

        gui.getSignOutBtn().setOnAction((ActionEvent event) -> {
            Stage signOutStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            signOutStage.close();
            Stage signInStage = new Stage();

            loginView v = new loginView();
            LoginModel m = new LoginModel();
            loginController logc = new loginController(v, m);
            Scene scene2 = new Scene(v, 1300, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.getIcons().add(new Image("/resources/Logo.png"));
            window.setTitle("Sign In");
            window.setScene(scene2);
            window.show();
        });

        gui.getTutor().setOnAction((ActionEvent event) -> {
            /*tutorView tv;
            Scene scene1 = gui.getTutor().getScene();
            try {
                tv = new tutorView();
                tutorController tc = new tutorController(tv);
              
                Scene scene3 = new Scene(tv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Tutor Information");
                window.setScene(scene3);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            }*/

            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Password");
            dialog.setHeaderText("Confirm Password");
            dialog.setContentText("Please enter your password:");
            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));

            Session session = new Session();

            Optional<String> result = dialog.showAndWait();
            String pass = "";
            if (result.isPresent()) {
                pass = result.get();

                tutorView tv;
                Scene scene1 = gui.getTutor().getScene();
                try {
                    tv = new tutorView();
                    tutorController tc = new tutorController(tv);

                    Scene scene3 = new Scene(tv, 1000, 500);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Tutor Information");
                    window.getIcons().add(new Image("/resources/Logo.png"));
                    window.setScene(scene3);
                    window.show();
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        gui.getSupervisor().setOnAction((ActionEvent event) -> {
            /*infoView tiv = null;
            try {
                tiv = new infoView();
                infoController sc = new infoController(tiv);

                Scene scene2 = new Scene(tiv, 1000, 500);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Supervisor");
                window.setScene(scene2);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
            }*/

            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Password");
            dialog.setHeaderText("Confirm Password");
            dialog.setContentText("Please enter your password:");
            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));

            Session session = new Session();

            Optional<String> result = dialog.showAndWait();
            String pass = "";
            if (result.isPresent()) {
                pass = result.get();

                infoView tiv = null;
                try {
                    tiv = new infoView();
                    infoController sc = new infoController(tiv);

                    Scene scene2 = new Scene(tiv, 1000, 500);

                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Supervisor");
                    window.getIcons().add(new Image("/resources/Logo.png"));
                    window.setScene(scene2);
                    window.show();
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    private boolean validateID() {
        Pattern idP = Pattern.compile("[0-9]+");
        Matcher idM = idP.matcher(gui.getIdNoTF().getText());

        if (idM.find() && idM.group().equals(gui.getIdNoTF().getText())) {
            return true;
        } else if (gui.getIdNoTF().getText().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ERROR!");
            alert.setHeaderText(null);
            alert.setContentText("Empty Field");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));
            alert.showAndWait();
            return false;
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ERROR!");
            alert.setHeaderText(null);
            alert.setContentText("Invalid ID");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));
            alert.showAndWait();

            return false;

        }
    }

    public boolean validateNewStudentFields() {
        boolean idConf = true;
        boolean fNameConf = true;
        boolean lNameConf = true;

        Pattern emailP = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher emailM = emailP.matcher(gui.getEmailTF().getText());

        Pattern phoneP = Pattern.compile("\\(\\d{3}\\)\\d{3}-\\d{4}");
        Matcher phoneM = phoneP.matcher(gui.getPhoneNoTF().getText());

        Pattern idP = Pattern.compile("[0-9]+ ");
        Matcher idM = idP.matcher(gui.getIdNoTF().getText());

        if (!(emailM.find() && emailM.group().equals(gui.getEmailTF().getText())) && !(gui.getEmailTF().getText().isEmpty())) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Email Format");
            alert.setContentText("Invalid input, check email format before submit it Ex. sudent@example.edu");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));
            alert.showAndWait();
            return false;
        }

        if (!(phoneM.find() && phoneM.group().equals(gui.getPhoneNoTF().getText())) && !(gui.getPhoneNoTF().getText().isEmpty())) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warnig");
            alert.setHeaderText("Wrong Phone Format");
            alert.setContentText("Invalid input, check phone format before submit it Ex. (999)999-9999");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));
            alert.showAndWait();
            return false;
        }

        if (idM.find() && idM.group().equals(gui.getIdNoTF().getText())) {
            idConf = false;

        }

        if (gui.getFirstNameTF().getText().isEmpty()) {
            fNameConf = false;
        }

        if (gui.getLastNameTF().getText().isEmpty()) {
            lNameConf = false;
        }

        if (gui.getLastNameTF().getText().isEmpty()) {
            lNameConf = false;
        }

        if (fNameConf == false || lNameConf == false || idConf == false) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ERROR!");
            alert.setHeaderText(null);
            alert.setContentText("Missing Required Fields or Wrong Format");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));
            alert.showAndWait();
            return false;
        }

        return true;
    }

}
