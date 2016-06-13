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

    private String preferedWordFiltering;

    public Setting(String preferedWordFiltering) {
        this.preferedWordFiltering = preferedWordFiltering;
    }

    public String getPreferedWordFiltering() {
        return preferedWordFiltering;
    }

    public void setPreferedWordFiltering(String preferedWordFiltering) {
        this.preferedWordFiltering = preferedWordFiltering;
    }

}
