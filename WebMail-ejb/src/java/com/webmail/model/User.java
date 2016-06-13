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

    public User(String username, String password, boolean isAdmin, Setting setting) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.setting = setting;
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
}
