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
import Supervisor.Supervisor;
import Supervisor.Tutor;
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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

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
    Tutor mainTutor = new Tutor();
    Supervisor mainSV = new Supervisor();
    private boolean close = false;

    /**
     *
     * @param gui
     * @param model
     * @param ssm
     * @param mainTutor
     */
    public studentController(studentView gui, StudentModel model, SessionModel ssm, Tutor mainTutor) {
        this.model = model;
        this.gui = gui;
        this.ssm = ssm;
        this.mainTutor = mainTutor;
        AttachHandler();
    }

    public studentController(studentView gui, StudentModel model, SessionModel ssm, Supervisor mainSV) {
        this.model = model;
        this.gui = gui;
        this.ssm = ssm;
        this.mainSV = mainSV;
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

        gui.getSignOut().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String pass = "";
                Dialog<String> dialog = new Dialog<>();
                dialog.setTitle("Log Out");
                dialog.setHeaderText("Confirm Password");

                Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("/resources/Logo.png"));

                ButtonType loginButtonType = new ButtonType("Log Out", ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);


                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(20, 150, 10, 10));

                PasswordField password = new PasswordField();
                password.setPromptText("Password");

                grid.add(new Label("Password:"), 0, 0);
                grid.add(password, 1, 0);

                dialog.getDialogPane().setContent(grid);

                dialog.setResultConverter(dialogButton -> {
                    if (dialogButton == loginButtonType) {
                        return new String(password.getText());
                    } else {
                        return null;
                    }

                });

                Optional<String> result = dialog.showAndWait();

                if (result.isPresent()) {
                    pass = result.get();
                    if (pass.equals(mainTutor.getPassword())) {
                        setClose(true);
                        loginView v = new loginView();
                        LoginModel m = new LoginModel();
                        loginController logc = new loginController(v, m);
                        Scene scene2 = new Scene(v, 1300, 500);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setTitle("Sign Out");
                        window.setScene(scene2);
                        window.show();

                    } else if (pass.equals(mainSV.getPassword())) {
                        setClose(true);
                        loginView v = new loginView();
                        LoginModel m = new LoginModel();
                        loginController logc = new loginController(v, m);
                        Scene scene2 = new Scene(v, 1300, 500);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setTitle("Sign Out");
                        window.setScene(scene2);
                        window.show();
                    } 
                    
                    else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Unable to Log Out");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Password/Not Authorized!");

                    alert.showAndWait();
                }
                    
                }
                else {
                        setClose(false);
                    }
                
            }
        });

        gui.getTutor().setOnAction((ActionEvent event) -> {

 
            String pass = "";

            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Log In");
            dialog.setHeaderText("Confirm Password");

            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));


            ButtonType loginButtonType = new ButtonType("Log In", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            PasswordField password = new PasswordField();
            password.setPromptText("Password");

            grid.add(new Label("Password:"), 0, 0);
            grid.add(password, 1, 0);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == loginButtonType) {
                    return new String(password.getText());
                } else {
                    return null;
                }

            });
            
            Optional<String> result = dialog.showAndWait();

            if(result.isPresent()){
                pass = result.get();
                if (pass.equals(mainTutor.getPassword())) {
                    tutorView tv;
                    try {
                        setClose(true);
                        tv = new tutorView();
                        tutorController tc = new tutorController(tv);
                        tv.setPass(pass);
                        
                        Scene scene3 = new Scene(tv, 1000, 500);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setTitle("Tutor Information");
                        window.setScene(scene3);
                        window.show();
                    } catch (SQLException ex) {
                        Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Unable to Log In");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Password/Not Authorized!");
                    stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("/resources/Logo.png"));

                    alert.showAndWait();
                }


            }
                 else {
                    setClose(false);
                }
            

        });
        
        gui.getSupervisor().setOnAction((ActionEvent event) -> {


            String pass = "";
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Log In");
            dialog.setHeaderText("Confirm Password");

            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));

            ButtonType loginButtonType = new ButtonType("Log In", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            PasswordField password = new PasswordField();
            password.setPromptText("Password");

            grid.add(new Label("Password:"), 0, 0);
            grid.add(password, 1, 0);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == loginButtonType) {
                    return new String(password.getText());
                } else {
                    return null;
                }

            });


            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                pass = result.get();

                if (pass.equals(mainSV.getPassword())) {
                    infoView tiv = null;
                    try {
                        setClose(true);
                        tiv = new infoView();
                        infoController sc = new infoController(tiv);
                        Scene scene2 = new Scene(tiv, 1000, 500);
                        tiv.setPass(pass);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setTitle("Supervisor");
                        window.setScene(scene2);
                        window.show();
                    } catch (SQLException ex) {
                        Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Unable to Log In");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Password/Not Authorized!");
                    
                    stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("/resources/Logo.png"));

                    alert.showAndWait();
                }
                   

            } else {
               
                setClose(false);

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
            stage.getIcons().add(new Image("/resources/Logo.png"));

            alert.showAndWait();
            return false;
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ERROR!");
            alert.setHeaderText(null);
            alert.setContentText("Invalid ID");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));

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
            stage.getIcons().add(new Image("/resources/Logo.png"));

            alert.showAndWait();
            return false;
        }

        if (!(phoneM.find() && phoneM.group().equals(gui.getPhoneNoTF().getText())) && !(gui.getPhoneNoTF().getText().isEmpty())) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Phone Format");
            alert.setContentText("Invalid input, check phone format before submit it Ex. (999)999-9999");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

            stage.getIcons().add(new Image("/resources/Logo.png"));

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

            stage.getIcons().add(new Image("/resources/Logo.png"));

            alert.showAndWait();
            return false;
        }

        return true;
    }


    /**
     * @return the close
     */
    public boolean isClose() {
        return close;
    }

    /**
     * @param close the close to set
     */
    public void setClose(boolean close) {
        this.close = close;
    }

}
