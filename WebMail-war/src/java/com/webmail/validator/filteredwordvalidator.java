/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webmail.validator;

import com.webmail.mb.EmailMB;
import com.webmail.model.WordFilter;
import com.webmail.utiliity.WordUtility;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author VictorPineda
 */
@ManagedBean
@SessionScoped
@FacesValidator("filteredwordvalidator")
public class filteredwordvalidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
      
        try {
            EmailMB emailmb = new EmailMB();
            String message = (String) value;
            if (emailmb.isContainingRestrictedWord(message))
            {
                FacesMessage msg = new FacesMessage(
                        "Your Message contains restricted words, Please modify and send it again.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            }
        } catch (IOException ex) {
            Logger.getLogger(filteredwordvalidator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
}
