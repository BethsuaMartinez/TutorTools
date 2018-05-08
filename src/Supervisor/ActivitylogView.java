/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author selvera
 */
public class ActivitylogView extends BorderPane {

    private Button back = new Button("Back");
    private Button signOut = new Button("Sign Out");

    final static String math = "";
    final static String science = "";
    final static String english = "";
    final static String computerScience = "";
    
    
    private String pass;

    public ActivitylogView() {

        HBox hb = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        BackgroundImage background = new BackgroundImage(new Image("/resources/background.jpg", 3000, 3000, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        hb.setBackground(new Background(background));
        hb.setPadding(new Insets(10, 10, 10, 10));
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/resources/TutorTools.PNG")));
        logo.setPreserveRatio(true);
        logo.setFitWidth(120);
        logo.setFitHeight(30);
        hb2.getChildren().add(logo);
        hb2.setPadding(new Insets(0, 0, 0, 30));
        hb3.getChildren().addAll(signOut, back);
        hb3.setAlignment(Pos.CENTER_RIGHT);
        hb3.setPadding(new Insets(0, 20, 0, 0));
        hb3.setSpacing(10);
        HBox.setHgrow(hb3, Priority.ALWAYS);
        hb.getChildren().addAll(logo, hb3);
        hb.setPadding(new Insets(5, 0, 5, 20));

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc= new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Students Per Subject");
        xAxis.setLabel("Subject");
        yAxis.setLabel("Student");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Math");
        series1.getData().add(new XYChart.Data(math, 10));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Science");
        series2.getData().add(new XYChart.Data(science, 30));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("English");
        series3.getData().add(new XYChart.Data(english, 25));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Computer Science");
        series4.getData().add(new XYChart.Data(computerScience, 5));

        bc.getData().addAll(series1, series2, series3, series4);

        this.setCenter(bc);     
        this.setTop(hb);

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

    /**
     * @return the signOut
     */
    public Button getSignOut() {
        return signOut;
    }

    /**
     * @param signOut the signOut to set
     */
    public void setSignOut(Button signOut) {
        this.signOut = signOut;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

}
