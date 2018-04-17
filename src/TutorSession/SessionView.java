/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TutorSession;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class SessionView extends BorderPane{
    BorderPane bp = new BorderPane();
    Button edit = new Button("Edit");
    Label right = new Label("Students Window");
    
    public SessionView(){
        
        HBox hbox1= new HBox(edit);
        this.setCenter(right);
        this.setBottom(hbox1);
    }
}
