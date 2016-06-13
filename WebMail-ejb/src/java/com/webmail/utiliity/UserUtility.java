/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.utiliity;

import com.webmail.model.User;
import com.webmail.storage.StoragePathEnum;
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

/**
 *
 * @author John Agustin
 */
public class UserUtility {

    public static final String FILE_PATH = StoragePathEnum.USER_URI.getPath();
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

    public static boolean modifyUser(User user) throws IOException {
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
            createUserSerializedFile(userList);
            isUpdated = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public static boolean deleteUser(User user) {
        boolean isDeleted = false;
        try {
            // get all users
            List<User> userList = getAllUser();
            int index = 0;
            // update user details
            for (User u : userList) {
                if (u.getUsername().equals(user.getUsername())) {
                    userList.remove(index);
                    break;
                }
                index++;
            }
            // insert users into ser file by creating new
            createUserSerializedFile(userList);
            isDeleted = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

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

    public static List<User> getAllUser() throws IOException {
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

    public static boolean createUserSerializedFile(List<User> userList) {
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
