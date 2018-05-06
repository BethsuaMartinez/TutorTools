/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutor;

import Login.loginView;
import Login.loginController;
import Models.LoginModel;
import Models.SessionModel;
import Models.StudentModel;
import Student.studentController;
import Student.studentView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author beths
 */
public class tutorController {

    LoginModel logm = new LoginModel();
    loginView logv = new loginView();
    tutorView tv;

    public tutorController(tutorView tv) {
        this.tv = tv;
        //this.logv = logv;
        //this.logm = logm;
        attachHandlers();
    }

    private void attachHandlers() {

        tv.getModify().setOnAction((ActionEvent event) -> {
            Stage modifyStage = new Stage();
            modifyStage.initModality(Modality.APPLICATION_MODAL);
            modifyStage.getIcons().add(new Image("/resources/Logo.png"));
            Scene modifyScene;
            
            if(tv.confirmStudentModify()==true){
                modifyScene = new Scene(tv.modifyView(), 350, 300);
                modifyStage.setTitle("Modify");
                modifyStage.setScene(modifyScene);
                modifyStage.show();
            }

        });
        
        tv.getSubmitModify().setOnAction((ActionEvent event) ->{
        
            if(validateFields()==true){
                String id = tv.getStIDTF().getText();
                String fname = tv.getfNameTF().getText();
                String lname = tv.getlNameTF().getText();
                String tutor = tv.getTutorNameTF().getText();
                String subject = tv.getSubjectTF().getText();
                int idNo = Integer.parseInt(id);
                
                tutoringSession current = new tutoringSession(idNo, fname, lname, tutor, subject); 
               
              //  try {
                  //  tm.updateTutor(idNo, firstName, lastName, email, phoneNo, password, subject);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.getIcons().add(new Image("/resources/Logo.png"));
                    window.close();
                    tv.clearFields();
               // } catch (SQLException ex) {
               //     Logger.getLogger(tutorController.class.getName()).log(Level.SEVERE, null, ex);
               // }
                
               
            }
        
        });
        
        tv.getDelete().setOnAction((ActionEvent event) -> {
            tv.deleteFromTable();
        });
       
        tv.getSignOut().setOnAction((ActionEvent event) -> {
            loginView v = new loginView();
            LoginModel m = new LoginModel();
            loginController logc = new loginController(v, m);
            Scene scene2 = new Scene(v, 1000, 500);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.getIcons().add(new Image("/resources/Logo.png"));
            window.setTitle("Sign In");
            window.setScene(scene2);
            window.show();
        });

        tv.getBack().setOnAction((ActionEvent event) -> {
            studentView sv;
            try {
                sv = new studentView();
                StudentModel sm = new StudentModel();
                SessionModel ssm = new SessionModel();
                studentController sc = new studentController(sv, sm, ssm);

                Scene scene3 = new Scene(sv, 1000, 500);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.getIcons().add(new Image("/resources/Logo.png"));
                window.setTitle("Student List");
                window.setScene(scene3);
                window.show();
            } catch (SQLException ex) {
                Logger.getLogger(tutorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    boolean validateFields(){
        boolean confID = true;
        boolean confFName = true;
        boolean confLName = true;
        boolean confTutor = true;
        boolean confSubj = true;
        
   
        if (tv.getStIDTF().getText().isEmpty() || !(tv.getStIDTF().getText().matches("\\d+"))) 
            confID = false;
        

        if (tv.getfNameTF().getText().isEmpty() || tv.getfNameTF().getText().contains("[0-9]+")) 
            confFName = false;
   

        if (tv.getlNameTF().getText().isEmpty() || tv.getlNameTF().getText().contains("[0-9]+")) 
            confLName = false;
        
        if (tv.getTutorNameTF().getText().isEmpty() || tv.getTutorNameTF().getText().contains("[0-9]+")) 
            confLName = false;
        

        if (tv.getSubjectTF().getText().isEmpty() || tv.getSubjectTF().getText().contains("[0-9]+")) 
            confSubj = false;
        
        if(confID == false || confFName == false || confLName == false || confTutor == false || confSubj == false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields/ Wrong Format");
            alert.setContentText("Invalid input, check information before submit it");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
