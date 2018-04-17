/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import mvc.models.Model;
import mvc.models.loginModel;
import mvc.views.View;
import mvc.views.panels.loginPanel;
import mvc.views.panels.tutorPanel;
import mvc.views.tutorView;

/**
 *
 * @author beths
 */
public class loginController extends Controller {

    public loginController(View view, Model model) {
        super(view, model);
        attachHandlers();
    }

    private void attachHandlers() {
        Button loginBtn = ((loginPanel) this.getViewPanel()).getLogin();

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tutorView v = new tutorView(new tutorPanel());
                tutorController c = new tutorController(v, model);
                getStage().setScene(new Scene(v.getPanel(), 1000, 500));
            }
        });
    }
}
