/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools; 
   
import java.sql.SQLException; 
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mvc.controllers.loginController;
import mvc.models.loginModel;
import mvc.views.View;
import mvc.views.loginView;
import mvc.views.panels.loginPanel;

/**
 *
 * @author beths
 */
public class TutorTools extends Application {
    
    @Override 
    public void start(Stage primaryStage) throws SQLException {
        loginView login = new loginView(new loginPanel());
        loginModel logm = new loginModel();
        loginController logc = new loginController( login, logm); 
       
       loginController log = new loginController(login, new loginModel());
       
        Scene scene = new Scene(login.getPanel(), 1000, 500);
 
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