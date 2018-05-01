/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Login.loginController;
import Login.loginView;
import Models.LoginModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author selvera
 */
public class activityController {

    TutorInformationView tiv = new TutorInformationView();
    ActivitylogView alv = new ActivitylogView();

    public activityController(ActivitylogView alv) {
        this.alv = alv;
        attachHandlers();
    }

    private void attachHandlers() {

        alv.getSignOut().setOnAction((ActionEvent event) -> {
            loginView v = new loginView();
            LoginModel m = new LoginModel();
            loginController logc = new loginController(v, m);
            Scene scene2 = new Scene(v, 1300, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Sign In");
            window.setScene(scene2);
            window.show();
        });

        alv.getBack().setOnAction((ActionEvent event) -> {
            TutorInformationView tiv1 = new TutorInformationView();
            supervisorController sc = new supervisorController(tiv1);
            Scene scene3 = new Scene(tiv1, 1300, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Supervisor");
            window.setScene(scene3);
            window.show();
        });
    }
}
