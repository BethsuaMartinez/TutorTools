/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supervisor;

import Student.Session;
import Student.studentController;
import Student.studentView;
import com.sun.prism.impl.Disposer;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author selvera
 */
public class TutorInformationView extends BorderPane {

    TutorModel tm = new TutorModel();
    
    private Label lasName = new Label("Enter Last Name of Tutor");
    
    private TextField lastNameTF = new TextField();
    
    private Button search = new Button("Search");
    private Button back = new Button("Back");
    private Button activity= new Button("Activity Log");
    private Button signOut = new Button("Log Out");
    
    TableView table = new TableView();
    
    private Label idLabel = new Label ("ID Number");
    private TextField idTF = new TextField();
    
    private Label fNameLabel = new Label ("First Name");
    private TextField fNameTF = new TextField();
    
    private Label lNameLabel = new Label ("Last Name");
    private TextField lNameTF = new TextField();
    
    private Label emailLabel = new Label("E-Mail");
    private TextField emailTF = new TextField();
    
    private Label phoneLabel = new Label ("Phone Number");
    private TextField phoneTF = new TextField();
    
    private Label subjectLabel = new Label ("Subject");
    private TextField subjectTF = new TextField();
    
 ObservableList<TutorInformationView.RowData> tableData = FXCollections.observableArrayList(new TutorInformationView.RowData("123456", "Kenneth", "Segarra", "kenneth.segarra01@utrgv.edu", "math", "(123)456-789"));
    
    public  TutorInformationView() {
        
     table.setItems(tableData);
        
        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn fNameCol = new TableColumn("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
        
        TableColumn lNameCol = new TableColumn("Last Name");
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
        
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        TableColumn phoneCol = new TableColumn("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
        TableColumn subjectCol = new TableColumn("Subject");
        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        
        TableColumn actionCol = new TableColumn("Action");
        
        actionCol.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new TutorInformationView.ButtonCell();
            }

        });
        
        table.getColumns().addAll(idCol, fNameCol, lNameCol, emailCol, subjectCol, phoneCol);
        table.setPrefWidth(1500);
        
        search.setPrefSize(100, 10);
        HBox hbox1= new HBox(lasName, lastNameTF, search, getActivity(), back);
        
        
        hbox1.setPadding(new Insets(10));
        hbox1.setSpacing(20);

        this.setTop(hbox1);
        this.setCenter(table);
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
    
     public static class RowData {
         
     
        private SimpleStringProperty fName;
        private SimpleStringProperty lName;
        private SimpleStringProperty subject;
        private SimpleStringProperty phone;
        private SimpleStringProperty email;
        private SimpleStringProperty id;

        private RowData(String id, String fName, String lName, String email, String subject, String phone) {
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
     
      public void ClearFields() {
        getIdTF().clear();
        getfNameTF().clear();
        getlNameTF().clear();
        getPhoneTF().clear();
        getEmailTF().clear();
        getSubjectTF().clear();

    }
      
     /* public void updateTable(Data currentData) {

        String fName = currentData.getFirstName();
        String lName = currentData.getLastName();
        String subject = currentData.getTutor();
        String email = currentData.getStartTime();
        String id = currentData.getIdNo();
        String phone = currentData.getSubject();
        TutorInformationView.RowData rowData = new TutorInformationView.RowData(fName, lName, subject, phone, id, email);
        tableData.add(rowData);
        table.setItems(tableData);
    }*/
     
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
                   /*TutorInformationView.RowData currentPerson = (TutorInformationView.RowData) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    Date date = new Date();

                    String idNo = currentPerson.getId();
                    String firstName = currentPerson.getFirstName();
                    String lastName = currentPerson.getLastName();
                    String email = currentPerson.getEmail();
                    String subject = currentPerson.getSubject();
                    String time = dateFormat.format(date);

             //       Data currentSession = new Data(idNo, lastName, firstName, email, time, subject, startTime);

                /*    try {
                        tm.WriteDatabase(currentSession);//remove selected item from the table list
                        tableData.remove(currentPerson);
                    } catch (SQLException ex) {
                        Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
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

    /**
     * @return the lasName
     */
    public Label getLasName() {
        return lasName;
    }

    /**
     * @param lasName the lasName to set
     */
    public void setLasName(Label lasName) {
        this.lasName = lasName;
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

    
}
