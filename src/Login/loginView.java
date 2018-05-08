/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.sun.prism.paint.Color;
import javafx.geometry.Insets;
import org.controlsfx.control.textfield.CustomPasswordField;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomTextField;

/**
 *
 * @author beths
 */
public class loginView extends BorderPane {

    private ImageView logo;
    private Label loginLabel = new Label("Login to Your Account");

    private CustomTextField username = new CustomTextField();
    private CustomPasswordField password = new CustomPasswordField();
    private Button loginButton = new Button("LOGIN");


    public loginView() {

    
        HBox h1 = new HBox();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        HBox h6 = new HBox();
        VBox v1 = new VBox();
       
        h1.setPadding(new Insets(5,5,5,5));
        h2.setPadding(new Insets(5,5,5,5));
        h3.setPadding(new Insets(5,5,5,5));
        h4.setPadding(new Insets(5,5,5,5));
        
        ImageView user = new ImageView(new Image(getClass().getResourceAsStream("/resources/user.png")));
        user.setFitHeight(15);
        user.setFitWidth(15);
        
        ImageView lock = new ImageView(new Image(getClass().getResourceAsStream("/resources/lock.png")));
        lock.setFitHeight(14);
        lock.setFitWidth(13);
        
       
        BackgroundImage background = new BackgroundImage(new Image("/resources/background.jpg", 3000, 3000, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        
       this.setBackground(new Background(background));
        
        this.logo = new ImageView(new Image(getClass().getResourceAsStream("/resources/TutorTools.PNG")));
        this.logo.setFitWidth(700);
        this.logo.setFitHeight(200);
        this.logo.setPreserveRatio(true);
        this.loginLabel.setFont(Font.font("Lucida Bright 50px", 40));
        this.setTop(logo);
        BorderPane.setAlignment(this.logo, Pos.CENTER);

        h1.setAlignment(Pos.CENTER);
        h2.setAlignment(Pos.CENTER);
        h3.setAlignment(Pos.CENTER);
        h4.setAlignment(Pos.CENTER);

        h1.getChildren().add(loginLabel);
        h2.getChildren().add(username);
        h3.getChildren().add(password);
        h4.getChildren().add(loginButton);

        this.loginButton.setStyle("-fx-background-color: #d9d9d9;");
        this.loginButton.setPrefSize(250, 30);
        this.username.setLeft(user);
        this.username.setPrefSize(250, 30);
        this.username.setPromptText("Email");
        this.password.setLeft(lock);
        this.password.setPrefSize(250, 30);
        this.password.setPromptText("Password");
                
        v1.getChildren().addAll(h1, h2, h3, h4);    
        this.setCenter(v1);
        this.setLeft(h5);
        this.setRight(h6);
        

    }

    public void wrongId() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incorrect Password or Username");
        alert.setContentText("Try a valid username and password!");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/Logo.png").toString()));
        alert.showAndWait();
    }

    /**
     * @return the logo
     */
    public ImageView getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(ImageView logo) {
        this.logo = logo;
    }

    /**
     * @return the loginLabel
     */
    public Label getLoginLabel() {
        return loginLabel;
    }

    /**
     * @param loginLabel the loginLabel to set
     */
    public void setLoginLabel(Label loginLabel) {
        this.loginLabel = loginLabel;
    }

    /**
     * @return the username
     */
    public TextField getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(CustomTextField username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public TextField getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(CustomPasswordField password) {
        this.password = password;
    }

    /**
     * @return the loginButton
     */
    public Button getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    

}
