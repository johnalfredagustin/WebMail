/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.mb;

import com.webmail.ejb.UserSessionBean;
import com.webmail.model.User;
import com.webmail.utiliity.UserUtility;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Fri4A
 */
@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {

    @EJB
    UserSessionBean userBean;

    public UserSessionBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserSessionBean user) {
        this.userBean = user;
    }

    public UserMB() {
    }

    public String addAction() throws IOException {

        boolean isAdded = UserUtility.addUser(userBean.getRegisteredUser());
        return null;
    }
}
