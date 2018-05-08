/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutor;

import Models.SessionModel;
import java.sql.SQLException;
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
import javafx.stage.Stage;


/**
 *
 * @author beths
 */
public class tutorView extends BorderPane {
    SessionModel sm = new SessionModel();
    
    ObservableList<RowData> sessiontableData= FXCollections.observableArrayList();

    private final TableView sessionTable = new TableView();

    private Button signOut = new Button("Log Out");
    private Button searchBtn = new Button("Search");
    private Button back = new Button("Back");
    private Button modify = new Button("Modify");
    private Button submitModify = new Button("Submit");
    private Button delete = new Button("Delete");
    
    //-------Labels and Text Fields
    private TextField searchTf = new TextField();
    private Label stID = new Label("Student ID*");
    private Label fName = new Label("First Name*");
    private Label lName = new Label("Last Name*");
    private Label tutorName = new Label("Tutor Name*");
    private Label subject = new Label("Subject*");
    
    private TextField stIDTF = new TextField();
    private TextField fNameTF = new TextField();
    private TextField lNameTF = new TextField();
    private TextField tutorNameTF = new TextField();
    private TextField subjectTF = new TextField();
    
    //-----VBox 
    VBox idBox = new VBox(stID, stIDTF);
    VBox fnameBox = new VBox(fName, fNameTF);
    VBox lnameBox = new VBox(lName, lNameTF);
    VBox tutorBox = new VBox(tutorName, tutorNameTF);
    VBox subjectBox = new VBox(subject, subjectTF);
    
    //----HBox
    HBox nameBox = new HBox(fnameBox,lnameBox);


    private String pass;
    
    
    
