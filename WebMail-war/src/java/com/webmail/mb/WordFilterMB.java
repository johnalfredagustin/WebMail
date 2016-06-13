/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.mb;

import com.webmail.model.WordFilter;
import com.webmail.utiliity.WordUtility;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author VictorPineda
 */
@Named(value = "wordFilterMB")
@RequestScoped
public class WordFilterMB implements Serializable {

    /**
     * Creates a new instance of WordFilterMB
     */
    public WordFilterMB() {
    }
    
    WordFilter wordfilter = new WordFilter();

    public WordFilter getWordfilter() {
        return wordfilter;
    }

    public void setWordfilter(WordFilter wordfilter) {
        this.wordfilter = wordfilter;
    }
    
    public List<WordFilter> getFilteredWordList() throws IOException {
        return WordUtility.getAllWords();
    }
    
       public String addAction() throws IOException {
        WordFilter wordFilter = new WordFilter(WordUtility.getAllWords().size()+1, getWordfilter().getWord());
        boolean isAdded = WordUtility.addWord(wordFilter);
        return null;
    }
    public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Word Edited",((WordFilter) event.getObject()).getWord());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
       
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Operation Cancelled");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        WordUtility.deleteWord((WordFilter) event.getObject());
    } 
    
}
