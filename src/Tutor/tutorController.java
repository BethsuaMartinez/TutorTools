/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutor;

import Login.loginModel;
import Login.loginView;
import Login.loginController;
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

    public tutorController(loginView view, loginModel model) {
        this.logv = logv;
        this.logm = logm;
        this.tv = tv;
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

    }
}
