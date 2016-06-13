/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.storage;

/**
 *
 * @author John Agustin
 */
public enum StoragePathEnum {
    
    USER_URI(System.getProperty("user.dir") + "\\src\\com\\webmail\\storage\\User.ser"),
    WORD_FILTER_URI(System.getProperty("user.dir") + "\\src\\com\\webmail\\storage\\WordFilter.ser"),
    EMAIL_URI(System.getProperty("user.dir") + "\\src\\com\\webmail\\storage\\Email.ser");

    private String path;

    StoragePathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

}
