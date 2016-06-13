/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.mb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author John Agustin
 */
@Named(value = "emailMB")
@SessionScoped
public class EmailMB implements Serializable {

    /**
     * Creates a new instance of EmailMB
     */
    public EmailMB() {
    }
    
}
