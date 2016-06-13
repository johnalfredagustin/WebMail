/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.mb;

import com.webmail.model.User;
import com.webmail.utiliity.UserUtility;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Fri4A
 */
@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {

    User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserMB() {
    }

    public String addAction() throws IOException {

        boolean isAdded = UserUtility.addUser(user);
        return null;
    }
}
