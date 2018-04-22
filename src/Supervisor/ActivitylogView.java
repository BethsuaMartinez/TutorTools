/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author selvera
 */
public class ActivitylogView extends BorderPane {

    TextField name = new TextField();
    private Button tutor1 = new Button("Kenneth");
    private Button tutor2 = new Button("Bethsua");
    private Button tutor3 = new Button("Luis");
    private Button tutor4 = new Button("Osiel");
    private Button tutor5 = new Button("Elyvic");
    private Button back = new Button("Back");
    private Button signOut = new Button("Log Out");

    public ActivitylogView() {
        VBox vbox1 = new VBox(name);
        HBox hbox1 = new HBox();

        hbox1.setPadding(new Insets(10));
        hbox1.setSpacing(50);
        hbox1.setStyle("-fx-background-color: #336699;");

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

        this.setBottom(vbox1);
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
