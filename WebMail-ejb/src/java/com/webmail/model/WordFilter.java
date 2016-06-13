/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.model;

import java.io.Serializable;

/**
 *
 * @author VictorPineda
 */
public class WordFilter implements Serializable {
    
    private int id;
    private String word;

    public WordFilter() {
    }
    

    public WordFilter(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    
}
