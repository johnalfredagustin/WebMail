/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.storage;

import java.nio.file.Paths;

/**
 *
 * @author John Agustin
 */
public enum StoragePathEnum {
    
    USER_URI("User.ser"),
    WORD_FILTER_URI("WordFilter.ser"),
    EMAIL_URI("Email.ser");

    private String path;

    StoragePathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

}
