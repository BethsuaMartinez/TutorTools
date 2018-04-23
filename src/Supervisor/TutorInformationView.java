/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author selvera
 */
public class TutorInformationView extends BorderPane {

    
    
    private Label lasName = new Label("Enter Last Name of Tutor");
    private TextField lastNameTF = new TextField();
    private Button search = new Button("Search");
    private Button back = new Button("Back");
    TableView table = new TableView();
    private Button activity= new Button("Activity Log");
    private Button signOut = new Button("Log Out");
    
    public  TutorInformationView() {
        
        search.setPrefSize(100, 10);
        HBox hbox1= new HBox(lasName, lastNameTF, search, getActivity(), back);
        
        
        hbox1.setPadding(new Insets(10));
        hbox1.setSpacing(20);

        this.setTop(hbox1);
        this.setCenter(table);
    }

    /**
     * @return the lasName
     */
    public Label getLasName() {
        return lasName;
    }

    /**
     * @param lasName the lasName to set
     */
    public void setLasName(Label lasName) {
        this.lasName = lasName;
    }

    /**
     * @return the lastNameTF
     */
    public TextField getLastNameTF() {
        return lastNameTF;
    }

    /**
     * @param lastNameTF the lastNameTF to set
     */
    public void setLastNameTF(TextField lastNameTF) {
        this.lastNameTF = lastNameTF;
    }

    /**
     * @return the search
     */
    public Button getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(Button search) {
        this.search = search;
    }

    /**
     * @return the activity
     */
    public Button getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(Button activity) {
        this.activity = activity;
    }

    /**
     * @return the back
     */
    public Button getBack() {
        return back;
    }

    /**
     * @param back the back to set
     */
    public void setBack(Button back) {
        this.back = back;
    }

    
}
