/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Models.StudentModel;
import Models.TutorModel;
import Student.Student;
import java.util.Optional;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
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
import org.controlsfx.control.textfield.CustomPasswordField;

/**
 *
 * @author segarra
 */
public class infoView extends BorderPane {

    TutorModel tm = new TutorModel();
    StudentModel sm = new StudentModel();
    
    //-------------------Buttons-----------------------
    private Button email = new Button("E-Mail");
    private Button addType = new Button("Submit");
    private Button add = new Button("Add");
    private Button delete = new Button("Delete");
    private Button search = new Button("Search");
    private Button back = new Button("Back");
    private Button activity= new Button("Activity Log");
    private Button modify = new Button("Modify");
    private Button signOut = new Button("Log Out");
    private Button newTutorSubmitBtn = new Button("Submit");
    private Button studentSubmitBtn = new Button("Submit");
    private Button modifyStudent = new Button("Modify");
    private Button modifyTutor = new Button("Modify");
    
    //-------------Table--------------------------------
    private TableView tutorTable = new TableView();
    private TableView studentTable = new TableView();
    
    //----------Labels & TF-------------------------
    private Label idLabel = new Label ("ID Number*");
    private TextField idTF = new TextField();
    
    private Label fNameLabel = new Label ("First Name*");
    private TextField fNameTF = new TextField();
    
    private Label lNameLabel = new Label ("Last Name*");
    private TextField lNameTF = new TextField();
    
    private Label emailLabel = new Label("E-Mail");
    private TextField emailTF = new TextField();
    
    private Label phoneLabel = new Label ("Phone Number");
    private TextField phoneTF = new TextField();
    
    private Label subjectLabel = new Label ("Subject*");
    private TextField subjectTF = new TextField();
    
    private Label searchLabel = new Label("Search");
    private TextField searchTF = new TextField();
    
    private Label student = new Label("Student");
    private Label tutor = new Label("Tutor");
    Label type = new Label("Enter a new");
    
    private Label password = new Label("Password");
    private CustomPasswordField passwordTF = new CustomPasswordField();
    
    //----------Dropdown Menu--------------------
    private ChoiceBox<String> typePerson = new ChoiceBox<>();
    private ChoiceBox<String> typePerson2 = new ChoiceBox<>();
    
    //----------Vboxes----------------------------
    VBox typebox = new VBox(type, typePerson);
    private VBox idVbox = new VBox(idLabel, idTF);
    private VBox emailVbox = new VBox(emailLabel, emailTF);
    private VBox phoneVbox = new VBox(phoneLabel, phoneTF);
    private VBox passwordVbox = new VBox(password, passwordTF);
    private VBox subjectVbox = new VBox(subjectLabel, subjectTF);
    
    private VBox vb = new VBox();
    private VBox vb2 =new VBox();
    
    //---------HBoxes---------------
    HBox hbox = new HBox();
    
    //----------------------Data for Tables---------------------------------
    ObservableList<infoView.tutorRowData> tutortableData = FXCollections.observableArrayList();
    ObservableList<infoView.studentRowData> studenttableData = FXCollections.observableArrayList();
    
    private String pass;

