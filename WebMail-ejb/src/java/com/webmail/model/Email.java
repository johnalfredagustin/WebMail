/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.model;

import java.util.List;

/**
 *
 * @author John Agustin
 */
public class Email {
    
    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String body;
    private String signature;

    public Email(String from, List<String> to, List<String> cc, List<String> bcc, String body, String signature) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.body = body;
        this.signature = signature;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    
    
}

