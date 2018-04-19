/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools;

import Login.loginController;
import Login.loginModel;
import Login.loginView;
import Supervisor.ActivitylogView;
import Supervisor.TutorInformationView;
import java.sql.SQLException; 
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author beths
 */
public class TutorTools extends Application {
    
    @Override 
    public void start(Stage primaryStage) throws SQLException {
        
        loginView lv = new loginView();
        loginModel lm = new loginModel();
        loginController lc = new loginController(lm, lv);
       
        Scene scene = new Scene(lv, 1000, 500);
 
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