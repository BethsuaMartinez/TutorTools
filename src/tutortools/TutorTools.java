/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools;
<<<<<<< HEAD
 
=======

import java.sql.SQLException;
>>>>>>> 06aa349d07ca2bf15c9e4d742a24783b9975d3af
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
<<<<<<< HEAD
import mvc.controllers.loginController;
import mvc.models.loginModel;
import mvc.views.View;
import mvc.views.panels.loginPanel;
=======
import login.loginController;
import login.loginModel;
import login.loginView;
>>>>>>> 06aa349d07ca2bf15c9e4d742a24783b9975d3af

/**
 *
 * @author beths
 */
public class TutorTools extends Application {
    
    @Override
<<<<<<< HEAD
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
=======
    public void start(Stage primaryStage) throws SQLException {
        loginView login = new loginView();
        loginModel logm = new loginModel();
        loginController logc = new loginController(logm, login);
>>>>>>> 06aa349d07ca2bf15c9e4d742a24783b9975d3af
        
       
       loginController log = new loginController(new View(login), new loginModel());
       
        Scene scene = new Scene(login, 1000, 500);
<<<<<<< HEAD
       // Scene scene2 = new Scene(new tutorview(), 1000, 500);
         
         
=======
        
>>>>>>> 06aa349d07ca2bf15c9e4d742a24783b9975d3af
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