package com.plexus.crtvgHorarios.view.common.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;




@FacesConverter("centroConverter")
public class CentroConverter implements Converter {


	public Object getAsObject(FacesContext arg0, UIComponent component, String value) throws ConverterException {

		/*
		try{
			
			// El idCentro es lo que se toma como parámetro value
			
			if (value == null || value == "")
				return null;
						
			CambioService cambioService = FacesUtils.getService("cambioService", CambioService.class);
			
			CentroDto centro = cambioService.getCentroByCodigo(value);
			
			return centro;
			
			// OJO: Acordarse de implementar el metodo equals del correspondiente objetoDto
			
		} catch (Exception exception) {
			throw new ConverterException(exception);
		}
		*/
		
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent component, Object value) throws ConverterException {

		/*
		try {
			
			// El código el lo que se toma como el String a devolver
			
			CentroDto centro = (CentroDto) value; 
						
			return centro.getCodigo(); 
			
			
		} catch (Exception exception) {
			throw new ConverterException(exception);
		}
		*/
		return null;
	}
	
	
	
}
