package com.example.register.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendRegistrationEmail(String to, String subject, String message, String mail) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com"); // Gmail SMTP server
        email.setSmtpPort(587); // Gmail SMTP port
        email.setAuthenticator(new DefaultAuthenticator("usermail", "app-password"));
        email.setSSLOnConnect(true); // Use SSL for a secure connection
        email.setFrom(mail);
        email.setSubject(subject);
        email.setMsg(message);
        email.addTo(to);
        email.send();
    }
}
