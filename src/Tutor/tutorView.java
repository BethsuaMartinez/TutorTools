/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutor;

import com.sun.prism.impl.Disposer.Record;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author beths
 */
public class tutorView extends BorderPane {

    ObservableList<RowData> data
            = FXCollections.observableArrayList(
                    new RowData("324872834","Jacob", "Smith", "Math", "12:00", "14:20", "04/05/2018"),
                    new RowData("34234","Isabella", "Johnson", "English", "16:30", "17:00", "03/24/2018"),
                    new RowData("876543","Ethan", "Williams", "History", "9:40", "11:20", "10/31/2018"),
                    new RowData("454656","Emma", "Jones", "Computer Science", "10:00", "13:10", "12/25/2018"),
                    new RowData("2346734","Michael", "Brown", "Physics", "8:30", "8:45", "04/06/2018"));

    private final TableView table = new TableView();

    private Button signOut = new Button("Log Out");
    private Button searchBtn = new Button("Search");
    private Button calender = new Button("Calender");
    private TextField searchTf = new TextField();
    private Button back = new Button("Back");
    private Button modify = new Button("Modify");
    private Button delete = new Button("Delete");
    
    public tutorView() {

        HBox top = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        HBox hb4 = new HBox();
        
        BackgroundImage background = new BackgroundImage(new Image("/resources/background.jpg", 3000, 3000, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        top.setBackground(new Background(background));
        top.setPadding(new Insets(10,10,10,10));
        
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/resources/TutorTools.PNG")));
        logo.setPreserveRatio(true);
        logo.setFitWidth(120);
        logo.setFitHeight(30);
        hb2.getChildren().add(logo);
        hb2.setPadding(new Insets(0,0,0,30));
        
        
        hb4.getChildren().addAll(back, signOut);
        hb4.setSpacing(5);
        hb3.getChildren().addAll(hb4);
        hb3.setAlignment(Pos.CENTER_RIGHT);
        hb3.setPadding(new Insets(0, 20, 0, 0));
        HBox.setHgrow(hb3, Priority.ALWAYS);
        top.getChildren().addAll(logo, hb3);
        top.setPadding(new Insets(5,0,5,20));

        this.searchBtn.setMaxSize(100, 20);       
        this.calender.setMaxSize(100, 20);
        this.back.setMaxSize(200, 20);
        this.signOut.setMaxSize(100, 20);  
        this.modify.setMaxSize(100, 20); 
        this.delete.setMaxSize(100, 20); 
        
        this.searchBtn.setPadding(new Insets(3,3,3,3));
        this.calender.setPadding(new Insets(3,3,3,3));
        this.back.setPadding(new Insets(5,10,5,10));
        this.signOut.setPadding(new Insets(5,10,5,10));
        this.modify.setPadding(new Insets(3,15,3,15));
        this.delete.setPadding(new Insets(3,15,3,15));
        
        this.searchBtn.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        this.calender.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");
        this.back.setStyle("-fx-font: 11 arial; -fx-border-color:#b6e7c9 ;");
        this.signOut.setStyle("-fx-font: 11 arial; -fx-border-color:#b6e7c9 ;");
        this.modify.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");
        this.delete.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");

        table.setItems(data);
        
        TableColumn studentIDcol = new TableColumn("Student ID");
        studentIDcol.setCellValueFactory(
                new PropertyValueFactory<>("studentID"));
        studentIDcol.setPrefWidth(110);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
        firstNameCol.setPrefWidth(110);
        
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
        lastNameCol.setPrefWidth(110);

        TableColumn subjectcol = new TableColumn("Subject");
        subjectcol.setCellValueFactory(
                new PropertyValueFactory<>("subject"));
        subjectcol.setPrefWidth(110);
        
        TableColumn timeInCol = new TableColumn("Time In");
        timeInCol.setCellValueFactory(
                new PropertyValueFactory<>("timeIn"));
        timeInCol.setPrefWidth(90);
        
        TableColumn timeOutCol = new TableColumn("Time Out");
        timeOutCol.setCellValueFactory(
                new PropertyValueFactory<>("timeOut"));
        timeOutCol.setPrefWidth(90);

        TableColumn dateCol = new TableColumn("Date");
        dateCol.setCellValueFactory(
                new PropertyValueFactory<>("date"));
        dateCol.setPrefWidth(90);
        
        table.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        table.getColumns().addAll(studentIDcol, firstNameCol, lastNameCol, subjectcol, timeInCol, timeOutCol, dateCol);
        table.setMaxWidth(800);
      
        BorderPane.setAlignment(table, Pos.CENTER);

        this.searchTf.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        this.searchTf.setPromptText("Ex. ID, First Name, Last Name");
        this.searchTf.setPrefSize(300, 20);

        HBox search = new HBox();
        search.setAlignment(Pos.CENTER);
        search.getChildren().addAll(searchTf, searchBtn, calender);
        search.setSpacing(10);
        search.setStyle(" -fx-padding: 10");
        
        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(table);
        
        HBox bottom = new HBox();
        bottom.getChildren().addAll(modify,delete);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(10);
       
        VBox center = new VBox();
        center.getChildren().addAll(search,tableBox,bottom);
        center.setSpacing(10);
       
        BorderPane.setMargin(center, new Insets(0,50,10,50));

        this.setCenter(center);
        this.setTop(top);
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
     * @return the search
     */
    public Button getSearchBtn() {
        return searchBtn;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(Button searchBtn) {
        this.searchBtn = searchBtn;
    }

    /**
     * @return the calender
     */
    public Button getCalender() {
        return calender;
    }

    /**
     * @param calender the calender to set
     */
    public void setCalender(Button calender) {
        this.calender = calender;
    }

    /**
     * @return the searchTf
     */
    public TextField getSearchTf() {
        return searchTf;
    }

    /**
     * @param searchTf the searchTf to set
     */
    public void setSearchTf(TextField searchTf) {
        this.searchTf = searchTf;
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
     * @return the modify
     */
    public Button getModify() {
        return modify;
    }

    /**
     * @param modify the modify to set
     */
    public void setModify(Button modify) {
        this.modify = modify;
    }

    /**
     * @return the delete
     */
    public Button getDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public static class RowData {
        
        private SimpleStringProperty studentID;
        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty subject;
        private SimpleStringProperty timeIn;
        private SimpleStringProperty timeOut;
        private SimpleStringProperty date;

        private RowData(String studentID,String fName, String lName, String subject, String timeIn, String timeOut, String date) {
            this.studentID=new SimpleStringProperty(studentID);
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.subject = new SimpleStringProperty(subject);
            this.timeIn = new SimpleStringProperty(timeIn);
            this.timeOut = new SimpleStringProperty(timeOut);
            this.date = new SimpleStringProperty(date);
        }

        /**
         * @return the firstName
         */
        public String getFirstName() {
            return firstName.get();
        }

        /**
         * @param firstName the firstName to set
         */
        public void setFirstName(SimpleStringProperty firstName) {
            this.firstName = firstName;
        }

        /**
         * @return the lastName
         */
        public String getLastName() {
            return lastName.get();
        }

        /**
         * @param lastName the lastName to set
         */
        public void setLastName(SimpleStringProperty lastName) {
            this.lastName = lastName;
        }

        /**
         * @return the subject
         */
        public String getSubject() {
            return subject.get();
        }

        /**
         * @param subject the subject to set
         */
        public void setSubject(SimpleStringProperty subject) {
            this.subject = subject;
        }

        /**
         * @return the timeIn
         */
        public String getTimeIn() {
            return timeIn.get();
        }

        /**
         * @param timeIn the timeIn to set
         */
        public void setTimeIn(SimpleStringProperty timeIn) {
            this.timeIn = timeIn;
        }

        /**
         * @return the timeOut
         */
        public String getTimeOut() {
            return timeOut.get();
        }

        /**
         * @param timeOut the timeOut to set
         */
        public void setTimeOut(SimpleStringProperty timeOut) {
            this.timeOut = timeOut;
        }

        /**
         * @return the studentID
         */
        public String getStudentID() {
            return studentID.get();
        }

        /**
         * @param studentID the studentID to set
         */
        public void setStudentID(SimpleStringProperty studentID) {
            this.studentID = studentID;
        }

        /**
         * @return the date
         */
        public String getDate() {
            return date.get();
        }

        /**
         * @param date the date to set
         */
        public void setDate(SimpleStringProperty date) {
            this.date = date;
        }

    }
}
