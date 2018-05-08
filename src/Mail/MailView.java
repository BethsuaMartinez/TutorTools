/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author beths
 */
public class MailView extends VBox {

    private Button send = new Button("Send");
    private Button browseButton = new Button("Attach");
    private Label cc = new Label("Cc:");
    private Label to = new Label("To:");
    private TextField toTF = new TextField();
    private TextField ccTF = new TextField();
    private TextField subject = new TextField();
    private TextArea message = new TextArea();

    public MailView() {
        HBox top = new HBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        HBox hb4 = new HBox();


        this.subject.setPromptText("Add a subject");
        this.message.setPromptText("Add a message here");
        this.ccTF.setPromptText("Ex. abc@abc.com,abc@def.com,ghi@abc.com");

        this.to.setPadding(new Insets(0, 10, 0, 0));
        this.cc.setPadding(new Insets(0, 10, 0, 0));
        HBox.setHgrow(toTF, Priority.ALWAYS);
        HBox.setHgrow(ccTF, Priority.ALWAYS);
        HBox.setHgrow(subject, Priority.ALWAYS);

        hb1.getChildren().addAll(to, toTF);
        this.toTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        this.ccTF.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        this.subject.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");
        this.message.setStyle("-fx-border-width: 0; -fx-background-color: -fx-control-inner-background;\n"
                + "    -fx-background-insets: 1;");

        this.send.setPrefSize(80, 20);
        this.browseButton.setPrefSize(80, 20);
        this.send.setStyle("-fx-background-color:#b6e7c9;");
        this.browseButton.setStyle("-fx-background-color: white;");

        hb2.getChildren().addAll(cc, ccTF);
        hb3.getChildren().add(subject);
        hb4.getChildren().addAll(send, browseButton);
        hb4.setSpacing(5);

        this.setPadding(new Insets(20, 20, 20, 20));
        this.setSpacing(5);
        this.getChildren().addAll(top, hb1, hb2, hb3, message, hb4);

    }
    
    public void sending(){
        this.getChildren().clear();
        Label sent = new Label("Sending...");
        sent.setFont(new Font("Arial", 50));
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(sent); 
    }
    
    public void emailSent(){
        this.getChildren().clear();
        Label sent = new Label("Email sent!");
        sent.setFont(new Font("Arial", 50));
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(sent); 
    }
    

    /**
     * @return the send
     */
    public Button getSend() {
        return send;
    }

    /**
     * @param send the send to set
     */
    public void setSend(Button send) {
        this.send = send;
    }

    /**
     * @return the browseButton
     */
    public Button getBrowseButton() {
        return browseButton;
    }

    /**
     * @param browseButton the browseButton to set
     */
    public void setBrowseButton(Button browseButton) {
        this.browseButton = browseButton;
    }

    /**
     * @return the cc
     */
    public Label getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(Label cc) {
        this.cc = cc;
    }

    /**
     * @return the to
     */
    public Label getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Label to) {
        this.to = to;
    }

    /**
     * @return the toTF
     */
    public TextField getToTF() {
        return toTF;
    }

    /**
     * @param toTF the toTF to set
     */
    public void setToTF(TextField toTF) {
        this.toTF = toTF;
    }

    /**
     * @return the ccTF
     */
    public TextField getCcTF() {
        return ccTF;
    }

    /**
     * @param ccTF the ccTF to set
     */
    public void setCcTF(TextField ccTF) {
        this.ccTF = ccTF;
    }

    /**
     * @return the subject
     */
    public TextField getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(TextField subject) {
        this.subject = subject;
    }

    /**
     * @return the message
     */
    public TextArea getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(TextArea message) {
        this.message = message;
    }

}
