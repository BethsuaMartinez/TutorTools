/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author selvera
 */
public class loginController {
    loginModel logm= new loginModel();
    loginView logv= new loginView();
    
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
                
            try {
                logm.login(un, psswd);
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                }
            });
        
    }
}
