/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controllers;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mvc.models.Model;
import mvc.models.loginModel;
import mvc.views.View;
import mvc.views.panels.loginPanel;

/**
 *
 * @author beths
 */
public abstract class Controller {

    public final View view;
    public final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    /**
     * @return the view
     */
    public View getView() {
        return view;
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }
    
    /**
     * @return the view
     */
    public BorderPane getViewPanel() {
        return this.getView().getPanel();
    }
    
     public Stage getStage() {
        return (Stage)this.getView().getPanel().getScene().getWindow();
    }
    
    
}
