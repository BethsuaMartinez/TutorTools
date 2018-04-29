/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools;

import Login.loginController;
import Login.loginView;
import Models.LoginModel;
import java.sql.SQLException; 
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 *
 * @author beths
 */
public class TutorTools extends Application {
    
    public void start(Stage primaryStage) throws SQLException {
        
        loginView lv = new loginView();
        LoginModel lm = new LoginModel();

        loginController lc = new loginController(lv, lm);
       
        Scene scene = new Scene(lv, 1300, 500);
 
        primaryStage.getIcons().add(new Image("/resources/Logo.png"));
        primaryStage.setTitle("TutorTools");
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