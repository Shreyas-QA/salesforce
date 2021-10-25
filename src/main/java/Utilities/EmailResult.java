package Utilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailResult {
	final static String username = System.getenv("USER_EMAIL");
	final static String password = System.getenv("Password");
	
	public static void sendEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			// message.setFrom(new InternetAddress("from.mail.id91@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("shreyas.sambare@qtech365.in"));
			// message.setRecipients(Message.RecipientType.TO,
			// InternetAddress.parse("qaqtech365@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("PFA");

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();
			String file = "C:\\Users\\shreyas.sambare\\eclipse-workspace\\com.dddframework.project\\test-output\\emailable-report.html";
			String fileName = "TestAttachment";

			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);

			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart, "text/html");

			System.out.println("Sending");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
