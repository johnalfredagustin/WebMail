/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author Jennyfer
 */
@Stateful
@LocalBean
public class menuViewSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String orientation = "horizontal";

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
