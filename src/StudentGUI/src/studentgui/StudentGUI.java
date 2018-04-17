/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgui;

import MVC.Controller;
import MVC.GUI;
import MVC.Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author elyvic
 */
public class StudentGUI extends Application {
    GUI gui = new GUI();
    Model model = new Model();
    Controller controller = new Controller(gui, model);
    
    @Override
    public void start(Stage primaryStage) {
        model.Database();
        
        
        Scene scene = new Scene(gui, 800, 450);
        
        primaryStage.setTitle("Student GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