    public tutorView() throws SQLException {

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
        this.submitModify.setMaxSize(200, 20);
        this.back.setMaxSize(200, 20);
        this.signOut.setMaxSize(100, 20);  
        this.modify.setMaxSize(100, 20); 
        this.delete.setMaxSize(100, 20); 
        
        this.searchBtn.setPadding(new Insets(3,3,3,3));
        this.submitModify.setPadding(new Insets(5,10,5,10));
        this.back.setPadding(new Insets(5,10,5,10));
        this.signOut.setPadding(new Insets(5,10,5,10));
        this.modify.setPadding(new Insets(3,15,3,15));
        this.delete.setPadding(new Insets(3,15,3,15));
        
        this.searchBtn.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        this.submitModify.setStyle("-fx-font: 11 arial; -fx-border-color:#b6e7c9;");
        this.back.setStyle("-fx-font: 11 arial; -fx-border-color:#b6e7c9 ;");
        this.signOut.setStyle("-fx-font: 11 arial; -fx-border-color:#b6e7c9 ;");
        this.modify.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");
        this.delete.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");
        
        stIDTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        fNameTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        lNameTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        tutorNameTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        subjectTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        
        stIDTF.setPromptText("Student ID");
        fNameTF.setPromptText("Student First Name");
        lNameTF.setPromptText("Student Last Name");
        tutorNameTF.setPromptText("Tutor Name");
        subjectTF.setPromptText("Ex. math");

        sessiontableData= sm.populateSessionTable();
                
        sessionTable.setItems(sessiontableData);
        
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
        
        TableColumn tutorcol = new TableColumn("Tutor");
        tutorcol.setCellValueFactory(
                new PropertyValueFactory<>("tutor"));
        tutorcol.setPrefWidth(110);
        
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
        
        sessionTable.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        sessionTable.getColumns().addAll(studentIDcol, firstNameCol, lastNameCol, subjectcol, tutorcol, timeInCol, timeOutCol, dateCol);
        sessionTable.setMaxWidth(800);
      
        BorderPane.setAlignment(sessionTable, Pos.CENTER);

        this.searchTf.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        this.searchTf.setPromptText("Ex. ID, First Name, Last Name");
        this.searchTf.setPrefSize(300, 20);

        HBox search = new HBox();
        search.setAlignment(Pos.CENTER);
        search.getChildren().addAll(searchTf, searchBtn);
        search.setSpacing(10);
        search.setStyle(" -fx-padding: 10");
        
        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(sessionTable);
        
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
    
    public VBox modifyView(){
        VBox modify = new VBox();
        
        tutorView.RowData data;
        int index = getSessionTable().getSelectionModel().getSelectedIndex();
        data = (tutorView.RowData) sessionTable.getItems().get(index);
     
        modify.setAlignment(Pos.CENTER);
        modify.setPadding(new Insets(6, 6, 6, 6));
        
        stIDTF.setText(data.getStudentID());
        fNameTF.setText(data.getFirstName());
        lNameTF.setText(data.getLastName());
        tutorNameTF.setText(data.getTutor());
        subjectTF.setText(data.getSubject());
        
        stIDTF.setEditable(false);
        
        HBox h = new HBox(submitModify);
        h.setAlignment(Pos.CENTER);
        
        modify.getChildren().addAll(idBox, nameBox, tutorBox, subjectBox, h);
        modify.setSpacing(7);
        
        return modify;
    }
    
    public boolean confirmStudentModify(){
        int index = getSessionTable().getSelectionModel().getSelectedIndex();
        if (index == -1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("You must select a student to Modify/Delete");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();
            return false;
        }
        return true;
    }
        
    public void clearFields(){
        stIDTF.clear();
        fNameTF.clear();
        lNameTF.clear();
        tutorNameTF.clear();
        subjectTF.clear();
    }
    
    public void deleteFromTable() {

        if (confirmStudentModify()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Please Confirm Delete Action");
            alert.setContentText("Are you sure you want to delete this tutor?");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                tutorView.RowData selectedItem = (tutorView.RowData) sessionTable.getSelectionModel().getSelectedItem();
                sessionTable.getItems().remove(selectedItem);
            }
        }

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

    /**
     * @return the stIDTF
     */
    public TextField getStIDTF() {
        return stIDTF;
    }

    /**
     * @param stIDTF the stIDTF to set
     */
    public void setStIDTF(TextField stIDTF) {
        this.stIDTF = stIDTF;
    }

    /**
     * @return the fNameTF
     */
    public TextField getfNameTF() {
        return fNameTF;
    }

    /**
     * @param fNameTF the fNameTF to set
     */
    public void setfNameTF(TextField fNameTF) {
        this.fNameTF = fNameTF;
    }

    /**
     * @return the lNameTF
     */
    public TextField getlNameTF() {
        return lNameTF;
    }

    /**
     * @param lNameTF the lNameTF to set
     */
    public void setlNameTF(TextField lNameTF) {
        this.lNameTF = lNameTF;
    }

    /**
     * @return the tutorNameTF
     */
    public TextField getTutorNameTF() {
        return tutorNameTF;
    }

    /**
     * @param tutorNameTF the tutorNameTF to set
     */
    public void setTutorNameTF(TextField tutorNameTF) {
        this.tutorNameTF = tutorNameTF;
    }

    /**
     * @return the subjectTF
     */
    public TextField getSubjectTF() {
        return subjectTF;
    }

    /**
     * @param subjectTF the subjectTF to set
     */
    public void setSubjectTF(TextField subjectTF) {
        this.subjectTF = subjectTF;
    }

    /**
     * @return the sessionTable
     */
    public TableView getSessionTable() {
        return sessionTable;
    }

    /**
     * @return the submitModify
     */
    public Button getSubmitModify() {
        return submitModify;
    }

    /**
     * @param submitModify the submitModify to set
     */
    public void setSubmitModify(Button submitModify) {
        this.submitModify = submitModify;
    }

    public static class RowData {
        
        private SimpleStringProperty studentID;
        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty subject;
        private SimpleStringProperty tutor;
        private SimpleStringProperty timeIn;
        private SimpleStringProperty timeOut;
        private SimpleStringProperty date;

        public RowData(String studentID,String fName, String lName, String subject, String tutor, String timeIn, String timeOut, String date) {
            this.studentID=new SimpleStringProperty(studentID);
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.subject = new SimpleStringProperty(subject);
            this.tutor = new SimpleStringProperty(tutor);
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

        /**
         * @return the tutor
         */
        public String getTutor() {
            return tutor.get();
        }

        /**
         * @param tutor the tutor to set
         */
        public void setTutor(SimpleStringProperty tutor) {
            this.tutor = tutor;
        }

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