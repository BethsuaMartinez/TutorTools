/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

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
public class loginController {

    loginModel logm = new loginModel();
    loginView logv = new loginView();
    studentView sv = new studentView();

    public loginController(loginView logv, loginModel logm) {
        this.logm = logm;
        this.logv = logv;
        AttachHandler();
    }

    public void AttachHandler() {
        
        logv.getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
                String un = logv.getUsername().getText();
                String psswd = logv.getPassword().getText();

                if ("".equals(un) || "".equals(psswd)){
                    logv.wrongPass();
                }
                try {
                    if (logm.loginDB(un, psswd) == true) {

                        Scene scene2 = new Scene(sv, 1000, 500);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(scene2);
                        window.show();
                    } else {
                        logv.wrongPass();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        });
    }
}


