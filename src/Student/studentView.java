/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

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

/**
 *
 * @author elyvic
 */
public class studentView extends BorderPane {

    private GridPane gridpane = new GridPane();

    private Button fillerBtn = new Button("Filler Button");
    private Button addBtn = new Button("Add Session");
    private Button refreshBtn = new Button("Refresh Sessions");
    private Button submitBtn = new Button("Submit");

    private TableView<Data> table = new TableView<>();

    //table columns
    TableColumn<Data, String> idNoColumn = new TableColumn<>("ID Number");
    TableColumn<Data, String> firstNameColumn = new TableColumn<>("First Name");
    TableColumn<Data, String> lastNameColumn = new TableColumn<>("Last Name");
    TableColumn<Data, String> emailColumn = new TableColumn<>("E-Mail");
    TableColumn<Data, String> phoneNoColumn = new TableColumn<>("Phone Number");
    TableColumn<Data, String> tutorColumn = new TableColumn<>("Tutor");
    TableColumn<Data, String> timeColumn = new TableColumn<>("Time");
    TableColumn<Data, String> dateColumn = new TableColumn<>("Date");

    private Label idNoLabel = new Label("ID Number");
    private TextField idNoTF = new TextField();

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

    private VBox idNoVbox = new VBox(idNoLabel, idNoTF);
    private VBox firstNameVbox = new VBox(firstNameLabel, firstNameTF);
    private VBox lastNameVbox = new VBox(lastNameLabel, lastNameTF);
    private VBox emailVbox = new VBox(emailLabel, emailTF);
    private VBox phoneNoVbox = new VBox(phoneNoLabel, phoneNoTF);
    private VBox subjectVbox = new VBox(subjectLabel, subjectTF);
    private VBox tutorVbox = new VBox(tutorLabel, tutorTF);

    private HBox buttonHbox = new HBox(refreshBtn, addBtn);
    private VBox centerVbox = new VBox(table, buttonHbox);

    public studentView() {

        //idNo column
        idNoColumn.setMinWidth(100);
        idNoColumn.setCellValueFactory(new PropertyValueFactory<>("IdNo"));

        //first name column
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        //last name column
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        emailColumn.setMinWidth(100);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        phoneNoColumn.setMinWidth(100);
        phoneNoColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));

        tutorColumn.setMinWidth(100);
        tutorColumn.setCellValueFactory(new PropertyValueFactory<>("tutor"));

        timeColumn.setMinWidth(100);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        table.getColumns().addAll(idNoColumn, firstNameColumn, lastNameColumn, emailColumn, phoneNoColumn, tutorColumn, timeColumn);

        //Hbox
        buttonHbox.setSpacing(3);

        //Vbox
        centerVbox.setSpacing(3);

        idNoVbox.setSpacing(3);
        firstNameVbox.setSpacing(3);
        lastNameVbox.setSpacing(3);
        emailVbox.setSpacing(3);
        phoneNoVbox.setSpacing(3);

        //GridPane
        gridpane.setVgap(5);
        gridpane.setHgap(5);
        gridpane.setAlignment(Pos.CENTER);

        gridpane.addRow(0, idNoVbox);
        gridpane.addRow(1, firstNameVbox, lastNameVbox);
        gridpane.addRow(2, emailVbox, phoneNoVbox);
        gridpane.addRow(3, subjectVbox);
        gridpane.addRow(4, tutorVbox);
        gridpane.addRow(5, submitBtn);

        BorderPane.setMargin(table, new Insets(10, 10, 10, 10));
        BorderPane.setMargin(fillerBtn, new Insets(10, 10, 10, 10));

        this.setLeft(fillerBtn);
        this.setCenter(centerVbox);

    }

    public void ClearFields() {
        getIdNoTF().clear();
        getFirstNameTF().clear();
        getLastNameTF().clear();
        getEmailTF().clear();
        getPhoneNoTF().clear();
        getTutorTF().clear();

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
    public TableView<Data> getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(TableView<Data> table) {
        this.table = table;
    }

    /**
     * @return the refreshBtn
     */
    public Button getRefreshBtn() {
        return refreshBtn;
    }

    /**
     * @param refreshBtn the refreshBtn to set
     */
    public void setRefreshBtn(Button refreshBtn) {
        this.refreshBtn = refreshBtn;
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
     * @return the submitBtn
     */
    public Button getSubmitBtn() {
        return submitBtn;
    }

    /**
     * @param submitBtn the submitBtn to set
     */
    public void setSubmitBtn(Button submitBtn) {
        this.submitBtn = submitBtn;
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

}
