package com.plexus.crtvgHorarios.view.managedBeans;

import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.plexus.crtvgHorarios.view.common.FacesUtils;



@ManagedBean(name = "localeBean")
@SessionScoped
public class LocaleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Devuelve el timeZone por defecto del sistema, (necesario para convertir
	 * correctamente la fecha en los componentes JSF)
	 */
	
	//private Locale locale = org.omnifaces.util.Faces.getDefaultLocale();
	private Locale locale = new Locale("gl", "");
	

	public TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}	
	
	public Locale getLocale() {
		return this.locale;
	}	
	
	public void setLanguage(String language) {
		this.locale = new Locale(language);
		org.omnifaces.util.Faces.setLocale(locale);
	}
	
	public String getLanguage() {
		return this.locale.getLanguage();
	}
	
	public String doSetLocaleLanguageCastellanoAction() {
		
		Locale locale = new Locale("es", "");
		
		this.locale = locale;
		org.omnifaces.util.Faces.setLocale(locale);
		//FacesUtils.setLocale(locale);

		return null;
	}
	
	public String doSetLocaleLanguageGallegoAction() {
		
		Locale locale = new Locale("gl", "");
		
		this.locale = locale;
		org.omnifaces.util.Faces.setLocale(locale);
		//FacesUtils.setLocale(locale);
		
		return null;
	}	
	
}
