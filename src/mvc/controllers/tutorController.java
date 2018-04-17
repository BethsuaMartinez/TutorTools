/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import mvc.models.Model;
import mvc.views.View;
import mvc.views.loginView;
import mvc.views.panels.loginPanel;
import mvc.views.panels.tutorPanel;
import mvc.views.tutorView;

/**
 *
 * @author beths
 */
public class tutorController extends Controller {

    public tutorController(View view, Model model) {
        super(view, model);
        attachHandlers();
    }

    private void attachHandlers() {
        Button signOut = ((tutorPanel) this.getViewPanel()).getSignOut();

        signOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginView v = new loginView(new loginPanel());
                loginController c = new loginController(v, model);
                getStage().setScene(new Scene(v.getPanel(), 1000, 500));
            }
        });

    }
}
