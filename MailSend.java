package date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSend {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public static void generateAndSendEmail1(String emailSubject, String emailBody, InternetAddress to) throws MessagingException {

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, to);
        // generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(to));
        generateMailMessage.setSubject(emailSubject);
        generateMailMessage.setContent(emailBody, "text/html");

        Transport transport = getMailSession.getTransport("smtp");

        String userLogin = "ENTER YOUR EMAIL ADDRESS";
        String userPassword = "ENTER YOUR EMAIL ACCOUNT PASSWORD";
        transport.connect("smtp.gmail.com", userLogin, userPassword);
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    public static void generateAndSendEmailMulti(String emailSubject, String emailBody, InternetAddress[] to) throws MessagingException {

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipients(Message.RecipientType.CC, to);
        // generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        generateMailMessage.setSubject(emailSubject);
        generateMailMessage.setContent(emailBody, "text/html");

        Transport transport = getMailSession.getTransport("smtp");

        String userLogin = "ENTER YOUR EMAIL ADDRESS";
        String userPassword = "ENTER YOUR EMAIL ACCOUNT PASSWORD";
        transport.connect("smtp.gmail.com", userLogin, userPassword);
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}
