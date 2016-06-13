/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.model;

import java.io.Serializable;

/**
 *
 * @author John Agustin
 */
public class Setting implements Serializable {

    private WordFilterEnum preferedWordFiltering;
    private String emailSignature;
    
    public Setting()
    {
        
    }
    public Setting(WordFilterEnum preferedWordFiltering) {
        this.preferedWordFiltering = preferedWordFiltering;
    }

    public WordFilterEnum getPreferedWordFiltering() {
        return preferedWordFiltering;
    }

    public void setPreferedWordFiltering(WordFilterEnum preferedWordFiltering) {
        this.preferedWordFiltering = preferedWordFiltering;
    }

    public String getEmailSignature() {
        return emailSignature;
    }

    public void setEmailSignature(String emailSignature) {
        this.emailSignature = emailSignature;
    }

    
}
