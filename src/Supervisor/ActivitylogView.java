/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Models.SessionModel;
import Models.TutorModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

    SessionModel ssm = new SessionModel();
    private Button back = new Button("Back");
    private Button signOut = new Button("Sign Out");
    TutorModel tm = new TutorModel();
    private ChoiceBox<String> months = new ChoiceBox<>();
    private Button subMonth = new Button("Submit");
    final NumberAxis yAxis = new NumberAxis();
    final CategoryAxis xAxis = new CategoryAxis();
    private String pass;

    public ActivitylogView() throws SQLException, ParseException {

        months.getItems().addAll("Year", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        months.setValue("Year");

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
        hb3.getChildren().addAll(months, subMonth, back, signOut);
        hb3.setAlignment(Pos.CENTER_RIGHT);
        hb3.setPadding(new Insets(0, 20, 0, 0));
        hb3.setSpacing(10);
        HBox.setHgrow(hb3, Priority.ALWAYS);
        hb.getChildren().addAll(logo, hb3);
        hb.setPadding(new Insets(5, 0, 5, 20));

        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Students Per Subject");
        xAxis.setLabel("Subject");
        yAxis.setLabel("Student");

        int x = 0;
        String subject = "";
        ArrayList<XYChart.Series> chartlist = new ArrayList<>();

        ArrayList<String> subjectList = tm.subjects();

        for (int i = 0; i < subjectList.size(); i++) {

            subject = subjectList.get(i);
            x = ssm.subectCount(subjectList.get(i), "2018-01-01", "2018-12-31");

            XYChart.Series series = new XYChart.Series();
            series.setName(subject);
            series.getData().add(new XYChart.Data("", x));

            chartlist.add(series);
        }

        for (int i = 0; i < chartlist.size(); i++) {
            bc.getData().add(chartlist.get(i));
        }
        this.setCenter(bc);
        this.setTop(hb);

    }

    public void updateChart(String month) throws SQLException, ParseException {
        final BarChart<String, Number> bcs = new BarChart<String, Number>(xAxis, yAxis);
        bcs.setTitle("Students Per Subject");
        int x = 0;
        String subject = "";
        ArrayList<XYChart.Series> chartList = new ArrayList<>();
        ArrayList<String> subList = tm.subjects();
        for (int i = 0; i < subList.size(); i++) {
            subject = subList.get(i);
            if ("January".equals(month)) {
                x = ssm.subectCount(subject, "2018-01-01", "2018-01-31");
            } else if ("February".equals(month)) {
                x = ssm.subectCount(subject, "2018-02-01", "2018-02-29");
            } else if ("March".equals(month)) {
                x = ssm.subectCount(subject, "2018-03-01", "2018-03-31");
            } else if ("April".equals(month)) {
                x = ssm.subectCount(subject, "2018-04-01", "2018-04-30");
            } else if ("May".equals(month)) {
                x = ssm.subectCount(subject, "2018-05-01", "2018-05-31");
            } else if ("June".equals(month)) {
                x = ssm.subectCount(subject, "2018-06-01", "2018-06-30");
            } else if ("July".equals(month)) {
                x = ssm.subectCount(subject, "2018-07-01", "2018-07-31");
            } else if ("August".equals(month)) {
                x = ssm.subectCount(subject, "2018-08-01", "2018-08-31");
            } else if ("September".equals(month)) {
                x = ssm.subectCount(subject, "2018-09-01", "2018-09-30");
            } else if ("October".equals(month)) {
                x = ssm.subectCount(subject, "2018-10-01", "2018-10-31");
            } else if ("November".equals(month)) {
                x = ssm.subectCount(subject, "2018-11-01", "2018-11-30");
            } else if ("December".equals(month)) {
                x = ssm.subectCount(subject, "2018-12-01", "2018-12-31");
            } else {
                x = ssm.subectCount(subject, "2018-01-01", "2018-12-31");
            }

            XYChart.Series series = new XYChart.Series();
            series.setName(subject);
            series.getData().add(new XYChart.Data("", x));

            chartList.add(series);
        }

        for (int i = 0; i < chartList.size(); i++) {
            bcs.getData().add(chartList.get(i));
        }
        this.setCenter(bcs);
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
     *
     * @return the months
     */
    public String getMonths() {
        String month = months.getValue();
        return month;
    }

    /**
     * @param months the months to set
     */
    public void setMonths(ChoiceBox<String> months) {
        this.months = months;
    }

    /**
     * @return the subMonth
     */
    public Button getSubMonth() {
        return subMonth;
    }

    /**
     * @param subMonth the subMonth to set
     */
    public void setSubMonth(Button subMonth) {
        this.subMonth = subMonth;
    }

    /* @return the pass
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
