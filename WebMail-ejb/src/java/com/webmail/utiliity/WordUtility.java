/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.utiliity;

import com.webmail.model.User;
import com.webmail.model.WordFilter;
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
 * @author VictorPineda
 */
public class WordUtility {
    public static final String FILE_PATH = StoragePathEnum.WORD_FILTER_URI.getPath();
    public static File FILE = new File(FILE_PATH);



    public static boolean addWord(WordFilter word) throws IOException {
        boolean added = false;
        ObjectOutputStream out = null;
        try {
            String id =  String.valueOf(word.getId());
            synchronized (id)
            {
            if (!FILE.exists()) {
                out = new ObjectOutputStream(new FileOutputStream(FILE));
            } else {
                out = new AppendableObjectOutputStream(new FileOutputStream(FILE, true));
            }
            out.writeObject(word);
            added = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return added;
    }

 
    public static boolean modifyWord(WordFilter word) throws IOException {
        boolean isUpdated = false;
        try {
            String id =  String.valueOf(word.getId());
            synchronized (id)
            {
            // get all users
            List<WordFilter> wordList = getAllWords();
            int index = 0;
            // update user details
            for (WordFilter u : wordList) {
                if (u.getId() ==  word.getId()) {
                    wordList.remove(index);
                    wordList.add(index, word);
                    break;
                }
                index++;
            }
            // insert users into ser file by creating new
            createWordSerializedFile(wordList);
            isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public static boolean deleteWord(WordFilter word) {
        boolean isDeleted = false;
        try {
            String id =  String.valueOf(word.getId());
            synchronized (id)
            {
            // get all users
            List<WordFilter> wordList = getAllWords();
            int index = 0;
            // update user details
            for (WordFilter u : wordList) {
                if (u.getId() ==  word.getId()) {
                    wordList.remove(index);
                    break;
                }
                index++;
            }
            // insert users into ser file by creating new
            createWordSerializedFile(wordList);
            isDeleted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }


    public static  List<WordFilter> getAllWords() throws IOException {
        ObjectInputStream ois = null;
        List<WordFilter> wordList = new ArrayList<>();
        WordFilter word = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILE));
            while (true) {
                wordList.add((WordFilter) ois.readObject());
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
        return wordList;
    }

    public static boolean createWordSerializedFile(List<WordFilter> wordList) {
        boolean isCreated = false;
        ObjectOutputStream out = null;
        FILE.delete();
        for (WordFilter u : wordList) {
            try {
                if (!FILE.exists()) {
                    out = new ObjectOutputStream(new FileOutputStream(FILE));
                } else {
                    out = new AppendableObjectOutputStream(new FileOutputStream(FILE, true));
                }
                out.writeObject(u);
                out.close();
                isCreated = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isCreated;
    }

     static class AppendableObjectOutputStream extends ObjectOutputStream {

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
