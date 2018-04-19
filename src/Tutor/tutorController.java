/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutor;

import Login.loginModel;
import Login.loginView;
import Login.loginController;
import Student.studentController;
import Student.studentModel;
import Student.studentView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    loginModel logm = new loginModel();
    loginView logv = new loginView();
    tutorView tv = new tutorView();

    public tutorController(tutorView tv) {
        this.tv= tv;
        //this.logv = logv;
        //this.logm = logm;
        attachHandlers();
    }

    private void attachHandlers() {

        tv.getSignOut().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginView v = new loginView();
                loginModel m = new loginModel();
                Scene scene2 = new Scene(v, 1000, 500);
                loginController logc = new loginController(logv, logm);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene2);
                window.show();
            }
        });
        
        tv.getBack().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                studentView sv = new studentView();
                studentModel sm = new studentModel();
                studentController sc = new studentController(sv, sm);

                Scene scene3 = new Scene(sv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();

            }
        });
        
    }
}
