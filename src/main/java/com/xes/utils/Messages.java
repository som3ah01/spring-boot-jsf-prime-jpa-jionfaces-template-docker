package com.xes.utils;
/*
* @author Som3ah
* @since 2015-06-14
*/
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Named(value = "msg")
@ViewScoped
public class Messages implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
    private MessageSource messageSource;
	
	@Getter@Setter
	private String local;// example of Arabic "ar"
	

    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
    	Locale locale = ( local == null ||local.isBlank() || local.isEmpty()  ) ? 
    			FacesContext.getCurrentInstance().getExternalContext().getRequestLocale() : new Locale(local);
        accessor = new MessageSourceAccessor(messageSource, locale);
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }

}
