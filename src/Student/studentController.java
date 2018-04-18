/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author elyvic
 */
public class studentController {

    studentModel model = new studentModel();
    studentView gui = new studentView();

    public studentController(studentView gui, studentModel model) {
        this.model = model;
        this.gui = gui;

        AttachHandler();
    }

    public void AttachHandler() {
        gui.getAddBtn().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene signInscene = new Scene(gui.getGridpane(), 330, 285);
                Stage signInStage = new Stage();

                signInStage.setTitle("Sign-In");
                signInStage.setScene(signInscene);
                signInStage.show();
            }
        });

        gui.getSubmitBtn().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date date = new Date();

                String idNo = gui.getIdNoTF().getText();
                String firstName = gui.getFirstNameTF().getText();
                String lastName = gui.getLastNameTF().getText();
                String email = gui.getEmailTF().getText();
                String phoneNo = gui.getPhoneNoTF().getText();
                String tutor = gui.getTutorTF().getText();
                String time = dateFormat.format(date);

                Data currentSession = new Data(idNo, firstName, lastName, email, phoneNo, tutor, time);
                try {
                    model.setCurrentStudent(currentSession);
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                gui.ClearFields();
            }
        });

        gui.getRefreshBtn().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    model.Database();
                } catch (SQLException ex) {
                    Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
