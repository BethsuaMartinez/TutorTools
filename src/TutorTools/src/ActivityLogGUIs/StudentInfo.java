/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityLogGUIs;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author KennyBoiii
 */
public class StudentInfo extends VBox{
    
    private TextField name = new TextField();
    
    public StudentInfo(){
        
        this.getChildren().add(name);
    }

    /**
     * @return the name
     */
    public TextField getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(TextField name) {
        this.name = name;
    }
    
    
}
