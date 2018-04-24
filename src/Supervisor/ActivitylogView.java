/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author selvera
 */
public class ActivitylogView extends BorderPane {

    TableView name = new TableView();
    TableView name2 = new TableView();
    TableView name3 = new TableView();
    TableView name4 = new TableView();
    TableView name5 = new TableView();
    
    private Button tutor1 = new Button("Kenneth");
    private Button tutor2 = new Button("Bethsua");
    private Button tutor3 = new Button("Luis");
    private Button tutor4 = new Button("Osiel");
    private Button tutor5 = new Button("Elyvic");
    private Button back = new Button("Back");
    private Button signOut = new Button("Log Out");
    

    public ActivitylogView() {
         BackgroundImage background = new BackgroundImage(new Image("/resources/background.jpg", 3000, 3000, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        
       this.setBackground(new Background(background));
        
        name.setPrefSize(100, 300);
        name2.setPrefSize(100, 300);
        name3.setPrefSize(100, 300);
        name4.setPrefSize(100, 300);
        name5.setPrefSize(100, 300);
 
        VBox vbox1 = new VBox();
        GridPane gp = new GridPane();
        HBox hbox1 = new HBox();
        
        gp.add(name,1,1);
        gp.add(name2,2,1);
        gp.add(name3,3,1);
        gp.add(name4,4,1);
        gp.add(name5,5,1);
        
        gp.setHgap(60);
        gp.setVgap(20);
        gp.setPadding(new Insets(0,50, 0, 50));
        
        hbox1.setPadding(new Insets(50));
        hbox1.setSpacing(45);
       

        tutor1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor4.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor5.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        back.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        tutor1.setPrefSize(100, 50);
        tutor2.setPrefSize(100, 50);
        tutor3.setPrefSize(100, 50);
        tutor4.setPrefSize(100, 50);
        tutor5.setPrefSize(100, 50);
        back.setPrefSize(100, 50);
       

        hbox1.getChildren().add(tutor1);
        hbox1.getChildren().add(tutor2);
        hbox1.getChildren().add(tutor3);
        hbox1.getChildren().add(tutor4);
        hbox1.getChildren().add(tutor5);
        hbox1.getChildren().add(back);
        
        

        this.setCenter(gp);
        
        this.setTop(hbox1);
        
        
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
