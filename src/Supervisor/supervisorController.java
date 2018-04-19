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
public class supervisorController {
    TutorInformationView tiv = new TutorInformationView();
    tutorView tv = new tutorView();
    ActivitylogView alv = new ActivitylogView();

    public supervisorController(TutorInformationView tiv) {
        this.tiv = tiv;
        attachHandlers();
    }

    private void attachHandlers() {
        
        tiv.getBack().setOnAction(new EventHandler<ActionEvent>() {
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
        tiv.getActivity().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                
                ActivitylogView alv = new ActivitylogView();
                activityController ac = new activityController(alv);

                Scene scene3 = new Scene(alv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();

            }
        });
    }
}


