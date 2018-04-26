/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import com.sun.prism.impl.Disposer;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author elyvic
 */
public class studentView extends BorderPane {

    studentModel sm = new studentModel();
    private GridPane gridpane = new GridPane();
    private GridPane newStudentGridpane = new GridPane();
    private GridPane studentIdGridpane = new GridPane();
    private GridPane newSessionGridpane = new GridPane();

    private Button addBtn = new Button("Add Session");

    private Button signOut = new Button("Log Out");
    private Button supervisor = new Button("Supervisor");
    private Button tutor = new Button("Tutor");
    private Button backNew = new Button("Back"); 
    private Button submitSt = new Button("Submit");
    private Button submitSs = new Button("Submit");
    private Button submitId = new Button("Submit");

    ObservableList<studentView.RowData> tableData = FXCollections.observableArrayList(new studentView.RowData("Jacob", "Smith", "english", "12:00", "23432", "Luis"));

    private final TableView table = new TableView();

    private Label idNoLabel = new Label("ID Number");
    private TextField idNoTF = new TextField();

    private Label newStudentIdNoLabel = new Label("ID Number");
    private TextField newStudentIdNoTF = new TextField();

    private Label firstNameLabel = new Label("First Name");
    private TextField firstNameTF = new TextField();

    private Label lastNameLabel = new Label("Last Name");
    private TextField lastNameTF = new TextField();

    private Label emailLabel = new Label("E-Mail");
    private TextField emailTF = new TextField();

    private Label phoneNoLabel = new Label("Phone Number");
    private TextField phoneNoTF = new TextField();

    private Label subjectLabel = new Label("Subject");
    private TextField subjectTF = new TextField();

    private Label tutorLabel = new Label("Tutor");
    private TextField tutorTF = new TextField();

    private VBox idNoVbox = new VBox(newStudentIdNoLabel, newStudentIdNoTF);
    private VBox firstNameVbox = new VBox(firstNameLabel, firstNameTF);
    private VBox lastNameVbox = new VBox(lastNameLabel, lastNameTF);
    private VBox emailVbox = new VBox(emailLabel, emailTF);
    private VBox phoneNoVbox = new VBox(phoneNoLabel, phoneNoTF);
    private VBox subjectVbox = new VBox(subjectLabel, subjectTF);
    private VBox tutorVbox = new VBox(tutorLabel, tutorTF);

    private VBox idVbox = new VBox(idNoLabel, idNoTF);
    private VBox vbox10 = new VBox(tutor, supervisor, addBtn);

    public studentView() {

        HBox hb = new HBox();
        BackgroundImage background = new BackgroundImage(new Image("/resources/background.jpg", 3000, 3000, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        hb.setBackground(new Background(background));
        hb.setPrefSize(300, 40);
        hb.setPadding(new Insets(0, 20, 20, 20));

        this.tutor.setMaxSize(200, 30);
        this.supervisor.setMaxSize(200, 30);
        this.addBtn.setMaxSize(200, 40);
        this.tutor.setPadding(new Insets(10, 50, 10, 50));
        this.supervisor.setPadding(new Insets(10, 50, 10, 50));
        this.addBtn.setPadding(new Insets(10, 50, 10, 50));
        this.tutor.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        this.supervisor.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");
        this.addBtn.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");

        ImageView user = new ImageView(new Image(getClass().getResourceAsStream("/resources/user.png")));
        user.setFitHeight(15);
        user.setFitWidth(16);
        this.tutor.setGraphic(user);

        ImageView supervisor = new ImageView(new Image(getClass().getResourceAsStream("/resources/supervisor.png")));
        supervisor.setFitHeight(20);
        supervisor.setFitWidth(20);
        this.supervisor.setGraphic(supervisor);

        ImageView userPlus = new ImageView(new Image(getClass().getResourceAsStream("/resources/userPlus.png")));
        userPlus.setFitHeight(18);
        userPlus.setFitWidth(16);
        this.addBtn.setGraphic(userPlus);

        vbox10.setSpacing(10);
        vbox10.setPadding(new Insets(5, 0, 0, 20));

        table.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");

        table.setItems(tableData);

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        //idCol.setMaxWidth(5000);
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        //firstNameCol.setMaxWidth(5000);
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        //lastNameCol.setMaxWidth(5000);
        TableColumn subjectcol = new TableColumn("Subject");
        subjectcol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        //subjectcol.setMaxWidth(5000);
        TableColumn tutorcol = new TableColumn("Tutor");
        tutorcol.setCellValueFactory(new PropertyValueFactory<>("tutor"));
        //tutorcol.setMaxWidth(5000);
        TableColumn timeInCol = new TableColumn("TimeIn");
        timeInCol.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        //timeInCol.setMaxWidth(5000);
        TableColumn actionCol = new TableColumn("Action");

        //Adding the Button to the cell
        actionCol.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new studentView.ButtonCell();
            }

        });
        table.getColumns().addAll(idCol, firstNameCol, lastNameCol, tutorcol, subjectcol, timeInCol, actionCol);
        this.table.setPrefWidth(700);