    public  infoView() throws SQLException {
       
        HBox hb = new HBox();
        
        HBox hb2 = new HBox();
        hb2.setPadding(new Insets(0,0,0,30));
        
        HBox hb3 = new HBox();
        HBox.setHgrow(hb3, Priority.ALWAYS);
        hb3.getChildren().addAll(email,activity,back, signOut);
        hb3.setSpacing(10);
        hb3.setAlignment(Pos.CENTER_RIGHT);
        hb3.setPadding(new Insets(0, 20, 0, 0));
        
        BackgroundImage background = new BackgroundImage(new Image("/resources/background.jpg", 3000, 3000, false, true),
                                         BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        hb.setBackground(new Background(background));
        hb.setPadding(new Insets(10,10,10,10));
        
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/resources/TutorTools.PNG")));
        logo.setPreserveRatio(true);
        logo.setFitWidth(120);
        logo.setFitHeight(30);
        
        hb2.getChildren().add(logo);
        hb.getChildren().addAll(logo, hb3);
        hb.setPadding(new Insets(5,0,5,20));
        
        tutor.setAlignment(Pos.CENTER_LEFT);
        tutor.setPadding(new Insets(5,0,5,10));
       
        this.setTop(hb);
        studentList();
        
        search.setPrefSize(100, 10);
        
        //---------set Buttons  and TF style
        idTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        fNameTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        lNameTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        emailTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        phoneTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        subjectTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        searchTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        passwordTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        
        email.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        addType.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        add.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        delete.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        search.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        back.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        activity.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        modify.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        signOut.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        newTutorSubmitBtn.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        studentSubmitBtn.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        
        typePerson.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        typePerson2.setStyle("-fx-font: 12 arial; -fx-border-color:#b6e7c9;");
        
        //---------set prompts
        
    
        idTF.setPromptText("ID number");
        fNameTF.setPromptText("First Name");
        lNameTF.setPromptText("Last Name");
        emailTF.setPromptText("Ex. student@example.edu");
        phoneTF.setPromptText("(956)999-9999");
        subjectTF.setPromptText("Ex. math");
        passwordTF.setPromptText("Password");
        searchTF.setPromptText("Ex. ID, First Name, Last Name");
        
        
        //----------setPref sizes
        this.activity.setMaxSize(100, 20);       
        this.email.setMaxSize(100, 20);
        this.back.setMaxSize(200, 20);
        this.signOut.setMaxSize(100, 20);  
        this.modify.setMaxSize(100, 20); 
        this.delete.setMaxSize(100, 20); 
        this.add.setMaxSize(100, 20);
        
        this.activity.setPadding(new Insets(5,10,5,10));
        this.email.setPadding(new Insets(5,10,5,10));
        this.back.setPadding(new Insets(5,10,5,10));
        this.signOut.setPadding(new Insets(5,10,5,10));
        this.modify.setPadding(new Insets(3,15,3,15));
        this.delete.setPadding(new Insets(3,15,3,15));
        this.add.setPadding(new Insets(3,15,3,15));
       searchTF.setPrefSize(300, 20);
        
        
                //-------------------------Tutor Table--------------------------------------
        
                
        tutortableData= tm.populateTable();
                
        tutorTable.setItems(tutortableData);
        tutorTable.setTranslateX(5);
        tutorTable.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        tutorTable.setMaxWidth(1000);
        
        tutorTable.setMaxSize(650, 250);
        tutorTable.setTranslateX(5);
        
        tutor.setPrefSize(100, 10);
        
        typePerson.getItems().addAll("Student", "Tutor");
        typePerson.setValue("Student");
        typePerson2.getItems().addAll("Student", "Tutor");
        typePerson2.setValue("Student");
        
        
       
        TableColumn tutoridCol = new TableColumn("ID");
        tutoridCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        tutoridCol.setPrefWidth(110);
        
        TableColumn tutorfNameCol = new TableColumn("First Name");
        tutorfNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
        tutoridCol.setPrefWidth(110);
        
        TableColumn tutorlNameCol = new TableColumn("Last Name");
        tutorlNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
        tutoridCol.setPrefWidth(110);
        
        TableColumn tutoremailCol = new TableColumn("Email");
        tutoremailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        tutoridCol.setPrefWidth(110);
        
        TableColumn tutorphoneCol = new TableColumn("Phone");
        tutorphoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tutoridCol.setPrefWidth(110);
        
        TableColumn tutorsubjectCol = new TableColumn("Subject");
        tutorsubjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        tutoridCol.setPrefWidth(110);
        
        tutorTable.getColumns().addAll(tutoridCol, tutorfNameCol, tutorlNameCol, tutoremailCol, tutorsubjectCol, tutorphoneCol);
        tutorTable.setMinWidth(687);
        
                //------------------------Table Student----------------------------------------------

                
        studenttableData = sm.populateTable();
        studentTable.setItems(studenttableData);
        
        studentTable.setMaxSize(650, 250);
        studentTable.setTranslateX(5);
        studentTable.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        studentTable.setMaxWidth(800);
        
        student.setTranslateX(10);
        student.setAlignment(Pos.BASELINE_CENTER);
        student.setPadding(new Insets(5,0,5,0));
        
        TableColumn studentidCol = new TableColumn("ID");
        studentidCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentidCol.setPrefWidth(110);
        
        TableColumn studentfNameCol = new TableColumn("First Name");
        studentfNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
        studentfNameCol.setPrefWidth(110);        
        
        TableColumn studentlNameCol = new TableColumn("Last Name");
        studentlNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
        studentlNameCol.setPrefWidth(110);        
        
        TableColumn studentemailCol = new TableColumn("Email");
        studentemailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentemailCol.setPrefWidth(210);        
        
        TableColumn studentphoneCol = new TableColumn("Phone");
        studentphoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        studentphoneCol.setPrefWidth(110);              
        
        studentTable.getColumns().addAll(studentidCol, studentfNameCol, studentlNameCol, studentemailCol, studentphoneCol);
        studentTable.setMinWidth(652);
        

        hbox.setPadding(new Insets(5));
        hbox.setSpacing(20);
        hbox.setTranslateX(5);
        hbox.getChildren().addAll(searchLabel, searchTF, typePerson, search);
        hbox.setAlignment(Pos.CENTER);
    }
   
    public void updateTutorTable() throws SQLException{
        tutortableData = tm.populateTable();
        tutorTable.setItems(tutortableData);
        
        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(tutorTable);
        HBox hb4 = new HBox(add, delete, modify);
        hb4.setPadding(new Insets(10));
        hb4.setSpacing(20);
        hb4.setAlignment(Pos.BOTTOM_CENTER);
        vb2.getChildren().clear();
        vb2.getChildren().addAll(tutor,hbox, tableBox, hb4);
        vb2.setSpacing(7);
        
        this.setCenter(vb2);
    }
    
    public void updateStudentTable() throws SQLException{
        studenttableData = sm.populateTable();
        studentTable.setItems(studenttableData);
        
        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(tutorTable);
        HBox hb4 = new HBox(add, delete, modify);
        hb4.setPadding(new Insets(10));
        hb4.setSpacing(20);
        hb4.setAlignment(Pos.BOTTOM_CENTER);
        vb.getChildren().clear();
        vb.getChildren().addAll(tutor,hbox,tableBox,hb4);
        vb.setSpacing(7);
        this.setCenter(vb);
    }
    
    public void searchTutor(String idNo, String fname, String lname, String subject) throws SQLException{
        
        tutortableData = tm.searchTutor(idNo, fname, lname, subject);
        tutorTable.setItems(tutortableData);
        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(tutorTable);
        HBox hb4 = new HBox(add, delete, modify);
        hb4.setPadding(new Insets(10));
        hb4.setSpacing(20);
        hb4.setAlignment(Pos.BOTTOM_CENTER);
        vb2.getChildren().clear();
        vb2.getChildren().addAll(tutor,hbox, tableBox, hb4);
        vb2.setSpacing(7);
        
        this.setCenter(vb2);
    }
    
    public void searchStudent(String idNo, String fname, String lname) throws SQLException{
        
        studenttableData = sm.searchStudent(idNo, fname, lname);
        
        studentTable.setItems(studenttableData);
        
        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(studentTable);
        HBox hb4 = new HBox(add, delete, modify);
        hb4.setPadding(new Insets(10));
        hb4.setSpacing(20);
        hb4.setAlignment(Pos.BOTTOM_CENTER);
        vb.getChildren().clear();
        vb.getChildren().addAll(student,hbox,tableBox,hb4);
        vb.setSpacing(7);
        this.setCenter(vb);
    }
    
    
    public void tutorList() throws SQLException{
        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(tutorTable);
        HBox hb4 = new HBox(add, delete, modify);
        hb4.setPadding(new Insets(10));
        hb4.setSpacing(20);
        hb4.setAlignment(Pos.BOTTOM_CENTER);
        vb.getChildren().clear();
        vb.getChildren().addAll(tutor,hbox,tableBox,hb4);
        vb.setSpacing(7);
        this.setCenter(vb);    
    }
    
    public void studentList() throws SQLException{

        HBox tableBox = new HBox();
        tableBox.setAlignment(Pos.CENTER);
        tableBox.getChildren().add(studentTable);
        HBox hb4 = new HBox(add, delete, modify);
        hb4.setPadding(new Insets(10));
        hb4.setSpacing(20);
        hb4.setAlignment(Pos.BOTTOM_CENTER);
        vb2.getChildren().clear();
        vb2.getChildren().addAll(student,hbox, tableBox, hb4);
        vb2.setSpacing(7);
        this.setCenter(vb2);
    }
    
    
    public VBox modifyTutor(){
        VBox layout = new VBox();
     
        infoView.tutorRowData data;
        int index = getTutorTable().getSelectionModel().getSelectedIndex();
        data = (infoView.tutorRowData) tutorTable.getItems().get(index);
      
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(6, 6, 6, 6));
        
        VBox v = new VBox(fNameLabel,fNameTF );
        VBox v1 = new VBox(lNameLabel, lNameTF);
        
        HBox h = new HBox(v, v1);
        idTF.setText(data.getId());
        emailTF.setText(data.getEmail());
        phoneTF.setText(data.getPhone());
        subjectTF.setText(data.getSubject());
        fNameTF.setText(data.getFName());
        lNameTF.setText(data.getLName());
        
        idTF.setEditable(false);
        
        layout.getChildren().addAll(idVbox, h, emailVbox, passwordVbox, phoneVbox, subjectVbox, modifyTutor);

    
        return layout;
    }
    
    
    public VBox modifyStudent(){
        VBox layout = new VBox();
     
        infoView.studentRowData data;
        int index = getStudentTable().getSelectionModel().getSelectedIndex();
        data = (infoView.studentRowData) studentTable.getItems().get(index);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(6, 6, 6, 6));
        
