/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import java.io.IOException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailAttachmentSender {
	public static void sendEmailWithAttachments(String host, String port,
		final String userName, final String password, String toAddress,
		String subject, String message, String[] attachFiles)
		throws AddressException, MessagingException {
		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		// sets SMTP server properties
		Properties properties = System.getProperties();
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		properties.put("mail.smtp.host", host);
		properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		
		properties.put("mail.smtp.port", port);
		properties.setProperty("mail.smtp.socketFactory.port", port);
		
		properties.put("mail.smtps.quitwait", "false");

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		properties.put("mail.user", userName);
		properties.put("mail.password", password);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		
		// for multiple users, toAddress should string of emails separated by commas
		//msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abc@abc.com,abc@def.com,ghi@abc.com"));
		//
		
		// for cc
		String[] ccEmails ={}; // {"...","..."}
		int ccLength=0;
		if (ccEmails != null) {
			ccLength = ccEmails.length;
		}
		for (int i = 0; i < ccLength; i++) {
			msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmails[i], false));
		  }
		// for cc end //
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachFiles != null && attachFiles.length > 0) {
			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();
				try {
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
				}
				multipart.addBodyPart(attachPart);
			}
		}
		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);
	}
	public static void sendEmailWithAttachmentsCC(String host, String port,
		final String userName, final String password, String toAddress,
		String subject, String message, String[] attachFiles,String[] ccEmails)
		throws AddressException, MessagingException {
		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		
		// sets SMTP server properties
		Properties properties = System.getProperties();
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		properties.put("mail.smtp.host", host);
		properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		
		properties.put("mail.smtp.port", port);
		properties.setProperty("mail.smtp.socketFactory.port", port);
		
		properties.put("mail.smtps.quitwait", "false");

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		properties.put("mail.user", userName);
		properties.put("mail.password", password);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		
		// for multiple users, toAddress should string of emails separated by commas
		//msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abc@abc.com,abc@def.com,ghi@abc.com"));
		//
		
		// for cc
		int ccLength=0;
		if (ccEmails != null) {
			ccLength = ccEmails.length;
		}
		for (int i = 0; i < ccLength; i++) {
			msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmails[i], false));
		  }
		// for cc end //
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachFiles != null && attachFiles.length > 0) {
			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();
				try {
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
				}
				multipart.addBodyPart(attachPart);
			}
		}
		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);
	}	
}