        //Hbox
        //   buttonHbox.setSpacing(3);
        idNoVbox.setSpacing(3);
        firstNameVbox.setSpacing(3);
        lastNameVbox.setSpacing(3);
        emailVbox.setSpacing(3);
        phoneNoVbox.setSpacing(3);

        BorderPane.setMargin(table, new Insets(10, 10, 10, 10));
        //    BorderPane.setMargin(vbox10, new Insets(10, 10, 10, 10));

        //   buttonHbox.setAlignment(Pos.CENTER);
        this.setRight(table);
        this.setLeft(vbox10);
        this.setTop(hb);
        //  this.setBottom(buttonHbox);

    }

    public GridPane addSession(){
        //studentIdGridPane
        studentIdGridpane.setAlignment(Pos.CENTER);
        studentIdGridpane.setVgap(5);

        idVbox.setSpacing(5);

        studentIdGridpane.addRow(1, submitId);
        studentIdGridpane.addRow(0, idVbox);
        
        return studentIdGridpane;
    }

    public GridPane newStudent() {
        //newStudentGridPane
        newStudentGridpane.setVgap(5);
        newStudentGridpane.setHgap(5);
        newStudentGridpane.setAlignment(Pos.CENTER);

        //new student scene gripdane
        newStudentGridpane.addRow(0, idNoVbox);
        newStudentGridpane.addRow(1, firstNameVbox, lastNameVbox);
        newStudentGridpane.addRow(2, emailVbox, phoneNoVbox);
        newStudentGridpane.addRow(5, submitSt, getBackNew());
        
        return newStudentGridpane;
    }

    public GridPane newSession() {
        //newStudentGridPane
        newSessionGridpane.setVgap(5);
        newSessionGridpane.setHgap(5);
        newSessionGridpane.setAlignment(Pos.CENTER);
        newSessionGridpane.addRow(3, subjectVbox);
        newSessionGridpane.addRow(4, tutorVbox);
        newSessionGridpane.addRow(5, submitSs);
        return newSessionGridpane;
    }

    public void ClearFields() {
        getIdNoTF().clear();
        getFirstNameTF().clear();
        getLastNameTF().clear();
        getEmailTF().clear();
        getPhoneNoTF().clear();
        getTutorTF().clear();

    }

    public void updateTable(Session currentData) {

        String fName = currentData.getFirstName();
        String lName = currentData.getLastName();
        String tutor = currentData.getTutor();
        String timeIn = currentData.getStartTime();
        String id = currentData.getIdNo();
        String subject = currentData.getSubject();
        RowData rowData = new studentView.RowData(fName, lName, subject, timeIn, id, tutor);
        tableData.add(rowData);
        table.setItems(tableData);
    }
    
    public void wrongPass() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incorrect ID number");
        alert.setContentText("Enter a valid id number.");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));
        alert.showAndWait();
    }

    public Button getSubmitSt() {
        return submitSt;
    }

    public void setSubmitSt(Button submitSt) {
        this.submitSt = submitSt;
    }

    public Button getSubmitSs() {
        return submitSs;
    }

    public void setSubmitSs(Button submitSs) {
        this.submitSs = submitSs;
    }

    //Define the button cell
    private class ButtonCell extends TableCell<Disposer.Record, Boolean> {

        final Button submit = new Button("Submit");
        HBox cellBox = new HBox();

        ButtonCell() {

            cellBox.getChildren().addAll(submit);

            //Action when the button is pressed
            submit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    RowData currentPerson = (RowData) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());

                    DateFormat format1 = new SimpleDateFormat("HH:mm");
                    DateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
                    Date et = new Date();
                    Date dt = new Date();

                    String idNo = currentPerson.getId();
                    String firstName = currentPerson.getFirstName();
                    String lastName = currentPerson.getLastName();
                    String tutor = currentPerson.getTutor();
                    String startTime = currentPerson.getTimeIn();
                    String subject = currentPerson.getSubject();
                    String endTime = format1.format(et);
                    String date = format2.format(dt);

                    Session currentSession = new Session(idNo, lastName, firstName, tutor, endTime, subject, startTime, date);

                    try {
                        sm.insertSession(currentSession);//remove selected item from the table list
                        tableData.remove(currentPerson);
                    } catch (SQLException ex) {
                        Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellBox);
            } else {
                setGraphic(null);
            }
        }

    }

    public static class RowData {

        private SimpleStringProperty firstName;
        private SimpleStringProperty lastName;
        private SimpleStringProperty subject;
        private SimpleStringProperty timeIn;
        private SimpleStringProperty id;
        private SimpleStringProperty tutor;

        private RowData(String fName, String lName, String subject, String timeIn, String id, String tutor) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.subject = new SimpleStringProperty(subject);
            this.timeIn = new SimpleStringProperty(timeIn);
            this.id = new SimpleStringProperty(id);
            this.tutor = new SimpleStringProperty(tutor);
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
     * @return the addBtn
     */
    public Button getAddBtn() {
        return addBtn;
    }

    /**
     * @param addBtn the addBtn to set
     */
    public void setAddBtn(Button addBtn) {
        this.addBtn = addBtn;
    }

    /**
     * @return the table
     */
    public TableView<Session> getTable() {
        return table;
    }

    /**
     * @return the idNoLabel
     */
    public Label getIdNoLabel() {
        return idNoLabel;
    }

    /**
     * @param idNoLabel the idNoLabel to set
     */
    public void setIdNoLabel(Label idNoLabel) {
        this.idNoLabel = idNoLabel;
    }

    /**
     * @return the idNoTF
     */
    public TextField getIdNoTF() {
        return idNoTF;
    }

    /**
     * @param idNoTF the idNoTF to set
     */
    public void setIdNoTF(TextField idNoTF) {
        this.idNoTF = idNoTF;
    }

    /**
     * @return the firstNameLabel
     */
    public Label getFirstNameLabel() {
        return firstNameLabel;
    }

    /**
     * @param firstNameLabel the firstNameLabel to set
     */
    public void setFirstNameLabel(Label firstNameLabel) {
        this.firstNameLabel = firstNameLabel;
    }

    /**
     * @return the firstNameTF
     */
    public TextField getFirstNameTF() {
        return firstNameTF;
    }

    /**
     * @param firstNameTF the firstNameTF to set
     */
    public void setFirstNameTF(TextField firstNameTF) {
        this.firstNameTF = firstNameTF;
    }

    /**
     * @return the lastNameLabel
     */
    public Label getLastNameLabel() {
        return lastNameLabel;
    }

    /**
     * @param lastNameLabel the lastNameLabel to set
     */
    public void setLastNameLabel(Label lastNameLabel) {
        this.lastNameLabel = lastNameLabel;
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
     * @return the emailTF
     */
    public TextField getEmailTF() {
        return emailTF;
    }

    /**
     * @param emailTF the emailTF to set
     */
    public void setEmailTF(TextField emailTF) {
        this.emailTF = emailTF;
    }

    /**
     * @return the phoneNoLabel
     */
    public Label getPhoneNoLabel() {
        return phoneNoLabel;
    }

    /**
     * @param phoneNoLabel the phoneNoLabel to set
     */
    public void setPhoneNoLabel(Label phoneNoLabel) {
        this.phoneNoLabel = phoneNoLabel;
    }

    /**
     * @return the phoneNoTF
     */
    public TextField getPhoneNoTF() {
        return phoneNoTF;
    }

    /**
     * @param phoneNoTF the phoneNoTF to set
     */
    public void setPhoneNoTF(TextField phoneNoTF) {
        this.phoneNoTF = phoneNoTF;
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
     * @return the tutorLabel
     */
    public Label getTutorLabel() {
        return tutorLabel;
    }

    /**
     * @param tutorLabel the tutorLabel to set
     */
    public void setTutorLabel(Label tutorLabel) {
        this.tutorLabel = tutorLabel;
    }

    /**
     * @return the tutorTF
     */
    public TextField getTutorTF() {
        return tutorTF;
    }

    /**
     * @param tutorTF the tutorTF to set
     */
    public void setTutorTF(TextField tutorTF) {
        this.tutorTF = tutorTF;
    }

    /**
     * @return the gridpane
     */
    public GridPane getGridpane() {
        return gridpane;
    }

    /**
     * @param gridpane the gridpane to set
     */
    public void setGridpane(GridPane gridpane) {
        this.gridpane = gridpane;
    }

    /**
     * @return the supervisor
     */
    public Button getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(Button supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the tutor
     */
    public Button getTutor() {
        return tutor;
    }

    /**
     * @param tutor the tutor to set
     */
    public void setTutor(Button tutor) {
        this.tutor = tutor;
    }

    /**
     * @return the newStudentGridpane
     */
    public GridPane getNewStudentGridpane() {
        return newStudentGridpane;
    }

    /**
     * @param newStudentGridpane the newStudentGridpane to set
     */
    public void setNewStudentGridpane(GridPane newStudentGridpane) {
        this.newStudentGridpane = newStudentGridpane;
    }

    /**
     * @return the studentIdGridpane
     */
    public GridPane getStudentIdGridpane() {
        return studentIdGridpane;
    }

    /**
     * @param studentIdGridpane the studentIdGridpane to set
     */
    public void setStudentIdGridpane(GridPane studentIdGridpane) {
        this.studentIdGridpane = studentIdGridpane;
    }

    /**
     * @return the oldStudentGridpane
     */
    public GridPane getOldStudentGridpane() {
        return newSessionGridpane;
    }

    /**
     * @param oldStudentGridpane the oldStudentGridpane to set
     */
    public void setOldStudentGridpane(GridPane oldStudentGridpane) {
        this.newSessionGridpane = oldStudentGridpane;
    }

    /**
     * @return the submitId
     */
    public Button getSubmitId() {
        return submitId;
    }

    /**
     * @param submitId the submitId to set
     */
    public void setSubmitId(Button submitId) {
        this.submitId = submitId;
    }

    /**
     * @return the newStudentIdNoTF
     */
    public TextField getNewStudentIdNoTF() {
        return newStudentIdNoTF;
    }

    /**
     * @param newStudentIdNoTF the newStudentIdNoTF to set
     */
    public void setNewStudentIdNoTF(TextField newStudentIdNoTF) {
        this.newStudentIdNoTF = newStudentIdNoTF;
    }

    /**
     * @return the backNew
     */
    public Button getBackNew() {
        return backNew;
    }

    /**
     * @param backNew the backNew to set
     */
    public void setBackNew(Button backNew) {
        this.backNew = backNew;
    }

}
