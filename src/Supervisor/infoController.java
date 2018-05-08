/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Login.loginController;
import Login.loginView;
import Mail.MailView;
import Mail.mailController;
import Models.LoginModel;
import Models.SessionModel;
import Models.StudentModel;
import Models.SupervisorModel;
import Models.TutorModel;
import Student.Student;
import Student.studentController;
import Student.studentView;
import Tutor.tutorView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author selvera
 */
public class infoController {

    infoView tiv;
    tutorView tv;

    ActivitylogView alv;
    SupervisorModel sm = new SupervisorModel();
    StudentModel stm = new StudentModel();

    Student currentStudent = new Student();
    Tutor currentTutor = new Tutor();
    TutorModel tm = new TutorModel();

    Supervisor mainSV = new Supervisor();

    //Tutor mainTutor = new Tutor();
    public infoController(infoView tiv) {
        this.tiv = tiv;
        attachHandlers();
    }

    private void attachHandlers() {

        tiv.getSignOut().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginView v = new loginView();
                LoginModel m = new LoginModel();
                loginController logc = new loginController(v, m);
                Scene scene2 = new Scene(v, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.getIcons().add(new Image("/resources/Logo.png"));
                window.setTitle("Sign In");
                window.setScene(scene2);
                window.show();
            }
        });

        tiv.getBack().setOnAction((ActionEvent event) -> {
            studentView sv;
            try {
                sv = new studentView();
                StudentModel sm = new StudentModel();
                SessionModel ssm = new SessionModel();
                studentController sc = new studentController(sv, sm, ssm, mainSV);
                mainSV.setPassword(tiv.getPass());

                Scene scene3 = new Scene(sv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.getIcons().add(new Image("/resources/Logo.png"));
                window.setTitle("Student List");
                window.setScene(scene3);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        tiv.getActivity().setOnAction((ActionEvent event) -> {
            ActivitylogView alv1;
            try {
                alv1 = new ActivitylogView();
                alv1.setPass(tiv.getPass());
                activityController ac = new activityController(alv1);
                Scene scene3 = new Scene(alv1, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.getIcons().add(new Image("/resources/Logo.png"));
                window.setTitle("Activity Log");
                window.setScene(scene3);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        tiv.getAdd().setOnAction((ActionEvent event) -> {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);

            Scene scene;
            tiv.ClearFields();

            if ("Tutor".equals(tiv.getTypePerson())) {
                scene = new Scene(tiv.addTutor(), 400, 250);
            } else {
                scene = new Scene(tiv.addStudent(), 350, 250);
            }

            window.setTitle("Add");
            window.getIcons().add(new Image("/resources/Logo.png"));
            window.setScene(scene);
            window.show();
        });
        
        tiv.getAddSupervisor().setOnAction((ActionEvent event) -> {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);

            Scene scene;
            tiv.ClearFields();
            
            scene = new Scene(tiv.addSupervisor(), 400, 250);

            window.setTitle("Add Supervisor");
            window.getIcons().add(new Image("/resources/Logo.png"));
            window.setScene(scene);
            window.show();
        });

        tiv.getSubmitSupervisor().setOnAction((ActionEvent event) -> {

            if (validateSupervisorFields()) {
                String idNo = tiv.getIdTF().getText();
                String firstName = tiv.getfNameTF().getText();
                String lastName = tiv.getlNameTF().getText();
                String email = tiv.getEmailTF().getText();
                String phoneNo = tiv.getPhoneTF().getText();
                String password = tiv.getPasswordTF().getText();
                int id = Integer.parseInt(idNo);

                Supervisor currentSupervisor = new Supervisor(id, firstName, lastName, email, phoneNo, password);
                try {
                    sm.insertSupervisor(idNo, firstName, lastName, email, phoneNo, password);
                } catch (SQLException ex) {
                    Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.close();
                tiv.ClearFields();
            }
        });
        
        tiv.getNewTutorSubmitBtn().setOnAction((ActionEvent event) -> {

            if (validateTutorFields()) {
                String idNo = tiv.getIdTF().getText();
                String firstName = tiv.getfNameTF().getText();
                String lastName = tiv.getlNameTF().getText();
                String email = tiv.getEmailTF().getText();
                String phoneNo = tiv.getPhoneTF().getText();
                String subject = tiv.getSubjectTF().getText();
                String password = tiv.getPasswordTF().getText();
                int id = Integer.parseInt(idNo);

                Tutor currentTutor = new Tutor(id, firstName, lastName, email, phoneNo, subject, password);
                try {
                    tm.insertTutor(idNo, firstName, lastName, email, phoneNo, password, subject);
                } catch (SQLException ex) {
                    Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                tiv.updateTutorTable(currentTutor);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.close();
                tiv.ClearFields();
            }
        });

        
        tiv.getStudentSubmitBtn().setOnAction((ActionEvent event) -> {

            if (validateStudentFields()) {
                String idNo = tiv.getIdTF().getText();
                String firstName = tiv.getfNameTF().getText();
                String lastName = tiv.getlNameTF().getText();
                String email = tiv.getEmailTF().getText();
                String phoneNo = tiv.getPhoneTF().getText();

                int id = Integer.parseInt(idNo);

                Student currentStudent = new Student(id, firstName, lastName, email, phoneNo);

                try {
                    stm.insertStudent(idNo, firstName, lastName, email, phoneNo);
                    tiv.updateStudentTable(currentStudent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.close();
                    tiv.ClearFields();
                } catch (SQLException ex) {
                    Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        tiv.getEmail().setOnAction((ActionEvent event) -> {
            MailView mv = new MailView();
            mailController mc = new mailController(mv);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage signInStage = new Stage();
            signInStage.initModality(Modality.APPLICATION_MODAL);
            signInStage.initOwner(window);

            VBox layout = mv;

            Scene newIdScene = new Scene(layout, 500, 300);
            signInStage.setTitle("E-Mail");
            signInStage.getIcons().add(new Image("/resources/Logo.png"));
            signInStage.setScene(newIdScene);
            signInStage.show();
        });

        tiv.getSearch().setOnAction((ActionEvent event) -> {
            try {
                String search = tiv.getSearchTF().getText();
                String idNo = search;
                String fname = search;
                String lname = search;
                String subject = search;

                if ("Tutor".equals(tiv.getTypePerson())) {
                    if (search.isEmpty()) {
                        tiv.updateTutorTable();
                    } else {
                        tiv.searchTutor(idNo, fname, lname, subject);
                    }
                } else {
                    if (search.isEmpty()) {
                        tiv.updateStudentTable();
                    } else {
                        tiv.searchStudent(idNo, fname, lname);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        tiv.getModify().setOnAction((ActionEvent event) -> {
            Stage modifyStage = new Stage();
            modifyStage.initModality(Modality.APPLICATION_MODAL);
            modifyStage.getIcons().add(new Image("/resources/Logo.png"));

            Scene modifyScene;

            if ("Tutor".equals(tiv.getTypePerson())) {
                if (tiv.confirmTutorModify() == true) {
                    modifyScene = new Scene(tiv.modifyTutor(), 350, 300);
                    modifyStage.setTitle("Modify");
                    modifyStage.setScene(modifyScene);
                    modifyStage.show();
                }
            } else if (tiv.confirmStudentModify() == true) {
                modifyScene = new Scene(tiv.modifyStudent(), 350, 300);
                modifyStage.setTitle("Modify");
                modifyStage.setScene(modifyScene);
                modifyStage.show();
            }
        });

        tiv.getDelete().setOnAction((ActionEvent event) -> {
            try {
                tiv.deleteFromTable();
            } catch (SQLException ex) {
                Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        tiv.getModifyTutor().setOnAction((ActionEvent event) -> {
            if (validateTutorFields()) {
                String idNo = tiv.getIdTF().getText();
                String firstName = tiv.getfNameTF().getText();
                String lastName = tiv.getlNameTF().getText();
                String email = tiv.getEmailTF().getText();
                String phoneNo = tiv.getPhoneTF().getText();
                String subject = tiv.getSubjectTF().getText();
                String password = tiv.getPasswordTF().getText();
                int id = Integer.parseInt(idNo);

                Tutor currentTutor = new Tutor(id, firstName, lastName, email, phoneNo, subject, password);
                try {
                    tm.updateTutor(idNo, firstName, lastName, email, phoneNo, password, subject);
                    tiv.updateTutorTable();
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.close();
                    tiv.ClearFields();
                } catch (SQLException ex) {
                    Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        tiv.getModifyStudent().setOnAction((ActionEvent event) -> {
            if (validateStudentFields()) {
                String idNo = tiv.getIdTF().getText();
                String firstName = tiv.getfNameTF().getText();
                String lastName = tiv.getlNameTF().getText();
                String email = tiv.getEmailTF().getText();
                String phoneNo = tiv.getPhoneTF().getText();

                int id = Integer.parseInt(idNo);

                Student currentStudent = new Student(id, firstName, lastName, email, phoneNo);
                try {
                    stm.updateStudent(idNo, firstName, lastName, email, phoneNo);
                    tiv.updateStudentTable();
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.close();
                    tiv.ClearFields();
                } catch (SQLException ex) {
                    Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    boolean validateTutorFields() {
        boolean confID = true;
        boolean confFN = true;
        boolean confLN = true;
        boolean confS = true;
        boolean confE = true;
        EmailValidator emailValidator = EmailValidator.getInstance();
        Pattern p = Pattern.compile("\\(\\d{3}\\)\\d{3}-\\d{4}");
        Matcher m = p.matcher(tiv.getPhoneTF().getText());

        if (tiv.getIdTF().getText().isEmpty() || !(tiv.getIdTF().getText().matches("\\d+"))) {
            confID = false;
        }

        if (tiv.getfNameTF().getText().isEmpty() || tiv.getfNameTF().getText().contains("[0-9]+")) {
            confFN = false;
        }

        if (tiv.getlNameTF().getText().isEmpty() || tiv.getlNameTF().getText().contains("[0-9]+")) {
            confLN = false;
        }

        if (tiv.getSubjectTF().getText().isEmpty()) {
            confS = false;
        }
        if (tiv.getEmailTF().getText().isEmpty()) {
            confE = false;
        }

        if (!(m.find() && m.group().equals(tiv.getPhoneTF().getText())) && !(tiv.getPhoneTF().getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Phone Format");
            alert.setContentText("Invalid input, check phone format before submitting Ex. (999)999-9999");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();

            return false;
        }

        if (!(emailValidator.isValid(tiv.getEmailTF().getText())) && !(tiv.getEmailTF().getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Email Format");
            alert.setContentText("Invalid input, check email format before submitting Ex. sudent@example.edu");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();

            return false;
        }

        if (confID == false || confFN == false || confLN == false || confS == false||confE==false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields/ Wrong Format");
            alert.setContentText("Invalid input, check information before submitting");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();
            return false;

        }

        return true;
    }

    boolean validateStudentFields() {
        boolean confID = true;
        boolean confFN = true;
        boolean confLN = true;

        EmailValidator emailValidator = EmailValidator.getInstance();
        Pattern p = Pattern.compile("\\(\\d{3}\\)\\d{3}-\\d{4}");
        Matcher m = p.matcher(tiv.getPhoneTF().getText());

        if (tiv.getIdTF().getText().isEmpty() || !(tiv.getIdTF().getText().matches("\\d+"))) {
            confID = false;
        }

        if (tiv.getfNameTF().getText().isEmpty() || tiv.getfNameTF().getText().contains("[0-9]+")) {
            confFN = false;
        }

        if (tiv.getlNameTF().getText().isEmpty() || tiv.getlNameTF().getText().contains("[0-9]+")) {
            confLN = false;
        }

        if (!(m.find() && m.group().equals(tiv.getPhoneTF().getText())) && !(tiv.getPhoneTF().getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Phone Format");
            alert.setContentText("Invalid input, check phone format before submitting Ex. (999)999-9999");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();

            return false;
        }

        if (!(emailValidator.isValid(tiv.getEmailTF().getText())) && !(tiv.getEmailTF().getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Email Format");
            alert.setContentText("Invalid input, check email format before submitting Ex. sudent@example.edu");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();

            return false;
        }

        if (confID == false || confFN == false || confLN == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields/ Wrong Format");
            alert.setContentText("Invalid input, check information before submitting");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();
            return false;
        }

        return true;
    }

    boolean validateSupervisorFields() {
        boolean confID = true;
        boolean confFN = true;
        boolean confLN = true;
        boolean confE= true;
        EmailValidator emailValidator = EmailValidator.getInstance();
        Pattern p = Pattern.compile("\\(\\d{3}\\)\\d{3}-\\d{4}");
        Matcher m = p.matcher(tiv.getPhoneTF().getText());

        if (tiv.getIdTF().getText().isEmpty() || !(tiv.getIdTF().getText().matches("\\d+"))) {
            confID = false;
        }

        if (tiv.getfNameTF().getText().isEmpty() || tiv.getfNameTF().getText().contains("[0-9]+")) {
            confFN = false;
        }

        if (tiv.getlNameTF().getText().isEmpty() || tiv.getlNameTF().getText().contains("[0-9]+")) {
            confLN = false;
        }
        if (tiv.getEmailTF().getText().isEmpty()) {
            confE = false;
        }
        
        if (!(m.find() && m.group().equals(tiv.getPhoneTF().getText())) && !(tiv.getPhoneTF().getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Phone Format");
            alert.setContentText("Invalid input, check phone format before submitting Ex. (999)999-9999");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();

            return false;
        }

        if (!(emailValidator.isValid(tiv.getEmailTF().getText())) && !(tiv.getEmailTF().getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Wrong Email Format");
            alert.setContentText("Invalid input, check email format before submitting Ex. sudent@example.edu");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();

            return false;
        }

        if (confID == false || confFN == false || confLN == false||confE==false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields/ Wrong Format");
            alert.setContentText("Invalid input, check information before submitting");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();
            return false;

        }

        return true;
    }

}
