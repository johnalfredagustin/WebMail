/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.utiliity;

import com.webmail.model.User;
import com.webmail.storage.StoragePathEnum;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author John Agustin
 */
public class EmailUtility {

    public static final String FILE_PATH = StoragePathEnum.EMAIL_URI.getPath();
    public static File FILE = new File(FILE_PATH);
    public static final String DATE_PATTERN = "MM/dd/yyyy";

    public static boolean addUser(User user) throws IOException {
        boolean added = false;
        ObjectOutputStream out = null;
        try {
            if (!FILE.exists()) {
                out = new ObjectOutputStream(new FileOutputStream(FILE));
            } else {
                out = new AppendableObjectOutputStream(new FileOutputStream(FILE, true));
            }
            out.writeObject(user);
            added = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return added;
    }
    
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
    
    private static class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }

    private static class AppendableObjectInputStream extends ObjectInputStream {

        public AppendableObjectInputStream(InputStream in) throws IOException {
            super(in);
        }

        @Override
        protected void readStreamHeader() throws IOException {

        }
    }

}
