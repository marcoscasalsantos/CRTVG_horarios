package com.plexus.crtvgHorarios.dataAccess.pojo;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;

public class UbicacionPojo extends BasePojo{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idUbicacion;
	private String nombreUbicacion;
	private String fase;
	
	public String getIdUbicacion() {
		return idUbicacion;
	}
	public void setIdUbicacion(String idUbicacion) {
		this.idUbicacion = idUbicacion;
	}
	public String getNombreUbicacion() {
		return nombreUbicacion;
	}
	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
			
}
