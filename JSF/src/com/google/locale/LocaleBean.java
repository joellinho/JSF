package com.google.locale;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@SessionScoped
public class LocaleBean {

	private Locale locale;

	// Marge with GitHub ( 23-02-14 20:37:00 )
	// Add Test Message
	
	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}
	public Locale getLocale() {
		return locale;
	}
	public String getLanguage() {
		return locale.getLanguage();
	}
	public void setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
