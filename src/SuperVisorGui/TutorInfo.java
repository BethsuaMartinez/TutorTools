/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperVisorGui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author KennyBoiii
 */
public class TutorInfo extends HBox {
    
    private Button tutor1 = new Button("Kenneth");
    private Button tutor2 = new Button("Bethsua");
    private Button tutor3 = new Button("Luis");
    private Button tutor4 = new Button("Osiel");
    private Button tutor5 = new Button("Elyvic");
    
    public TutorInfo(){
       
        this.setPadding(new Insets(10));
        this.setSpacing(50);
        this.setStyle("-fx-background-color: #336699;");
        
        tutor1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor4.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        tutor5.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        tutor1.setPrefSize(100, 50);
        tutor2.setPrefSize(100, 50);
        tutor3.setPrefSize(100, 50);
        tutor4.setPrefSize(100, 50);
        tutor5.setPrefSize(100, 50);
        
        this.getChildren().add(tutor1);
        this.getChildren().add(tutor2);
        this.getChildren().add(tutor3);
        this.getChildren().add(tutor4);
        this.getChildren().add(tutor5);
        
    }

    /**
     * @return the tutor1
     */
    public Button getTutor1() {
        return tutor1;
    }

    /**
     * @param tutor1 the tutor1 to set
     */
    public void setTutor1(Button tutor1) {
        this.tutor1 = tutor1;
    }

    /**
     * @return the tutor2
     */
    public Button getTutor2() {
        return tutor2;
    }

    /**
     * @param tutor2 the tutor2 to set
     */
    public void setTutor2(Button tutor2) {
        this.tutor2 = tutor2;
    }

    /**
     * @return the tutor3
     */
    public Button getTutor3() {
        return tutor3;
    }

    /**
     * @param tutor3 the tutor3 to set
     */
    public void setTutor3(Button tutor3) {
        this.tutor3 = tutor3;
    }

    /**
     * @return the tutor4
     */
    public Button getTutor4() {
        return tutor4;
    }

    /**
     * @param tutor4 the tutor4 to set
     */
    public void setTutor4(Button tutor4) {
        this.tutor4 = tutor4;
    }

    /**
     * @return the tutor5
     */
    public Button getTutor5() {
        return tutor5;
    }

    /**
     * @param tutor5 the tutor5 to set
     */
    public void setTutor5(Button tutor5) {
        this.tutor5 = tutor5;
    }
    
    
    
    
}
