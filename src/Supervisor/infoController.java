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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author selvera
 */
public class infoController {

    infoView tiv;
    tutorView tv = new tutorView();
    
    ActivitylogView alv = new ActivitylogView();
    SupervisorModel sm = new SupervisorModel();
    StudentModel stm = new StudentModel();
    
    Student currentStudent = new Student();
    Tutor currentTutor = new Tutor();
    TutorModel tm = new TutorModel();

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
                window.setTitle("Sign In");
                window.setScene(scene2);
                window.show();
            }
        });

        tiv.getBack().setOnAction((ActionEvent event) -> {
            studentView sv = new studentView();
            StudentModel sm = new StudentModel();
            SessionModel ssm = new SessionModel();
            studentController sc = new studentController(sv, sm, ssm);

            Scene scene3 = new Scene(sv, 1000, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Student List");
            window.setScene(scene3);
            window.show();
        });
        tiv.getActivity().setOnAction((ActionEvent event) -> {
            ActivitylogView alv1 = new ActivitylogView();
            activityController ac = new activityController(alv1);
            Scene scene3 = new Scene(alv1, 1000, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Activity Log");
            window.setScene(scene3);
            window.show();
        });
        tiv.getAdd().setOnAction((ActionEvent event) -> {
            //Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage newTutorStage = new Stage();
            newTutorStage.initModality(Modality.APPLICATION_MODAL);
            //newTutorStage.initOwner(window);
            Scene newTutorScene;

            if ("Tutor".equals(tiv.getTypePerson())) {
                newTutorScene = new Scene(tiv.addTutor(), 350, 250);
            } else {
                newTutorScene = new Scene(tiv.addStudent(), 350, 250);
            }

            newTutorStage.setScene(newTutorScene);
            newTutorStage.show();
        });

        tiv.getNewTutorSubmitBtn().setOnAction((ActionEvent event) -> {
            String idNo = tiv.getIdTF().getText();
            String firstName = tiv.getfNameTF().getText();
            String lastName = tiv.getlNameTF().getText();
            String email = tiv.getEmailTF().getText();
            String phoneNo = tiv.getPhoneTF().getText();
            String subject = tiv.getSubjectTF().getText();
            String password = "";
            int id = Integer.parseInt(idNo);

            Tutor currentTutor = new Tutor(id, firstName, lastName, email, phoneNo, subject);
            try {
                tm.insertTutor(idNo, firstName, lastName, email, phoneNo, password, subject);
            } catch (SQLException ex) {
                Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            tiv.updateTutorTable(currentTutor);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
            tiv.ClearFields();
        });

        tiv.getStudentSubmitBtn().setOnAction((ActionEvent event) -> {

            String idNo = tiv.getIdTF().getText();
            String firstName = tiv.getfNameTF().getText();
            String lastName = tiv.getlNameTF().getText();
            String email = tiv.getEmailTF().getText();
            String phoneNo = tiv.getPhoneTF().getText();

            int id = Integer.parseInt(idNo);

            Student currentStudent = new Student(id, firstName, lastName, email, phoneNo);
            try {
                stm.insertStudent(idNo, firstName, lastName, email, phoneNo);
            } catch (SQLException ex) {
                Logger.getLogger(infoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            tiv.updateStudentTable(currentStudent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
            tiv.ClearFields();
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
            signInStage.setScene(newIdScene);
            signInStage.show();
        });

        tiv.getSearch().setOnAction((ActionEvent event) -> {

            if ("Tutor".equals(tiv.getTypePerson())) {
                //  tiv.clearTutorList();
                tiv.tutorList();
            } else {
                // tiv.clearStudentList();
                tiv.studentList();
            }

        });

        tiv.getModify().setOnAction((ActionEvent event) -> {

            Stage modifyStage = new Stage();
            modifyStage.initModality(Modality.APPLICATION_MODAL);

            Scene modifyScene; // new Scene(tiv.modifyTutor(), 300, 300);

            if ("Tutor".equals(tiv.getTypePerson())) {
                modifyScene = new Scene(tiv.modifyTutor(), 350, 250);
            } else {
                modifyScene = new Scene(tiv.modifyStudent(), 350, 250);
            }

            modifyStage.setTitle("Modify");
            modifyStage.setScene(modifyScene);
            modifyStage.show();

        });

    }
}
