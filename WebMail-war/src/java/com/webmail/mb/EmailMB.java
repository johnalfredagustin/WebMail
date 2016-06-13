/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.mb;

import com.webmail.ejb.EmailSessionBean;
import com.webmail.model.WordFilter;
import com.webmail.utiliity.WordUtility;
import java.io.IOException;
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
    
    public boolean isContainingRestrictedWord(String message) throws IOException
    {
        for (WordFilter word : WordUtility.getAllWords())
        {
            if (message.toLowerCase().contains(word.getWord().toLowerCase()))
            {
             return true;
            }
        
        }
        return false;
    }
    
    public String MaskIfContainingRestrictedWord(String message) throws IOException
    {
        String newMaskWords="";
        for (WordFilter word : WordUtility.getAllWords())
        {
            if (message.toLowerCase().contains(word.getWord().toLowerCase()))
            {
             newMaskWords = message.replace(word.getWord(), MaskWord(word.getWord()));
            }
        
        }
        
        return newMaskWords;

    }
    
    private String MaskWord(String word)
    {
        String maskWord="";
    
        for (int i=0; i<word.length(); i++)
        {
           maskWord = maskWord + "*";
        }
        
        return maskWord;
    
    }
    
}
