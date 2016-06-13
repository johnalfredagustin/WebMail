/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.utiliity;

import com.webmail.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import static org.jboss.weld.bootstrap.api.SingletonProvider.reset;

/**
 *
 * @author John Agustin
 */
public class Utility implements IUtility {

    public static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\com\\webmail\\storage\\User.ser";
    public static File FILE = new File(FILE_PATH);
    public static final String DATE_PATTERN = "MM/dd/yyyy";

    @Override
    public boolean addUser(User user) throws IOException {
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

    @Override
    public boolean modifyUser(User user) throws IOException  {
        boolean isUpdated = false;
        try {
            // get all users
            List<User> userList = getAllUser();
            int index = 0;
            // update user details
            for (User u : userList) {
                if (u.getUsername().equals(user.getUsername())) {
                    userList.remove(index);
                    userList.add(index, user);
                    break;
                }
                index++;
            }
            // insert users into ser file by creating new
            createUserSerFile(userList);
            isUpdated = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean deleteUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(String username, String password) throws IOException {
        ObjectInputStream ois = null;
        User user = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILE));
            while (true) {
                user = (User) ois.readObject();
                String tempUsername = user.getUsername();
                String tempPassword = user.getPassword();
                if (tempUsername.equals(username) && tempPassword.equals(password)) {
                    ois.close();
                    return user;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            // EOFException means end of the stream
            if (!(e instanceof java.io.EOFException)) {
                e.printStackTrace();
            }
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return user;
    }

    public List<User> getAllUser() throws IOException {
        ObjectInputStream ois = null;
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILE));
            while (true) {
                userList.add((User) ois.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            // EOFException means end of the stream
            if (!(e instanceof java.io.EOFException)) {
                e.printStackTrace();
            }
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return userList;
    }
   
    public boolean createUserSerFile(List<User> userList) {
        boolean isCreated = false;
        ObjectOutputStream out = null;
        FILE.delete();
        for (User user : userList) {
            try {
                if (!FILE.exists()) {
                    out = new ObjectOutputStream(new FileOutputStream(FILE));
                } else {
                    out = new AppendableObjectOutputStream(new FileOutputStream(FILE, true));
                }
                out.writeObject(user);
                out.close();
                isCreated = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isCreated;
    }
    
    
    
    private class AppendableObjectOutputStream extends ObjectOutputStream {

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

