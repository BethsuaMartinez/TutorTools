/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools; 
   
import Login.loginController;
import Login.loginModel;
import Login.loginView;
import SuperVisorGui.StudentInfo;
import SuperVisorGui.TutorEditInfo;
import SuperVisorGui.TutorEditInfoHbox;
import SuperVisorGui.TutorInfo;
import java.sql.SQLException; 
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author beths
 */
public class TutorTools extends Application {
    
    @Override 
    public void start(Stage primaryStage) throws SQLException {
        loginView login = new loginView();
        loginModel logm = new loginModel();
        
        loginController logc = new loginController(logm, login); 
       
        Scene scene = new Scene(login, 1000, 500);
 
        primaryStage.setTitle("Tutor Tools");
        primaryStage.setScene(scene);
        primaryStage.show();
     /*   BorderPane border = new BorderPane();
		
                TutorInfo tutorGui = new TutorInfo();
                TutorEditInfoHbox tutorGui2 = new TutorEditInfoHbox();
		TutorEditInfo tutorGui3 = new TutorEditInfo();
                StudentInfo studentGui = new StudentInfo();
		border.setTop(tutorGui2);
                border.setCenter(tutorGui3);
		
		Scene scene = new Scene(border, 600, 500);
		
		primaryStage.setTitle("TutorTools");
		primaryStage.setScene(scene);
		primaryStage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}