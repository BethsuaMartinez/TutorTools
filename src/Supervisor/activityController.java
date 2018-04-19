/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Student.studentController;
import Student.studentModel;
import Student.studentView;
import Tutor.tutorView;
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
        
        alv.getBack().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                TutorInformationView tiv = new TutorInformationView();

                supervisorController sc = new supervisorController(tiv);

                Scene scene3 = new Scene(tiv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();

            }
        });
    }
}
