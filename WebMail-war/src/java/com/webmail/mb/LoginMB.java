/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.mb;

import com.webmail.ejb.UserSessionBean;
import com.webmail.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Fri4A
 */
// CDI
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    private UserSessionBean userSessionBean;
    private User loginUser;

    public UserSessionBean getUserSessionBean() {
        return userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    
    public LoginMB() {
    }

    public User login() {
        return userSessionBean.login();
    }

}
