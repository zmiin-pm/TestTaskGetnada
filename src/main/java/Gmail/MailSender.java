package Gmail;

import Files.FileReader;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class MailSender {

    public static void mailSend(String recipient, String mailBody) {

        final List<String> credentials = FileReader.readCredentials();
        final String userName = credentials.get(0);
        final String password = credentials.get(1);

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject("Mail with links");
            message.setText(mailBody);

            Transport.send(message);

            System.out.println("Mail was sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}