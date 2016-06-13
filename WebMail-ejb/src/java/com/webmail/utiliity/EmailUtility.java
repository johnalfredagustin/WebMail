/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.utiliity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import org.hibernate.validator.internal.util.logging.Messages;

/**
 *
 * @author John Agustin
 */
public class EmailUtility {

    public static List<Message> getInbox(String username, String password) {

        String host = "pop.gmail.com";
        String mailStoreType = "pop3";
        String username1 = "waa.webmail.service.acc@gmail.com";
        String password1 = "password1234!";

        return check(host, mailStoreType, username1, password1);

    }

    public static List<Message> check(String host, String storeType, String user, String password) {
        List<Message> messagesList = new ArrayList<>();
        try {
            Properties properties = new Properties();
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            
            messagesList = Arrays.asList(messages);

            //close the store and folder objects
//            emailFolder.close(false);
//            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messagesList;
    }

}
