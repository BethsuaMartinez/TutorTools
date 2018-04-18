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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 *
 * @author beths
 */
public class tutorView extends BorderPane {

    ObservableList<RowData> data
            = FXCollections.observableArrayList(
                    new RowData("Jacob", "Smith", "jacob.smith@example.com", "12:00", "2:20"),
                    new RowData("Isabella", "Johnson", "isabella.johnson@example.com", "", ""),
                    new RowData("Ethan", "Williams", "ethan.williams@example.com", "", ""),
                    new RowData("Emma", "Jones", "emma.jones@example.com", "", ""),
                    new RowData("Michael", "Brown", "michael.brown@example.com", "", ""));

    private final TableView table = new TableView();

    private Button signOut = new Button("Log Out");
    private Button searchBtn = new Button("Search");
    private Button calender = new Button("Calender");
    private TextField searchTf = new TextField();

    public tutorView() {

        this.setStyle(" -fx-background-color: white;");
        table.setItems(data);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));

        TableColumn subjectcol = new TableColumn("Subject");
        subjectcol.setCellValueFactory(
                new PropertyValueFactory<>("subject"));
        TableColumn timeInCol = new TableColumn("TimeIn");
        timeInCol.setCellValueFactory(
                new PropertyValueFactory<>("timeIn"));
        TableColumn timeOutCol = new TableColumn("Time Out");
        timeOutCol.setCellValueFactory(
                new PropertyValueFactory<>("timeOut"));
        TableColumn actionCol = new TableColumn("Action");

        //Adding the Button to the cell
        actionCol.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }

        });
        table.getColumns().addAll(firstNameCol, lastNameCol, subjectcol, timeInCol, timeOutCol, actionCol);
        table.setPrefWidth(600);

        BorderPane sidebar = new BorderPane();
        HBox menu = new HBox();
        //   menu.setStyle(" -fx-background-color: white;");
        Label userName = new Label("User: Bethsua");
        userName.setStyle("-fx-text-fill: black; -fx-font-size: 10pt; -fx-padding: 5");
        menu.setAlignment(Pos.CENTER_RIGHT);

        menu.getChildren().addAll(userName, signOut);
        sidebar.setTop(menu);

        HBox search = new HBox();
        sidebar.setBottom(search);
        search.getChildren().addAll(searchTf, searchBtn, calender);
        search.setStyle(" -fx-padding: 10");

        this.setRight(sidebar);

        this.setLeft(table);
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

    //Define the button cell
    private class ButtonCell extends TableCell<Record, Boolean> {

        final Button modButton = new Button("Modify");
        final Button cellButton = new Button("Delete");
        HBox cellBox = new HBox();

        ButtonCell() {

            cellBox.getChildren().addAll(modButton, cellButton);

            //Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    RowData currentPerson = (RowData) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    //remove selected item from the table list
                    data.remove(currentPerson);
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
        private SimpleStringProperty timeOut;

        private RowData(String fName, String lName, String subject, String timeIn, String timeOut) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.subject = new SimpleStringProperty(subject);
            this.timeIn = new SimpleStringProperty(timeIn);
            this.timeOut = new SimpleStringProperty(timeOut);

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

    }
}
