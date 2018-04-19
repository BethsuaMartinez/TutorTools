/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperVisorGui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author KennyBoiii
 */
public class TutorEditInfoHbox extends HBox {

    private Label lasName = new Label("Enter Last Name of Tutor");
    private TextField lastNameTF = new TextField();
    private Button search = new Button("Search");

    public TutorEditInfoHbox() {
        search.setPrefSize(100, 10);

        this.setPadding(new Insets(10));
        this.setSpacing(20);

        this.getChildren().add(lasName);
        this.getChildren().add(lastNameTF);
        this.getChildren().add(search);

    }

    // public void attachHandlers()
    //{
    // attach handlers for GUI
    //	search.setOnAction(
    //		new EventHandler<ActionEvent>()
    //		{
    //		@Override
    //		public void handle(ActionEvent event) 
    //		try {
    //                  String lastName = lastNameTF.getText();
    //                  List<Tutor> tutors = null;
    //                  if (lastName != null && lastName.trim().length() > 0){
    //                      tutors = TutorDAO.searchTutor();
    //                  }
    //                   }
//}
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
}
