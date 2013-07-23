package com.plexus.crtvgHorarios.view.common.exceptionHandler;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author mcs
 * @see http://jugojava.blogspot.com/2010/09/jsf-2-exception-handling.html
 * 
 * Handler para JSF 2 que en caso de excepción navega a la página de viewExpired o error según el tipo de excepción.
 * 
 *
 */
public class ApplicationExceptionHandler extends ExceptionHandlerWrapper {
	
	private static Logger log = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
	private ExceptionHandler wrapped;

	public ApplicationExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
				
		for (Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator(); events.hasNext();) {
			
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			
			Throwable t = context.getException();
			
			log.error("Serious error happened!", t); 
			
			if (t instanceof ViewExpiredException) {			
				try {
					ViewExpiredException vee = (ViewExpiredException) t;
					
					//TODO: Mejor solución para gestionar una ViewExpiredException sería mostrar la página de login y un dialogo
					// con el mensaje de que la sesion ha caducado superpuesto. (ver ejemplo en el showcase de primefaces)
					
					FacesContext facesContext = FacesContext.getCurrentInstance();
					Map<String, Object> requestMap = facesContext.getExternalContext().getRequestMap();
					NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
	
					navigationHandler.handleNavigation(facesContext, null, "/viewExpired?faces-redirect=true");
					facesContext.renderResponse();
				} finally {
					events.remove();
				}					
			}
			else {				
				try {
										
					FacesContext facesContext = FacesContext.getCurrentInstance();	                
	                NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();  										
					
					// Push some useful stuff to the request scope for use in the error page
                    facesContext.getExternalContext().getFlash().put("exceptionInfo",t.getCause());   

                    // FIXME: porque no navega a la direcci#n indicada
                    navigationHandler.handleNavigation(facesContext, null, "/error?faces-redirect=true");                    
                    
                    facesContext.renderResponse();  					
					
				} finally {
					events.remove();
				}				
			}
		}
			
		// At this point, the queue will not contain any ViewExpiredEvents.
		// Therefore, let the parent handle them.
		getWrapped().handle();

	}
}