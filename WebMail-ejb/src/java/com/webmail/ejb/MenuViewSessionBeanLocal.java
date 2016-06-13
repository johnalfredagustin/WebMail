/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.ejb;

import javax.ejb.Local;

/**
 *
 * @author Jennyfer
 */
@Local
public interface MenuViewSessionBeanLocal {

    public String getOrientation();

    public void setOrientation(String orientation);
    
}
