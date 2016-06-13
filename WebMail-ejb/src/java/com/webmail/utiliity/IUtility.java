/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.utiliity;

import com.webmail.model.User;
import java.io.IOException;

/**
 *
 * @author John Agustin
 */
public interface IUtility {
    
    public boolean addUser(User user) throws IOException;
    public boolean modifyUser(User user) throws IOException;
    public boolean deleteUser(User user) throws IOException;
    public User login(String username, String password) throws IOException;
    
}