        VBox v = new VBox(fNameLabel,fNameTF );
        VBox v1 = new VBox(lNameLabel, lNameTF);
        
        HBox h = new HBox(v, v1);
        idTF.setText(data.getId());
        emailTF.setText(data.getEmail());
        phoneTF.setText(data.getPhone());
        fNameTF.setText(data.getFName());
        lNameTF.setText(data.getLName());
        
        idTF.setEditable(false);
        
        layout.getChildren().addAll(idVbox, h, emailVbox, phoneVbox, modifyStudent);
        
    
        return layout;
    
    }
    
    public boolean confirmStudentModify(){
        int index = getStudentTable().getSelectionModel().getSelectedIndex();
        if (index == -1){
            Alert alert = new Alert(AlertType.WARNING);
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
    
    public boolean confirmTutorModify(){
        int index = getTutorTable().getSelectionModel().getSelectedIndex();
        if (index == -1){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No Tutor Selected");
            alert.setContentText("You must select a tutor to Modify/Delete");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));
            alert.showAndWait();
            return false;
        }
        return true;
    }
    
    
    public VBox addTutor() {
        VBox layout = new VBox();

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(6, 6, 6, 6));
        
        VBox v = new VBox(fNameLabel,fNameTF );
        VBox v1 = new VBox(lNameLabel, lNameTF);
        
        HBox h = new HBox(v, v1);
        
        layout.getChildren().addAll(idVbox, h, emailVbox, passwordVbox, phoneVbox, subjectVbox, newTutorSubmitBtn);

        return layout;
    }

    
    public VBox addStudent(){
        VBox layout = new VBox();

        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(6, 6, 6, 6));

        VBox v = new VBox(fNameLabel,fNameTF );
        VBox v1 = new VBox(lNameLabel, lNameTF);
        
        HBox h = new HBox(v, v1);
        
        layout.getChildren().add(idVbox);
        layout.getChildren().add(h);
        layout.getChildren().add(emailVbox);
        layout.getChildren().add(phoneVbox);
        layout.getChildren().add(studentSubmitBtn);

        return layout;
    }
    
 
    public void deleteFromTable() throws SQLException {

        if ("Tutor".equals(getTypePerson())) {
            if (confirmTutorModify()) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Please Confirm Delete Action");
                alert.setContentText("Are you sure you want to delete this tutor?");
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("/resources/Logo.png"));

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                    infoView.tutorRowData selectedItem = (infoView.tutorRowData) tutorTable.getSelectionModel().getSelectedItem();
                            String idNo=selectedItem.getId();
                tm.deleteTutor(idNo);
                    tutorTable.getItems().remove(selectedItem);
                }

            }
        } else if (confirmStudentModify()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Please Confirm Delete Action");
            alert.setContentText("Are you sure you want to delete this student?");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/resources/Logo.png"));

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                infoView.studentRowData selectedItem = (infoView.studentRowData) studentTable.getSelectionModel().getSelectedItem();
                
                String idNo = selectedItem.getId();
                sm.deleteStudent(idNo);
                
                studentTable.getItems().remove(selectedItem);
            }
        }
    }


    /**
     * @return the password
     */
    public Label getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(Label password) {
        this.password = password;
    }

    /**
     * @return the passwordTF
     */
    public TextField getPasswordTF() {
        return passwordTF;
    }

    /**
     * @param passwordTF the passwordTF to set
     */
    public void setPasswordTF(CustomPasswordField passwordTF) {
        this.passwordTF = passwordTF;
    }
    
     public static class tutorRowData {     
     
        private SimpleStringProperty fName;
        private SimpleStringProperty lName;
        private SimpleStringProperty subject;
        private SimpleStringProperty phone;
        private SimpleStringProperty email;
        private SimpleStringProperty id;

        public tutorRowData(String id, String fName, String lName, String email, String subject, String phone) {
            this.id = new SimpleStringProperty(id);
            this.fName = new SimpleStringProperty(fName);
            this.lName = new SimpleStringProperty(lName);
            this.subject = new SimpleStringProperty(subject);
            this.phone = new SimpleStringProperty(phone);
            this.email = new SimpleStringProperty(email);
           
     }
        
       

        /**
         * @return the firstName
         */
        public String getFName() {
            return fName.get();
        }

        /**
         */
        public void setFName(SimpleStringProperty fName) {
            this.fName = fName;
        }

        /**
         * @return the lastName
         */
        public String getLName() {
            return lName.get();
        }

        /**
         * @param lastName the lastName to set
         */
        public void setLName(SimpleStringProperty lName) {
            this.lName = lName;
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
         * @return the phone
         */
        public String getPhone() {
            return phone.get();
        }

        /**
         * @param phone the phone to set
         */
        public void setPhone(SimpleStringProperty phone) {
            this.phone = phone;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email.get();
        }

        /**
         * @param email the email to set
         */
        public void setEmail(SimpleStringProperty email) {
            this.email = email;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id.get();
        }

        /**
         * @param id the id to set
         */
        public void setId(SimpleStringProperty id) {
            this.id = id;
        }
     }
     
public static class studentRowData {     
     
        private SimpleStringProperty fName;
        private SimpleStringProperty lName;
        private SimpleStringProperty phone;
        private SimpleStringProperty email;
        private SimpleStringProperty id;

        public studentRowData(String id, String fName, String lName, String email, String phone) {
            this.id = new SimpleStringProperty(id);
            this.fName = new SimpleStringProperty(fName);
            this.lName = new SimpleStringProperty(lName);
            this.phone = new SimpleStringProperty(phone);
            this.email = new SimpleStringProperty(email);
           
     }

        /**
         * @return the firstName
         */
        public String getFName() {
            return fName.get();
        }

        /**
         */
        public void setFName(SimpleStringProperty fName) {
            this.fName = fName;
        }

        /**
         * @return the lastName
         */
        public String getLName() {
            return lName.get();
        }

        /**
         * @param lastName the lastName to set
         */
        public void setLName(SimpleStringProperty lName) {
            this.lName = lName;
        }

        /**
         * @return the phone
         */
        public String getPhone() {
            return phone.get();
        }

        /**
         * @param phone the phone to set
         */
        public void setPhone(SimpleStringProperty phone) {
            this.phone = phone;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email.get();
        }

        /**
         * @param email the email to set
         */
        public void setEmail(SimpleStringProperty email) {
            this.email = email;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id.get();
        }

        /**
         * @param id the id to set
         */
        public void setId(SimpleStringProperty id) {
            this.id = id;
        }
     }     
      public void ClearFields() {
        getIdTF().clear();
        getfNameTF().clear();
        getlNameTF().clear();
        getPhoneTF().clear();
        getEmailTF().clear();
        getSubjectTF().clear();
        getPasswordTF().clear();

    }
      
     public void updateTutorTable(Tutor currentTutor) {
        String fName = currentTutor.getFirstName();
        String lName = currentTutor.getLastName();
        String subject = currentTutor.getSubject();
        String email = currentTutor.getEmail();
        int idNo = currentTutor.getID();
        String id = String.valueOf(idNo);
        String phone = currentTutor.getPhone();
        
        System.out.println(id+" "+fName+" "+lName+" "+email+" "+phone+" "+subject);
        
        infoView.tutorRowData tutorRowData = new infoView.tutorRowData(id, fName, lName,email, subject, phone);
        tutortableData.add(tutorRowData);
        tutorTable.setItems(tutortableData);
    }
     
     public void updateStudentTable(Student currentStudent) {
        String fName = currentStudent.getFname();
        String lName = currentStudent.getLname();
        String email = currentStudent.getEmail();
        int idNo = currentStudent.getIdStudent();
        String id = String.valueOf(idNo);
        String phone = currentStudent.getPhone();
        
        infoView.studentRowData studentRowData = new infoView.studentRowData(id, fName, lName, email, phone);
        studenttableData.add(studentRowData);
        studentTable.setItems(studenttableData);
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
 /**
     * @return the idLabel
     */
    public Label getIdLabel() {
        return idLabel;
    }

    /**
     * @param idLabel the idLabel to set
     */
    public void setIdLabel(Label idLabel) {
        this.idLabel = idLabel;
    }

    /**
     * @return the idTF
     */
    public TextField getIdTF() {
        return idTF;
    }

    /**
     * @param idTF the idTF to set
     */
    public void setIdTF(TextField idTF) {
        this.idTF = idTF;
    }

    /**
     * @return the fNameLabel
     */
    public Label getfNameLabel() {
        return fNameLabel;
    }

    /**
     * @param fNameLabel the fNameLabel to set
     */
    public void setfNameLabel(Label fNameLabel) {
        this.fNameLabel = fNameLabel;
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
     * @return the lNameLabel
     */
    public Label getlNameLabel() {
        return lNameLabel;
    }

    /**
     * @param lNameLabel the lNameLabel to set
     */
    public void setlNameLabel(Label lNameLabel) {
        this.lNameLabel = lNameLabel;
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
     * @return the emailLabel
     */
    public Label getEmailLabel() {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void setEmailLabel(Label emailLabel) {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the emailLF
     */
    public TextField getEmailTF() {
        return emailTF;
    }

    /**
     * @param emailLF the emailLF to set
     */
    public void setEmailTF(TextField emailTF) {
        this.emailTF = emailTF;
    }

    /**
     * @return the phoneLabel
     */
    public Label getPhoneLabel() {
        return phoneLabel;
    }

    /**
     * @param phoneLabel the phoneLabel to set
     */
    public void setPhoneLabel(Label phoneLabel) {
        this.phoneLabel = phoneLabel;
    }

    /**
     * @return the phoneTF
     */
    public TextField getPhoneTF() {
        return phoneTF;
    }

    /**
     * @param phoneTF the phoneTF to set
     */
    public void setPhoneTF(TextField phoneTF) {
        this.phoneTF = phoneTF;
    }

    /**
     * @return the subjectLabel
     */
    public Label getSubjectLabel() {
        return subjectLabel;
    }

    /**
     * @param subjectLabel the subjectLabel to set
     */
    public void setSubjectLabel(Label subjectLabel) {
        this.subjectLabel = subjectLabel;
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
<<<<<<< HEAD
     * @return the add
     */
    public Button getAdd() {
        return add;
    }

    /**
     * @param add the add to set
     */
    public void setAdd(Button add) {
        this.add = add;
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
     * @return the newTutorSubmitBtn
     */
    public Button getNewTutorSubmitBtn() {
        return newTutorSubmitBtn;
    }

    /**
     * @param newTutorSubmitBtn the newTutorSubmitBtn to set
     */
    public void setNewTutorSubmitBtn(Button newTutorSubmitBtn) {
        this.newTutorSubmitBtn = newTutorSubmitBtn;
    }

    /**
     * @return the idVbox
     */
    public VBox getIdVbox() {
        return idVbox;
    }

    /**
     * @param idVbox the idVbox to set
     */
    public void setIdVbox(VBox idVbox) {
        this.idVbox = idVbox;
    }


    /**
     * @return the emailVbox
     */
    public VBox getEmailVbox() {
        return emailVbox;
    }

    /**
     * @param emailVbox the emailVbox to set
     */
    public void setEmailVbox(VBox emailVbox) {
        this.emailVbox = emailVbox;
    }

    /**
     * @return the phoneVbox
     */
    public VBox getPhoneVbox() {
        return phoneVbox;
    }

    /**
     * @param phoneVbox the phoneVbox to set
     */
    public void setPhoneVbox(VBox phoneVbox) {
        this.phoneVbox = phoneVbox;
    }

    /**
     * @return the subjectVbox
     */
    public VBox getSubjectVbox() {
        return subjectVbox;
    }

    /**
     * @param subjectVbox the subjectVbox to set
     */
    public void setSubjectVbox(VBox subjectVbox) {
        this.subjectVbox = subjectVbox;
    }

    /**
     * @return the studentSubmitBtn
     */
    public Button getStudentSubmitBtn() {
        return studentSubmitBtn;
    }

    /**
     * @param studentSubmitBtn the studentSubmitBtn to set
     */
    public void setStudentSubmitBtn(Button studentSubmitBtn) {
        this.studentSubmitBtn = studentSubmitBtn;
    }
     /* @return the email
     */
    public Button getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Button email) {
        this.email = email;

    }

    /**
     * @return the addType
     */
    public Button getAddType() {
        return addType;
    }

    /**
     * @param addType the addType to set
     */
    public void setAddType(Button addType) {
        this.addType = addType;
    }

    /**
     * @return the typePerson
     */
    public String getTypePerson() {
        String person = typePerson.getValue();
        return person;
    }

    /**
     * @param typePerson the typePerson to set
     */
    public void setTypePerson(ChoiceBox<String> typePerson) {
        this.typePerson = typePerson;
    }

    /**
     * @return the tutorTable
     */
    public TableView getTutorTable() {
        return tutorTable;
    }

    /**
     * @param tutorTable the tutorTable to set
     */
    public void setTutorTable(TableView tutorTable) {
        this.tutorTable = tutorTable;
    }

    /**
     * @return the studentTable
     */
    public TableView getStudentTable() {
        return studentTable;
    }

    /**
     * @param studentTable the studentTable to set
     */
    public void setStudentTable(TableView studentTable) {
        this.studentTable = studentTable;
    }

    /**
     * @return the searchLabel
     */
    public Label getSearchLabel() {
        return searchLabel;
    }

    /**
     * @param searchLabel the searchLabel to set
     */
    public void setSearchLabel(Label searchLabel) {
        this.searchLabel = searchLabel;
    }

    /**
     * @return the searchTF
     */
    public TextField getSearchTF() {
        return searchTF;
    }

    /**
     * @param searchTF the searchTF to set
     */
    public void setSearchTF(TextField searchTF) {
        this.searchTF = searchTF;
    }

    /**
     * @return the studenttableData
     */
    public ObservableList<infoView.studentRowData> getStudenttableData() {
        return studenttableData;
    }

    /**
     * @param studenttableData the studenttableData to set
     */
    public void setStudenttableData(ObservableList<infoView.studentRowData> studenttableData) {
        this.studenttableData = studenttableData;
    }

    /**
     * @return the modifyStudent
     */
    public Button getModifyStudent() {
        return modifyStudent;
    }

    /**
     * @param modifyStudent the modifyStudent to set
     */
    public void setModifyStudent(Button modifyStudent) {
        this.modifyStudent = modifyStudent;
    }

    /**
     * @return the modifyTutor
     */
    public Button getModifyTutor() {
        return modifyTutor;
    }

    /**
     * @param modifyTutor the modifyTutor to set
     */
    public void setModifyTutor(Button modifyTutor) {
        this.modifyTutor = modifyTutor;
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