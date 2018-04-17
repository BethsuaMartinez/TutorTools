/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mvc.controllers.loginController;
import mvc.models.loginModel;
import mvc.views.View;
import mvc.views.panels.loginPanel;

/**
 *
 * @author beths
 */
public class TutorTools extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        loginPanel login = new loginPanel();
       /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);*/
        
       
       loginController log = new loginController(new View(login), new loginModel());
       
        Scene scene = new Scene(login, 1000, 500);
       // Scene scene2 = new Scene(new tutorview(), 1000, 500);
         
         
        primaryStage.setTitle("Tutor Tools");
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
