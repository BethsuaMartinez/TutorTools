/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import TutorSession.SessionView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import TutorSession.SessionView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author selvera
 */
public final class loginController {
    loginModel logm= new loginModel();
    loginView logv= new loginView();
    SessionView sw = new SessionView();
    
    
    public loginController(loginModel logm, loginView logv) throws SQLException{
        this.logm= logm;
        this.logv=logv;
        attachHandlers();
    }
                    
    public void attachHandlers(){
        logv.getLogin().setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent event) {
                String un = logv.getUsername().getText();
                String psswd = logv.getPassword().getText();
            if(un==""||psswd==""){
                logv.wrongPass();
            }    
            
            try {
                if(logm.login(un, psswd)==true){
                    System.out.println("here");
                    Scene scene2 = new Scene(sw, 1000, 500);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(scene2);
                    window.show();
                }
                else
                    logv.wrongPass();
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                }
            });
        
    }
}
