/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.utils;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 21650
 */
public class Mail {
     public final String username = "promoesprit@gmail.com";
    public final String password = "13001074aa";

    public void envoyer(String rech, String objetmail, String contenumailFrom) {
// Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.protocol.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator(){
            @Override  
            public PasswordAuthentication getPasswordAuthenticationion() 
            {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
// Etape 2 : Création de l'objet Message

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("promoesprit@gmail.com"));
            System.out.println("1");
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(rech));
            System.out.println("2");
            message.setSubject(objetmail);

            message.setText(contenumailFrom + "\n");
// Etape 3 : Envoyer le message
            System.out.println("3");
            //Transport transport =session.getTransport();
            Transport.send(message);
            System.out.println("4");
            System.out.println("Message_envoye");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
            //System.err.println(e);
            //System.out.println("salut");

        }

    }
}
