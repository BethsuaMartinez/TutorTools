/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 *
 * @author beths
 */
public class mailController {

    MailView mv = new MailView();
    // SMTP info
    String host = "smtp.gmail.com";
    String port = "465";
    String mailFrom = "tutor.tools.01@gmail.com";
    String password = "TutorToolsadmin";
    File[] attachFiles = null;

    public mailController(MailView mv) {
        this.mv = mv;
        attachHandlers();
    }

    public void attachHandlers() {

        mv.getSend().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // message info
                String mailTo = mv.getToTF().getText();
                String subject = mv.getSubject().getText();
                String message = mv.getMessage().getText();
                String ccemail = mv.getCcTF().getText();

                 mv.sending();
                // CC emails
                ArrayList<String> ccEmails = new ArrayList<>();
                ccEmails.add(ccemail);
                
                try {
                    if("".equals(ccemail)){
                        EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
                            subject, message, attachFiles);
                    mv.emailSent();}
                    //System.out.println("Email sent.");}
                    else{
                        EmailAttachmentSender.sendEmailWithAttachmentsCC(host, port, mailFrom, password, mailTo,
                            subject, message, attachFiles, ccEmails);}
                } catch (MessagingException ex) {
                    System.out.println("Could not send email.");
                }
            }
        });

        mv.getBrowseButton().setOnAction((ActionEvent event) -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select file");
            //fileChooser.setInitialDirectory(new File("C:\\Users\\beths\\Desktop"));
            fileChooser.setInitialDirectory(new File("//home//selvera"));
            List <File> files = fileChooser.showOpenMultipleDialog(stage);
            
            attachFiles = new File[files.size()];
            files.toArray(attachFiles);             
        });
        }  
}