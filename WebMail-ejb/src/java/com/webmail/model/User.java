/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.model;

import java.io.Serializable;

/**
 *
 * @author John Agustin
 */
public class User implements Serializable {

    private String name;
    private String username;
    private String password;
    private String emailAddress;
    private boolean isAdmin;
    private Setting setting;

    public User(String name, String username, String password, String emailAddress, boolean isAdmin, Setting setting) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.isAdmin = isAdmin;
        this.setting = setting;
    }
  
        public User() {
       
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
}
