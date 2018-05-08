/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Login.loginController;
import Login.loginView;
import Models.LoginModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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


    infoView tiv;

    ActivitylogView alv;

    public activityController(ActivitylogView alv) {
        this.alv = alv;
        attachHandlers();
    }

    private void attachHandlers() {

        alv.getSignOut().setOnAction((ActionEvent event) -> {
            loginView v = new loginView();
            LoginModel m = new LoginModel();
            loginController logc = new loginController(v, m);
            Scene scene2 = new Scene(v, 1000, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Sign In");
            window.setScene(scene2);
            window.show();
        });

        alv.getBack().setOnAction((ActionEvent event) -> {

            infoView tiv1;
            try {
                tiv1 = new infoView();
                infoController sc = new infoController(tiv1);
                tiv1.setPass(alv.getPass());
                Scene scene3 = new Scene(tiv1, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Supervisor");
                window.setScene(scene3);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(activityController.class.getName()).log(Level.SEVERE, null, ex);
            }
});
            alv.getSubMonth().setOnAction((ActionEvent event) -> {
            try {
                String month = alv.getMonths();
                alv.updateChart(month);
            } catch (SQLException ex) {
                Logger.getLogger(activityController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(activityController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }
}
