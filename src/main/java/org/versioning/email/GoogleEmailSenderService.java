package org.versioning.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class GoogleEmailSenderService implements EmailSenderService {

    @Value("${gmail.smtpserver.host}") private String smtpServerHost;
    @Value("${gmail.smtpserver.port}") private String smtpServerPort;
    @Value("${gmail.smtp.starttls.enable}") private String gmailSmtpStartTtls;
    @Value("${gmail.smtp.auth}") private String smtpUseAuth;

    @Value("${gmail.username}") private String fromUser;
    @Value("${gmail.password}") private String password;

    @Override
    public void sendMail(EmailMessage message) {
        Session session = configureEmailSession();
        MimeMessage message1 = new MimeMessage(session);

        try {
            message1.setFrom(new InternetAddress(fromUser));
            InternetAddress[] toAddress = new InternetAddress[message.getRecipients().length];

            // To get the array of addresses
            for (int i = 0; i < message.getRecipients().length; i++) {
                toAddress[i] = new InternetAddress(message.getRecipients()[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message1.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message1.setSubject(message.getSubject());
            message1.setText(message.getBody());
            Transport transport = session.getTransport("smtp");
            transport.connect(smtpServerHost, fromUser, password);
            transport.sendMessage(message1, message1.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    private Session configureEmailSession() {
        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", gmailSmtpStartTtls);
        props.put("mail.smtp.host", smtpServerHost);
        props.put("mail.smtp.user", fromUser);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", smtpServerPort);
        props.put("mail.smtp.auth", smtpUseAuth);

        return Session.getDefaultInstance(props);
    }

}
