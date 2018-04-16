/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;




/**
 *
 * @author beths
 */
public class loginView extends BorderPane{ 
    private ImageView logo;
    private Label loginLabel = new Label("Login to Your Account");
    private TextField username = new TextField();
    private TextField password = new TextField();
    private Button login = new Button("Login");
    
        public loginView(){

        this.setStyle("-fx-background-color: #FFFFFF;");
        HBox h1 = new HBox();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        HBox h6 = new HBox();
        VBox v1 = new VBox();
        
        this.logo = new ImageView(new Image(getClass().getResourceAsStream("/resources/TutorTools.PNG")));
        this.logo.setFitWidth(590);
        this.logo.setFitHeight(160);
        this.logo.setPreserveRatio(true);
        this.logo.setSmooth(true);
        this.logo.setCache(true);
        this.centerProperty();
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
        h4.getChildren().add(login);
       
        this.login.setStyle("-fx-background-color: #00FFFF;");
        this.username.setPromptText("username");
        this.password.setPromptText("password");
    //    this.login.setS
        
        v1.getChildren().addAll(h1,h2,h3,h4);
        this.setCenter(v1);
        this.setLeft(h5);
        this.setRight(h6);
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
        public void setUsername(TextField username) {
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
        public void setPassword(TextField password) {
            this.password = password;
        }

        /**
         * @return the login
         */
        public Button getLogin() {
            return login;
        }

        /**
         * @param login the login to set
         */
        public void setLogin(Button login) {
            this.login = login;
        }
}
