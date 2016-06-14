/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.ejb;

import com.webmail.model.User;
import com.webmail.utiliity.UserUtility;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author Fri4A
 */
@Stateful
@LocalBean
public class UserSessionBean {

    private User activeUser;
    private User registeredUser;

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User user) {
        this.activeUser = user;
    }
    
    
    
    public User login(){
        try {
            activeUser = UserUtility.login(" ", " ");
            return activeUser;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
