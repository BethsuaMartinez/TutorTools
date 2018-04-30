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
import Student.Student;
import Student.studentController;
import Student.studentView;
import Tutor.tutorView;
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
public class supervisorController {

    TutorInformationView tiv = new TutorInformationView();
    tutorView tv = new tutorView();
    ActivitylogView alv = new ActivitylogView();
    SupervisorModel sm = new SupervisorModel();
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Tutor> tutors = FXCollections.observableArrayList();
    Student currentStudent = new Student();
    Tutor currentTutor = new Tutor();

    public supervisorController(TutorInformationView tiv) {
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
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage newTutorStage = new Stage();
            newTutorStage.initModality(Modality.APPLICATION_MODAL);
            newTutorStage.initOwner(window);

            Scene newTutorScene = new Scene(tiv.addType(), 150, 150);

            newTutorStage.setTitle("Add");
            newTutorStage.setScene(newTutorScene);
            newTutorStage.show();
        });
        tiv.getAddType().setOnAction((ActionEvent event) -> {
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newTutorScene;

            if ("Tutor".equals(tiv.getTypePerson())) {
                newTutorScene = new Scene(tiv.addTutor(), 350, 250);
            } else {
                newTutorScene = new Scene(tiv.addStudent(), 350, 250);
            }
            window.setTitle("Add");
            window.setScene(newTutorScene);
            window.show();

        });
        tiv.getNewTutorSubmitBtn().setOnAction((ActionEvent event) -> {

            String idNo = tiv.getIdTF().getText();
            String firstName = tiv.getfNameTF().getText();
            String lastName = tiv.getlNameTF().getText();
            String email = tiv.getEmailTF().getText();
            String phoneNo = tiv.getPhoneTF().getText();
            String subject = tiv.getSubjectTF().getText();

            int id = Integer.parseInt(idNo);

            System.out.println(phoneNo + " " + subject);

            Tutor currentTutor = new Tutor(id, firstName, lastName, email, phoneNo, subject);
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

            System.out.println(id + firstName + lastName + email + phoneNo);

            Student currentStudent = new Student(id, firstName, lastName, email, phoneNo);
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
            Scene scene2;

            if ("Tutor".equals(tiv.getTypePerson())) {
                tiv.tutorList();
            } else {
                tiv.studentList();
            }

        });
    }
}
