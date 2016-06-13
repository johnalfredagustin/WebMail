/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.utiliity;

import com.webmail.model.User;
import com.webmail.model.WordFilterEnum;
import java.io.IOException;

/**
 *
 * @author Jennyfer
 */
public class SettingUtility {
    
    public static void changePassword(User user, String password) throws IOException
    {
        user.setPassword(password);
        UserUtility.modifyUser(user);
    }
    
    public static void addEmailSignature(User user, String emailSignature) throws IOException
    {
        user.getSetting().setEmailSignature(emailSignature);
        UserUtility.modifyUser(user);
    }
    
    public static void setPreferredFilter(User user, WordFilterEnum wordFilter) throws IOException
    {
        user.getSetting().setPreferedWordFiltering(wordFilter);
        UserUtility.modifyUser(user);
    }
    
}
