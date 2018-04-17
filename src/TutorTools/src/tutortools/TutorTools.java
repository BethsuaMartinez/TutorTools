/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutortools;

import ActivityLogGUIs.StudentInfo;
import ActivityLogGUIs.TutorEditInfo;
import ActivityLogGUIs.TutorEditInfoHbox;
import ActivityLogGUIs.TutorInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author KennyBoiii
 */
public class TutorTools extends Application {
    
    	@Override
	public void start(Stage primaryStage) {
                BorderPane border = new BorderPane();
		
                TutorInfo tutorGui = new TutorInfo();
                TutorEditInfoHbox tutorGui2 = new TutorEditInfoHbox();
		TutorEditInfo tutorGui3 = new TutorEditInfo();
                StudentInfo studentGui = new StudentInfo();
		border.setTop(tutorGui2);
                border.setCenter(tutorGui3);
		
		Scene scene = new Scene(border, 600, 500);
		
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
