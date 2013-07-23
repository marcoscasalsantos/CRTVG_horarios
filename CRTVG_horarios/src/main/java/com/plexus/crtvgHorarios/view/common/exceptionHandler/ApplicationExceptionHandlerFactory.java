package com.plexus.crtvgHorarios.view.common.exceptionHandler;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;


/**
 * 
 * @author mcs
 * @see http://jugojava.blogspot.com/2010/09/jsf-2-exception-handling.html
 *
 */
public class ApplicationExceptionHandlerFactory extends ExceptionHandlerFactory {
 
private ExceptionHandlerFactory parent;

	//this injection handles jsf 
	public ApplicationExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	//create Application own ExceptionHandler 
	@Override
	public ExceptionHandler getExceptionHandler() {
		ExceptionHandler result = parent.getExceptionHandler();
		result = new ApplicationExceptionHandler(result);
	 
		return result;
	}
}
