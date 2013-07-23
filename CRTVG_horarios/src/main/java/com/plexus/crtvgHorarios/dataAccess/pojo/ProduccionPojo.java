package com.plexus.crtvgHorarios.dataAccess.pojo;

import com.plexus.crtvgHorarios.dataAccess.pojo.common.BasePojo;

public class ProduccionPojo extends BasePojo{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idProduccion;
	private String nombreProduccion;
	private String familiaProduccion;
	
	public String getIdProduccion() {
		return idProduccion;
	}
	public void setIdProduccion(String idProduccion) {
		this.idProduccion = idProduccion;
	}
	public String getNombreProduccion() {
		return nombreProduccion;
	}
	public void setNombreProduccion(String nombreProduccion) {
		this.nombreProduccion = nombreProduccion;
	}
	public String getFamiliaProduccion() {
		return familiaProduccion;
	}
	public void setFamiliaProduccion(String familiaProduccion) {
		this.familiaProduccion = familiaProduccion;
	}

	
	
}
