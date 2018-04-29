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
import Student.studentController;
import Student.studentView;
import Tutor.tutorView;
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
                Scene scene2 = new Scene(v, 1300, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Sign In");
                window.setScene(scene2);
                window.show();
            }
        });
        
        tiv.getBack().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                studentView sv = new studentView();
                StudentModel sm = new StudentModel();
                SessionModel ssm = new SessionModel();
                studentController sc = new studentController(sv, sm, ssm);

                Scene scene3 = new Scene(sv, 1300, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Student List");
                window.setScene(scene3);
                window.show();

            }
        });
        tiv.getActivity().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                ActivitylogView alv = new ActivitylogView();
                activityController ac = new activityController(alv);

                Scene scene3 = new Scene(alv, 1300, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Activity Log");
                window.setScene(scene3);
                window.show();

            }
        });
        

        tiv.getAdd().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Stage newTutorStage = new Stage();
                newTutorStage.initModality(Modality.APPLICATION_MODAL);
                newTutorStage.initOwner(window);

                                
                VBox newTutorVbox = new VBox();
                newTutorVbox = tiv.addTutor();
                
                Scene newTutorScene = new Scene(newTutorVbox, 300, 270);
                
                newTutorStage.setTitle("New Tutor");
                newTutorStage.setScene(newTutorScene);
                newTutorStage.show();

            }
        });
        
        tiv.getNewTutorSubmitBtn().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.close();
                tiv.ClearFields();
            }
        });

        tiv.getEmail().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                MailView mv = new MailView();
                mailController mc = new mailController(mv);

                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Stage signInStage = new Stage();
                signInStage.initModality(Modality.APPLICATION_MODAL);
                signInStage.initOwner(window);

                VBox layout = new VBox();
                layout = mv;

                Scene newIdScene = new Scene(layout, 500, 300);

                signInStage.setTitle("E-Mail");

                signInStage.setScene(newIdScene);

                signInStage.show();



            }
        });
            }
}
        
              



