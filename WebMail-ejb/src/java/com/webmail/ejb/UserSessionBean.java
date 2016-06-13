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

    public User login(){
        try {
            return UserUtility.login(" ", " ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
