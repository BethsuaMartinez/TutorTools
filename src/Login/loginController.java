/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Models.LoginModel;
import Models.SessionModel;
import Models.StudentModel;
import Student.studentController;
import Student.studentView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 *
 * @author beths
 */
public final class loginController {

    LoginModel logm = new LoginModel();
    loginView logv = new loginView();
    studentView sv = new studentView();

    public loginController(loginView logv, LoginModel logm) {
        this.logm = logm;
        this.logv = logv;
        AttachHandler();
    }

    public void AttachHandler() {

        logv.getLoginButton().setOnAction((ActionEvent event) -> {
            String un = logv.getUsername().getText();
            String psswd = logv.getPassword().getText();
            try {
                if (logm.loginDB(un, psswd) == true) {
                    studentView sv1 = new studentView();
                    StudentModel sm = new StudentModel();
                    SessionModel ssm = new SessionModel();
                    studentController sc = new studentController(sv1, sm, ssm);
                    Scene scene2 = new Scene(sv1, 1000, 500);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setTitle("Student List");
                    window.setScene(scene2);
                    window.show();
                } else {
                    logv.wrongId();
                }
            }catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        logv.getPassword().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                String un = logv.getUsername().getText();
                String psswd = logv.getPassword().getText();


                try {
                    if (logm.loginDB(un, psswd) == true) {

                        studentView sv = new studentView();
                        StudentModel sm = new StudentModel();
                        SessionModel ssm = new SessionModel();
                        studentController sc = new studentController(sv, sm, ssm);
                        Scene scene2 = new Scene(sv, 1000, 500);
                        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        window.setScene(scene2);
                        window.show();
                    } else {
                        logv.wrongId();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
