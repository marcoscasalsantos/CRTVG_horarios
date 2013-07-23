package com.plexus.crtvgHorarios.dataAccess.pojo;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;

public class SeccionPojo extends BasePojo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idSeccion;
	private String nombreSeccion;
	
	public Long getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(Long idSeccion) {
		this.idSeccion = idSeccion;
	}
	public String getNombreSeccion() {
		return nombreSeccion;
	}
	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}
	
	
	
		
	
}
