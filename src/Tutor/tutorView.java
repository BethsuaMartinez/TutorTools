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
                    new RowData("Jacob", "Smith", "jacob.smith@example.com", "12:00", "14:20"),
                    new RowData("Isabella", "Johnson", "isabella.johnson@example.com", "16:30", "17:00"),
                    new RowData("Ethan", "Williams", "ethan.williams@example.com", "9:40", "11:20"),
                    new RowData("Emma", "Jones", "emma.jones@example.com", "10:00", "13:10"),
                    new RowData("Michael", "Brown", "michael.brown@example.com", "8:30", "8:45"));

    private final TableView table = new TableView();

    private Button signOut = new Button("Log Out");
    private Button searchBtn = new Button("Search");
    private Button calender = new Button("Calender");
    private TextField searchTf = new TextField();
    private Button back = new Button("Back");

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
        
        this.searchBtn.setPadding(new Insets(3,3,3,3));
        this.calender.setPadding(new Insets(3,3,3,3));
        this.back.setPadding(new Insets(5,10,5,10));
        this.signOut.setPadding(new Insets(5,10,5,10));
        
        this.searchBtn.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        this.calender.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9 ;");
        this.back.setStyle("-fx-font: 11 arial; -fx-border-color:#b6e7c9 ;");
        this.signOut.setStyle("-fx-font: 11 arial; -fx-border-color:#b6e7c9 ;");

        table.setItems(data);
       

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
        
        TableColumn actionCol = new TableColumn("Action");

        //Adding the Button to the cell
        actionCol.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }

        });
        
        table.setStyle("-fx-font: 13 arial; -fx-border-color:#b6e7c9;");
        table.getColumns().addAll(firstNameCol, lastNameCol, subjectcol, timeInCol, timeOutCol, actionCol);
        table.setPrefWidth(654.5);
       
        
        this.searchTf.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");

        HBox search = new HBox();
        search.getChildren().addAll(searchTf, searchBtn, calender);
        search.setSpacing(10);
        search.setStyle(" -fx-padding: 10");
       
        VBox left = new VBox();
        left.getChildren().addAll(search,table);
       
        BorderPane.setMargin(left, new Insets(0,10,0,10));

        this.setLeft(left);
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

    //Define the button cell
    private class ButtonCell extends TableCell<Record, Boolean> {

        private Button modButton = new Button("Modify");
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
            modButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    RowData currentPerson = (RowData) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    //remove selected item from the table list
                    System.out.println(currentPerson.firstName.get());
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
