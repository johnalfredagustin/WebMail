/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.ejb;

import com.webmail.utiliity.EmailUtility;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.mail.Message;
import org.hibernate.validator.internal.util.logging.Messages;

/**
 *
 * @author John Agustin
 */
@Stateful
@LocalBean
public class EmailSessionBean {

    public void sendEmail() {
        
    }
    
    public List<Message> getInbox() {
        return EmailUtility.getInbox("", "");
    }
    
}
