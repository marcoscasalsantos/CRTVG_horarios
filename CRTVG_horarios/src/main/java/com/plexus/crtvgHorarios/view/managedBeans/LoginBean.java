/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.plexus.crtvgHorarios.view.managedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;

import com.plexus.crtvgHorarios.dto.users.UserDto;
import com.plexus.crtvgHorarios.view.common.FacesUtils;




@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Podría inyectarse los servicios con el autowire de spring si la clase estuviese anotada como @component
	// o @Controller
	// en lugar de como @managedBean, creo que es preferible hacerlo así utilizando la clase ServiceUtils ya que resulta 
	// más cómodo usar las ventajas de anotar como managedBean y además el managedBean podría utilizar varios servicios, por
	// lo que añaadirlos todos como atributos autowired "ensuciaría" más el código
	// UserService userService = ServiceUtils.getService("userService", UserService.class);	
	
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public boolean isUserLoggedIn() {
		if (SecurityContextHolder.getContext().getAuthentication() != null) return true;
				 return false;
	}
	
	public UserDto getLoggedUser() {		
		UserDto loggedUser = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 

		return loggedUser;
	}

    // public String doLoginAction() throws IOException {
	
	public void executeLogin(ActionEvent e) throws ServletException, IOException {
				
		/*
		 * El siguiente código es necesario para que el filtro de Spring-Security intercepte
		 * la request del login ya que no funciona poner action="\j_spring_security_check" en la request del form
		 * como se haría si fuese una página jsp en lugar de una xhtml de facelets.
		 * 
		 * La ventaja es que la página de login no está condicionada por spring-security
		 */
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();             
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_check?j_username=" + username + "&j_password=" + password);        
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse()); 
        FacesContext.getCurrentInstance().responseComplete();

        
        // Fija el locale a gl al logearse
        Locale locale = new Locale("gl", "");
        org.omnifaces.util.Faces.setLocale(locale);
        
        /**
        // Añade el item "Menú principal" al breadCrumb.
        BreadCrumbBean breadCrumBean = FacesUtils.getManagedBean("breadCrumbBean", BreadCrumbBean.class);
        
		MenuItem item = new MenuItem();
				
		//MethodExpression methodExpression = FacesUtils.createMethodExpression("#{breadCrumbBean.goMenuPrincipal}"+"?faces-redirect=true", null, new Class<?>[0]);
		
		item.setId("menuPrincipalMenuItem");
		item.setValue("Menú principal");
		item.setUrl("/pages/menuPrincipal.xhtml");
		
		//item.setActionExpression(methodExpression);
	
		breadCrumBean.addItem(item);
    	**/
        
        // FIXME: Tras logearse se está perdiendo el locale si esté está definido como gl
		
	}

	public String doCerrarSesionAction() {

		FacesUtils.invalidateSession();

		return "login";
	}

}