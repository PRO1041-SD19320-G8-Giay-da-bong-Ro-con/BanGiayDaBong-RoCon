/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

/**
 *
 * @author Thai
 */
import java.awt.Component;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public boolean sendEmail(Component parentComponent, String recipient, String text) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Properties props = new Properties();
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.enable", "true");

                        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("g8rocon@gmail.com", "qtop dtdi zsak wymw");
                            }
                        });

                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("g8rocon@gmail.com"));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                        message.setSubject("Mã xác minh Rô con");
                        message.setText("Mã xác minh: " + text);

                        Transport.send(message);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
