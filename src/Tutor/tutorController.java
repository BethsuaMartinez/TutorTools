/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutor;

import Login.loginView;
import Login.loginController;
import Models.LoginModel;
import Models.SessionModel;
import Models.StudentModel;
import Student.studentController;
import Student.studentView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author beths
 */
public class tutorController {

    LoginModel logm = new LoginModel();
    loginView logv = new loginView();
    tutorView tv = new tutorView();

    public tutorController(tutorView tv) {
        this.tv = tv;
        //this.logv = logv;
        //this.logm = logm;
        attachHandlers();
    }

    private void attachHandlers() {

        tv.getSignOut().setOnAction(new EventHandler<ActionEvent>() {
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

        tv.getBack().setOnAction(new EventHandler<ActionEvent>() {
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

    }
}
