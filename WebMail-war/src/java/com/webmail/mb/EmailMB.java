/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.mb;

import com.webmail.ejb.EmailSessionBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.mail.Message;

/**
 *
 * @author John Agustin
 */
@Named(value = "emailMB")
@SessionScoped
public class EmailMB implements Serializable {

    @EJB
    EmailSessionBean emailSessionBean;
    
    public EmailMB() {
    }
    
    public List<Message> getInbox() {
        
        List<Message> temp = emailSessionBean.getInbox();
        
        return emailSessionBean.getInbox();
    }
    
}
