/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author elyvic
 */
public class Controller {
    Model model = new Model();
    GUI gui = new GUI();
    
    
    public Controller(GUI gui, Model model){
        this.model = model;
        this.gui = gui;
        
        AttachHandler();
    }
    
    public void AttachHandler(){
        
        
        gui.getAddBtn().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Scene signInscene = new Scene(gui.getGridpane(), 330, 285);
                Stage signInStage = new Stage();    
                
                signInStage.setTitle("Sign-In");
                signInStage.setScene(signInscene);
                signInStage.show();
            }
        });
        
         gui.getSubmitBtn().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date date = new Date();

                
                String idNo = gui.getIdNoTF().getText();
                String firstName = gui.getFirstNameTF().getText();
                String lastName = gui.getLastNameTF().getText();
                String email = gui.getEmailTF().getText();
                String phoneNo = gui.getPhoneNoTF().getText();
                String tutor = gui.getTutorTF().getText();
                String time = dateFormat.format(date);
                
                Data currentSession = new Data(idNo, firstName, lastName, email, phoneNo,tutor, time);
                model.setCurrentStudent(currentSession);
                                
                gui.ClearFields();
            }
        });
        
        
        gui.getRefreshBtn().setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                model.Database();
            }
        });
        
    }
}
